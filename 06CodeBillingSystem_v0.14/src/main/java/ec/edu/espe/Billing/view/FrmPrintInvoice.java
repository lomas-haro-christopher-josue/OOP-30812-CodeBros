package ec.edu.espe.Billing.view;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;

public class FrmPrintInvoice extends javax.swing.JFrame {

    public FrmPrintInvoice() {
        initComponents();
        this.setLocationRelativeTo(null);
        generateInvoice();
    }

    private void generateInvoice() {
        try {
            MongoDatabase database = ec.edu.espe.Billing.utils.MongoDBConnection.getDatabase();
            MongoCollection<Document> invoiceCollection = database.getCollection("Invoices");
            MongoCollection<Document> companyCollection = database.getCollection("Company");

            Document companyDoc = companyCollection.find().first();
            String compName = "SUPERMARKET <CODE_BROS>";
            String compRuc = "1792456789001";
            String compAddress = "Sangolqui, Ecuador";

            if (companyDoc != null) {
                compName = companyDoc.getOrDefault("companyName", compName).toString();
                compRuc = companyDoc.getOrDefault("ruc", compRuc).toString();
                compAddress = companyDoc.getOrDefault("address", compAddress).toString();
            }

            Document lastInvoice = invoiceCollection.find().sort(Sorts.descending("timestamp")).first();

            if (lastInvoice == null) {
                txtInvoicePreview.setText("\n\n\t[ALERT]: No recent sales found.");
                return;
            }

            StringBuilder ticket = new StringBuilder();
            ticket.append("=========================================\n");
            ticket.append("         ").append(compName.toUpperCase()).append("\n");
            ticket.append("         RUC: ").append(compRuc).append("\n");
            ticket.append("   Address: ").append(compAddress).append("\n");
            ticket.append("=========================================\n");
            ticket.append(" INVOICE NO: ").append(lastInvoice.get("invoiceNumber")).append("\n");
            ticket.append(" DATE:       ").append(lastInvoice.get("date")).append("\n");
            ticket.append(" CASHIER:    ").append(lastInvoice.get("cashier")).append("\n");
            ticket.append("-----------------------------------------\n");
            ticket.append(" CUSTOMER:   ").append(lastInvoice.get("customer")).append("\n");
            ticket.append("=========================================\n");
            ticket.append(String.format("%-20s %-5s %-10s\n", "PRODUCT", "QTY", "TOTAL"));
            ticket.append("-----------------------------------------\n");

            List<Document> items = (List<Document>) lastInvoice.get("items");
            for (Document item : items) {
                String name = item.getString("name");
                if (name.length() > 18) name = name.substring(0, 18);
                ticket.append(String.format("%-20s %-5d $%-9.2f\n", name, item.getInteger("quantity"), item.getDouble("total")));
            }

            ticket.append("=========================================\n");
            ticket.append(String.format(" SUBTOTAL:                     $%-9.2f\n", lastInvoice.getDouble("subtotal")));
            ticket.append(String.format(" TOTAL:                        $%-9.2f\n", lastInvoice.getDouble("total")));
            ticket.append("-----------------------------------------\n");
            ticket.append(String.format(" CASH RECEIVED:                $%-9.2f\n", lastInvoice.getDouble("cashReceived")));
            ticket.append(String.format(" CHANGE:                       $%-9.2f\n", lastInvoice.getDouble("cashReceived") - lastInvoice.getDouble("total")));
            ticket.append("-----------------------------------------\n");
            ticket.append(" PAYMENT METHOD: ").append(lastInvoice.get("paymentMethod")).append("\n");
            ticket.append("=========================================\n");
            ticket.append("       Thank you for your purchase!      \n");
            ticket.append("=========================================\n");

            txtInvoicePreview.setText(ticket.toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error generating invoice: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInvoicePreview = new javax.swing.JTextArea();
        btnPrint = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Invoice Preview");

        txtInvoicePreview.setEditable(false);
        txtInvoicePreview.setColumns(20);
        txtInvoicePreview.setFont(new java.awt.Font("Monospaced", 0, 12)); 
        txtInvoicePreview.setRows(5);
        jScrollPane1.setViewportView(txtInvoicePreview);

        btnPrint.setText("Print / Save PDF");
        btnPrint.addActionListener(evt -> {
            try {
                txtInvoicePreview.print();
            } catch (Exception e) {}
        });

        btnBack.setText("Back to Menu");
        btnBack.addActionListener(evt -> this.dispose());

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
    }// </editor-fold>                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmPrintInvoice().setVisible(true));
    }

    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtInvoicePreview;
}
