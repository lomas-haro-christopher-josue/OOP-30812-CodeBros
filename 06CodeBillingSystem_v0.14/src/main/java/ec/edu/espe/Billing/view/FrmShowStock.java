package ec.edu.espe.Billing.view;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JOptionPane;

/**
 * @author Christopher Lomas
 */
public class FrmShowStock extends javax.swing.JFrame {
    private DefaultTableModel tableModel;

    public FrmShowStock() {
        initComponents();
        this.setLocationRelativeTo(null); 
        tableModel = (DefaultTableModel) tblStock.getModel();
        tblStock.setDefaultRenderer(Object.class, new StockRowRenderer());
        
        cmbStockCategory.addActionListener(evt -> loadStockFromMongoDB());
    }

    class StockRowRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, 
                boolean isSelected, boolean hasFocus, int row, int column) {
            
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Object stockValue = table.getValueAt(row, 4);
            
            if (stockValue != null) {
                int stock = Integer.parseInt(stockValue.toString());
                if (stock < 10) {
                    c.setBackground(new Color(255, 204, 204)); 
                    c.setForeground(Color.RED); 
                } else {
                    if (isSelected) {
                        c.setBackground(table.getSelectionBackground());
                        c.setForeground(table.getSelectionForeground());
                    } else {
                        c.setBackground(table.getBackground());
                        c.setForeground(table.getForeground());
                    }
                }
            }
            return c;
        }
    }
    
    private void loadStockFromMongoDB() {
        tableModel.setRowCount(0); 
        
        if (cmbStockCategory.getSelectedIndex() == 0) {
            return;
        }
        
        String selectedCategory = cmbStockCategory.getSelectedItem().toString();
        StringBuilder criticalProductsMessage = new StringBuilder();
        
        try {
            com.mongodb.client.MongoDatabase database = ec.edu.espe.Billing.utils.MongoDBConnection.getDatabase();
            com.mongodb.client.MongoCollection<org.bson.Document> collection = database.getCollection("Product");
            
            org.bson.conversions.Bson filter = com.mongodb.client.model.Filters.eq("category", selectedCategory);
            Iterable<org.bson.Document> documents = collection.find(filter);
            
            for (org.bson.Document doc : documents) {
                String id = doc.getString("productId");
                String name = doc.getString("name");
                double price = doc.getDouble("price");
                int stock = doc.getInteger("stock");
                
                Object[] rowData = { id, name, selectedCategory, price, stock };
                tableModel.addRow(rowData);
                
                if (stock < 10) {
                    criticalProductsMessage.append("- ").append(name)
                                           .append(" (Only ").append(stock).append(" units left)\n");
                }
            }
            
            if (criticalProductsMessage.length() > 0) {
                JOptionPane.showMessageDialog(this, 
                    "CRITICAL INVENTORY ALERT!\n\n" +
                    "Less than 10 units of the following products:\n" + criticalProductsMessage.toString() + 
                    "\nPlease restock as soon as possible.", 
                    "Urgent Restock", 
                    JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error connecting to MongoDB inventory: " + e.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbStockCategory = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("INVENTORY CONTROL");

        jLabel2.setText("Select a Category to Inspect:");

        cmbStockCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a category...", "Snacks", "Normal drinks or juices", "Sodas", "Alcoholic beverages", "Sweets", "Cookies", "Personal care products" }));

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Category", "Price", "Current Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStock);

        btnBack.setText("Back to Main Menu");
        btnBack.addActionListener(this::btnBackActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cmbStockCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(287, 287, 287))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(343, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(294, 294, 294))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cmbStockCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmShowStock().setVisible(true));
    }

    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cmbStockCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStock;
}
