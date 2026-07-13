package ec.edu.espe.Billing.view;

import javax.swing.JOptionPane;

/**
 * @author Christopher Lomas
 */
public class FrmCustomerRegistration extends javax.swing.JFrame {
    
    public FrmCustomerRegistration() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JLabel();
        txtCustomerAddress = new javax.swing.JLabel();
        txtCustomerEmail = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtRuc = new javax.swing.JTextField();
        txtcustomerName = new javax.swing.JTextField();
        txtcustomerAddress = new javax.swing.JTextField();
        txtcustomerEmail = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CUSTOMER REGISTRATION");

        jLabel2.setText("RUC (10 digits):");

        txtCustomerName.setText("Name:");

        txtCustomerAddress.setText("Address:");

        txtCustomerEmail.setText("Email:");

        btnSave.setText("Save");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnBack.setText("Back to Main Menu");
        btnBack.addActionListener(this::btnBackActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCustomerName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCustomerAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCustomerEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRuc, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(txtcustomerName)
                                    .addComponent(txtcustomerAddress)
                                    .addComponent(txtcustomerEmail)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(btnBack)))))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomerName)
                    .addComponent(txtcustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomerAddress)
                    .addComponent(txtcustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomerEmail)
                    .addComponent(txtcustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnBack))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        java.util.regex.Pattern path = java.util.regex.Pattern.compile(emailRegex);
        return path.matcher(email).matches();
    }

    private boolean validateCustomerFields() {
        if (txtRuc.getText().trim().isEmpty() || 
            txtcustomerName.getText().trim().isEmpty() || 
            txtcustomerAddress.getText().trim().isEmpty() || 
            txtcustomerEmail.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, 
                "All fields are required.", 
                "Empty Fields", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isValidEmail(txtcustomerEmail.getText().trim())) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid email address.", 
                "Invalid Email", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        if (validateCustomerFields()) {
            String ruc = txtRuc.getText().trim();
            String name = txtcustomerName.getText().trim();
            String address = txtcustomerAddress.getText().trim();
            String email = txtcustomerEmail.getText().trim();
            
            try {
                com.mongodb.client.MongoDatabase database = ec.edu.espe.Billing.utils.MongoDBConnection.getDatabase();
                com.mongodb.client.MongoCollection<org.bson.Document> collection = database.getCollection("Customer");
                
                org.bson.Document customerDoc = new org.bson.Document()
                        .append("ruc", ruc)
                        .append("name", name)
                        .append("address", address)
                        .append("email", email);
                
                collection.insertOne(customerDoc);
                
                JOptionPane.showMessageDialog(this, 
                    "Customer '" + name + "' successfully registered!", 
                    "Registration Successful", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                txtRuc.setText("");
                txtcustomerName.setText("");
                txtcustomerAddress.setText("");
                txtcustomerEmail.setText("");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, 
                    "Error connecting to database: " + e.getMessage(), 
                    "Connection Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmCustomerRegistration().setVisible(true));
    }

    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel txtCustomerAddress;
    private javax.swing.JLabel txtCustomerEmail;
    private javax.swing.JLabel txtCustomerName;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtcustomerAddress;
    private javax.swing.JTextField txtcustomerEmail;
    private javax.swing.JTextField txtcustomerName;
}
