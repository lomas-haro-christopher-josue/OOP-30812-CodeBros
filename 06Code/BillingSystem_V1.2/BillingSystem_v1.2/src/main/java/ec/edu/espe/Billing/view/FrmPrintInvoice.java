
package ec.edu.espe.Billing.view;
import javax.swing.JOptionPane;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Filters;
/**
 *
 * @author Christopher Lomas,<CodeBros,@ESPE>
 */
public class FrmPrintInvoice extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmPrintInvoice.class.getName());

    /**
     * Creates new form FrmPrintInvoice
     */
    public FrmPrintInvoice() {
        initComponents();
        this.setLocationRelativeTo(null);
        generateAutomaticInvoice();
    }

private void generateAutomaticInvoice() {
        try {
            MongoDatabase database = ec.edu.espe.Billing.utils.MongoDBConnection.getDatabase();
            MongoCollection<Document> saleCollection = database.getCollection("Sales");
            MongoCollection<Document> customerCollection = database.getCollection("Customer");
            MongoCollection<Document> companyCollection = database.getCollection("Company");
            
            
            Document companyDoc = companyCollection.find().first();
            String compName = "SUPERMERCADO <CODE_BROS>"; // Valores de respaldo por defecto
            String compRuc = "1792456789001";
            String compAddress = "Sangolquí, Ecuador";
            
            if (companyDoc != null) {
                
                if (companyDoc.getString("companyName") != null) {
                    compName = companyDoc.getString("companyName");
                }
                if (companyDoc.getString("ruc") != null) {
                    compRuc = companyDoc.getString("ruc");
                }
                if (companyDoc.getString("address") != null) {
                    compAddress = companyDoc.getString("address");
                }
            }
            
           
            Document lastSaleDoc = saleCollection.find().sort(Sorts.descending("timestamp")).first();
            
            if (lastSaleDoc == null) {
                txtInvoicePreview.setText("\n\n\t[ALERTA]: No se registran movimientos de ventas\n\trecientes en el sistema.");
                return;
            }
            
            String invoiceNum = lastSaleDoc.getString("invoiceNumber");
            String cashier = lastSaleDoc.getString("cashier");
            String customerRuc = lastSaleDoc.getString("customerRuc");
            String productName = lastSaleDoc.getString("productName");
            int quantity = lastSaleDoc.getInteger("quantity");
            double totalPay = lastSaleDoc.getDouble("total");
            String paymentMethod = lastSaleDoc.getString("paymentMethod");
            
            double cashReceived = lastSaleDoc.containsKey("cashReceived") ? lastSaleDoc.getDouble("cashReceived") : totalPay;
            
           
            double subtotal = totalPay / 1.15;
            double ivaValue = totalPay - subtotal;
            double change = cashReceived - totalPay;
            
            if (change < 0) {
                change = 0.0;
            }
            
           
            Document customerDoc = customerCollection.find(Filters.eq("ruc", customerRuc)).first();
            String customerName = (customerDoc != null) ? customerDoc.getString("name") : "Consumidor Final";
            
           
            StringBuilder ticket = new StringBuilder();
            ticket.append("=========================================\n");
            ticket.append("         ").append(compName.toUpperCase()).append("\n");
            ticket.append("         RUC: ").append(compRuc).append("\n");
            ticket.append("   Dir: ").append(compAddress).append("\n");
            ticket.append("=========================================\n");
            ticket.append(" FACTURA NRO: ").append(invoiceNum).append("\n");
            ticket.append(" CAJERO:      ").append(cashier).append("\n");
            ticket.append("-----------------------------------------\n");
            ticket.append(" CLIENTE:     ").append(customerName).append("\n");
            ticket.append(" RUC/CI:      ").append(customerRuc).append("\n");
            ticket.append("=========================================\n");
            ticket.append(String.format("%-22s %-5s %-10s\n", "PRODUCTO", "CANT.", "TOTAL"));
            ticket.append("-----------------------------------------\n");
            
            String shortProdName = (productName.length() > 20) ? productName.substring(0, 20) : productName;
            ticket.append(String.format("%-22s %-5d $%-9.2f\n", shortProdName, quantity, totalPay));
            
            ticket.append("=========================================\n");
            ticket.append(String.format(" SUBTOTAL:                     $%-9.2f\n", subtotal));
            ticket.append(String.format(" IVA (15%%):                    $%-9.2f\n", ivaValue));
            ticket.append(String.format(" TOTAL A PAGAR:                $%-9.2f\n", totalPay));
            ticket.append("-----------------------------------------\n");
            ticket.append(String.format(" EFECTIVO RECIBIDO:            $%-9.2f\n", cashReceived));
            ticket.append(String.format(" CAMBIO A ENTREGAR:            $%-9.2f\n", change));
            ticket.append("-----------------------------------------\n");
            ticket.append(" FORMA DE PAGO: ").append(paymentMethod).append("\n");
            ticket.append("=========================================\n");
            ticket.append("       ¡Gracias por su confianza!       \n");
            ticket.append("=========================================\n");
            
            txtInvoicePreview.setText(ticket.toString());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error de enlace automático: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInvoicePreview = new javax.swing.JTextArea();
        btnPrint = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Vista Previa del Comprobante");

        txtInvoicePreview.setEditable(false);
        txtInvoicePreview.setColumns(20);
        txtInvoicePreview.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtInvoicePreview.setRows(5);
        jScrollPane1.setViewportView(txtInvoicePreview);

        btnPrint.setText("Imprimir/Guardar PDF");
        btnPrint.addActionListener(this::btnPrintActionPerformed);

        btnBack.setText("Regresar al Menu Principal");
        btnBack.addActionListener(this::btnBackActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(btnBack)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnPrint))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
    try {
            boolean complete = txtInvoicePreview.print();
            if (complete) {
                JOptionPane.showMessageDialog(this, "Documento enviado a la cola de impresión.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(this, "Fallo de comunicación con la impresora: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    this.dispose();
    }                                       

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FrmPrintInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new FrmPrintInvoice().setVisible(true);
        });
    
    }//GEN-LAST:event_btnBackActionPerformed

    
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtInvoicePreview;
    // End of variables declaration//GEN-END:variables
}
