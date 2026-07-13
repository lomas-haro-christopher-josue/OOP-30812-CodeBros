package ec.edu.espe.Billing.view;

import javax.swing.JOptionPane;

/**
 * @author Christopher Lomas
 */
public class FrmProductRegistration extends javax.swing.JFrame {
    
    public FrmProductRegistration() {
        initComponents();
        this.setLocationRelativeTo(null); 
        
        txtIdProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume(); 
                }
            }
        });

        txtProductStock.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume(); 
                }
            }
        });

        txtProductPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                String text = txtProductPrice.getText();

                if (!Character.isDigit(c) && c != '.' && c != ',') {
                    evt.consume();
                    return;
                }

                if ((c == '.' || c == ',') && (text.contains(".") || text.contains(","))) {
                    evt.consume();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtIdProduct = new javax.swing.JTextField();
        txtNameProduct = new javax.swing.JTextField();
        txtProductPrice = new javax.swing.JTextField();
        txtProductStock = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PRODUCT REGISTRATION");

        jLabel2.setText("ID (Numbers):");

        jLabel3.setText("Name:");

        jLabel4.setText("Price (Ex: 10.50):");

        jLabel5.setText("Stock (Numbers):");

        btnSave.setText("Save");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnBack.setText("Back to Main Menu");
        btnBack.addActionListener(this::btnBackActionPerformed);

        jLabel6.setText("Category:");

        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a category...", "Snacks", "Normal drinks or juices", "Sodas", "Alcoholic beverages", "Sweets", "Cookies", "Personal care products" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(txtIdProduct))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNameProduct))))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProductPrice)
                                    .addComponent(txtProductStock))))
                        .addGap(156, 156, 156))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addGap(98, 98, 98))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnBack))
                .addGap(52, 52, 52))
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

    private boolean validateProductFields() {
        if (txtIdProduct.getText().trim().isEmpty() || 
            txtNameProduct.getText().trim().isEmpty() || 
            txtProductPrice.getText().trim().isEmpty() || 
            txtProductStock.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, 
                "All fields are required to register the product.", 
                "Empty Fields", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (cmbCategory.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, 
                "Please select a valid category for the product.", 
                "Category Required", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }

        try {
            String priceText = txtProductPrice.getText().trim().replace(",", ".");
            double price = Double.parseDouble(priceText);

            if (price <= 0) {
                JOptionPane.showMessageDialog(this, "Price must be greater than 0.", "Invalid Price", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (priceText.contains(".")) {
                String decimals = priceText.substring(priceText.indexOf(".") + 1);
                if (decimals.length() > 2) {
                    JOptionPane.showMessageDialog(this, 
                        "Price can only have a maximum of 2 decimal places (ex: 10.50).", 
                        "Format Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price format.", "Numeric Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        if (validateProductFields()) {
            String id = txtIdProduct.getText().trim();
            String name = txtNameProduct.getText().trim();
            double price = Double.parseDouble(txtProductPrice.getText().trim().replace(",", "."));
            int stock = Integer.parseInt(txtProductStock.getText().trim());
            String category = cmbCategory.getSelectedItem().toString();
            
            try {
                com.mongodb.client.MongoDatabase database = ec.edu.espe.Billing.utils.MongoDBConnection.getDatabase();
                com.mongodb.client.MongoCollection<org.bson.Document> collection = database.getCollection("Product");
                
                org.bson.Document productDoc = new org.bson.Document()
                        .append("productId", id)
                        .append("name", name)
                        .append("category", category)
                        .append("price", price)
                        .append("stock", stock);
                
                collection.insertOne(productDoc);
                
                JOptionPane.showMessageDialog(this, 
                    "Product '" + name + "' successfully registered in category " + category + "!", 
                    "Registration Successful", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                txtIdProduct.setText("");
                txtNameProduct.setText("");
                txtProductPrice.setText("");
                txtProductStock.setText("");
                cmbCategory.setSelectedIndex(0); 
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, 
                    "Error saving to database: " + e.getMessage(), 
                    "Connection Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmProductRegistration().setVisible(true));
    }

    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIdProduct;
    private javax.swing.JTextField txtNameProduct;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductStock;
}
