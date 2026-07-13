package ec.edu.espe.Billing.view;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import ec.edu.espe.Billing.model.Invoice;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

public class FrmSale extends javax.swing.JFrame {

    private ArrayList<String> customerIds = new ArrayList<>();
    private ArrayList<String> productIds = new ArrayList<>();
    private DefaultTableModel tableModel;
    private Invoice currentInvoice;

    public FrmSale() {
        initComponents();
        this.setLocationRelativeTo(null);
        initTable();
        loadCategoriesFromMongoDB();
        loadCustomersFromMongoDB();
        updateInvoiceNumber();
        
        cmbCategoryFilter.addActionListener(evt -> loadProductsByCategory());
    }

    private void initTable() {
        tableModel = new DefaultTableModel(new Object[]{"Product", "Quantity", "Price", "Total"}, 0);
        tblItems.setModel(tableModel);
    }

    private void updateInvoiceNumber() {
        try {
            MongoDatabase database = ec.edu.espe.Billing.utils.MongoDBConnection.getDatabase();
            MongoCollection<Document> collection = database.getCollection("Invoices");
            Document doc = collection.find().sort(Sorts.descending("invoiceNumber")).first();
            int nextNum = (doc != null) ? doc.getInteger("invoiceNumber") + 1 : 1;
            txtInvoiceNumber.setText(String.valueOf(nextNum));
        } catch (Exception e) {
            txtInvoiceNumber.setText("1");
        }
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRegisterSale = new javax.swing.JButton();
        txtInvoiceNumber = new javax.swing.JTextField();
        cmbProduct = new javax.swing.JComboBox<>();
        cmbPaymentMethod = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        cmbCustomer = new javax.swing.JComboBox<>();
        cmbCashier = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbCategoryFilter = new javax.swing.JComboBox<>();
        spnQuantity = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        txtCashReceived = new javax.swing.JTextField();
        btnAddProduct = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        jLabel1.setText("MAKE SALE");

        jLabel2.setText("Invoice No:");

        jLabel3.setText("Cashier:");

        jLabel4.setText("Select Customer:");

        jLabel5.setText("Select Product:");

        jLabel6.setText("Quantity:");

        jLabel7.setText("Payment Method:");

        btnRegisterSale.setText("Register Sale");
        btnRegisterSale.addActionListener(this::btnRegisterSaleActionPerformed);

        txtInvoiceNumber.setEditable(false);

        cmbPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Transfer", "Card" }));
        cmbPaymentMethod.addActionListener(this::cmbPaymentMethodActionPerformed);

        btnBack.setText("Back to Menu");
        btnBack.addActionListener(this::btnBackActionPerformed);

        cmbCashier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Santiago Lomas", "Mateo Lomas" }));

        jLabel8.setText("Category:");

        cmbCategoryFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a category..." }));

        spnQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel9.setText("Cash Received:");

        txtCashReceived.setEnabled(false);

        btnAddProduct.setText("Add Product");
        btnAddProduct.addActionListener(this::btnAddProductActionPerformed);

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Product", "Quantity", "Price", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblItems);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtInvoiceNumber)
                                    .addComponent(cmbCashier, 0, 150, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbCategoryFilter, 0, 200, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbProduct, 0, 200, Short.MAX_VALUE)
                                    .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnAddProduct))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbPaymentMethod, 0, 120, Short.MAX_VALUE)
                                    .addComponent(txtCashReceived))
                                .addGap(100, 100, 100)
                                .addComponent(btnRegisterSale, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCashier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbCategoryFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddProduct))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisterSale)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCashReceived, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {
        int productIndex = cmbProduct.getSelectedIndex();
        int quantity = (Integer) spnQuantity.getValue();

        if (productIndex <= 0) {
            JOptionPane.showMessageDialog(this, "Select a product.");
            return;
        }

        String productId = productIds.get(productIndex);
        try {
            MongoDatabase database = ec.edu.espe.Billing.utils.MongoDBConnection.getDatabase();
            MongoCollection<Document> collection = database.getCollection("Product");
            Document productDoc = collection.find(Filters.eq("productId", productId)).first();

            if (productDoc != null) {
                int stock = productDoc.getInteger("stock");
                String name = productDoc.getString("name");
                double price = productDoc.getDouble("price");

                if (quantity > stock) {
                    JOptionPane.showMessageDialog(this, "Insufficient stock.");
                    return;
                }

                if (currentInvoice == null) {
                    int invNum = Integer.parseInt(txtInvoiceNumber.getText());
                    String cashier = cmbCashier.getSelectedItem().toString();
                    String customer = cmbCustomer.getSelectedItem().toString();
                    currentInvoice = new Invoice(invNum, cashier, customer);
                }

                currentInvoice.addItem(name, quantity, price);
                tableModel.addRow(new Object[]{name, quantity, price, quantity * price});
                
                collection.updateOne(Filters.eq("productId", productId), new org.bson.Document("$set", new org.bson.Document("stock", stock - quantity)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error adding product: " + e.getMessage());
        }
    }

    private void btnRegisterSaleActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentInvoice == null || currentInvoice.getItems().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No items added.");
            return;
        }

        String paymentMethod = cmbPaymentMethod.getSelectedItem().toString();
        double total = currentInvoice.getTotal();
        double cashReceived = 0.0;

        if (paymentMethod.equalsIgnoreCase("Cash")) {
            try {
                cashReceived = Double.parseDouble(txtCashReceived.getText());
                if (cashReceived < total) {
                    JOptionPane.showMessageDialog(this, "Insufficient cash.");
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid cash amount.");
                return;
            }
        }

        try {
            MongoDatabase database = ec.edu.espe.Billing.utils.MongoDBConnection.getDatabase();
            MongoCollection<Document> collection = database.getCollection("Invoices");
            
            Document doc = currentInvoice.toDocument();
            doc.append("paymentMethod", paymentMethod);
            doc.append("cashReceived", cashReceived);
            doc.append("timestamp", new Date());
            
            collection.insertOne(doc);
            JOptionPane.showMessageDialog(this, "Sale registered successfully.");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error registering sale: " + e.getMessage());
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void cmbPaymentMethodActionPerformed(java.awt.event.ActionEvent evt) {
        txtCashReceived.setEnabled(cmbPaymentMethod.getSelectedItem().toString().equalsIgnoreCase("Cash"));
    }

    private void loadCustomersFromMongoDB() {
        cmbCustomer.removeAllItems();
        customerIds.clear();
        cmbCustomer.addItem("Select a customer...");
        customerIds.add("");
        try {
            MongoDatabase database = ec.edu.espe.Billing.utils.MongoDBConnection.getDatabase();
            MongoCollection<Document> collection = database.getCollection("Customer");
            for (Document doc : collection.find()) {
                String ruc = doc.getString("ruc");
                String name = doc.getString("name");
                cmbCustomer.addItem(name + " (" + ruc + ")");
                customerIds.add(ruc);
            }
        } catch (Exception e) {}
    }

    private void loadCategoriesFromMongoDB() {
        cmbCategoryFilter.removeAllItems();
        cmbCategoryFilter.addItem("Select a category...");
        try {
            MongoDatabase database = ec.edu.espe.Billing.utils.MongoDBConnection.getDatabase();
            MongoCollection<Document> collection = database.getCollection("Categories");
            for (Document doc : collection.find()) {
                cmbCategoryFilter.addItem(doc.getString("name"));
            }
        } catch (Exception e) {}
    }

    private void loadProductsByCategory() {
        cmbProduct.removeAllItems();
        productIds.clear();
        cmbProduct.addItem("Select a product...");
        productIds.add("");
        if (cmbCategoryFilter.getSelectedIndex() <= 0) return;
        String category = cmbCategoryFilter.getSelectedItem().toString();
        try {
            MongoDatabase database = ec.edu.espe.Billing.utils.MongoDBConnection.getDatabase();
            MongoCollection<Document> collection = database.getCollection("Product");
            for (Document doc : collection.find(Filters.eq("category", category))) {
                String id = doc.getString("productId");
                String name = doc.getString("name");
                int stock = doc.getInteger("stock");
                cmbProduct.addItem(name + " (" + stock + ")");
                productIds.add(id);
            }
        } catch (Exception e) {}
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmSale().setVisible(true));
    }

    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegisterSale;
    private javax.swing.JComboBox<String> cmbCashier;
    private javax.swing.JComboBox<String> cmbCategoryFilter;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbPaymentMethod;
    private javax.swing.JComboBox<String> cmbProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tblItems;
    private javax.swing.JTextField txtCashReceived;
    private javax.swing.JTextField txtInvoiceNumber;
}
