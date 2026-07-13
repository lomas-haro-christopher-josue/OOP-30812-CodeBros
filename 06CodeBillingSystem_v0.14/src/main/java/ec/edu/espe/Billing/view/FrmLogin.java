package ec.edu.espe.Billing.view;

import com.mongodb.client.MongoDatabase;
import ec.edu.espe.Billing.utils.MongoDBConnection;
import javax.swing.JOptionPane;
import java.awt.Color;

public class FrmLogin extends javax.swing.JFrame {
    private MongoDatabase database;

    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(null); 
        connectDatabase();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("LA VICTORIA SUPERMARKET");

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        btnLogin.setText("Login");
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        lblStatus.setText("Connecting to Database...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(111, 111, 111))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnLogin)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtPassword))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblStatus)
                .addGap(22, 22, 22)
                .addComponent(btnLogin)
                .addContainerGap(105, Short.MAX_VALUE))
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

    private void connectDatabase() {
        try {
            database = MongoDBConnection.getDatabase();
            if (database != null) {
                lblStatus.setText("Successfully connected to MongoDB Atlas.");
                lblStatus.setForeground(new Color(0, 153, 51));
            } else {
                lblStatus.setText("Connection error: database returned null.");
                lblStatus.setForeground(Color.RED);
            }
        } catch (Exception e) {
            lblStatus.setText("Error connecting to Database.");
            lblStatus.setForeground(Color.RED);
            JOptionPane.showMessageDialog(this, 
                "Could not establish connection with database:\n" + e.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please fill in all required fields.", 
                "Missing Data", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (username.equals("MayraJHF") && password.equals("171206")) {
            JOptionPane.showMessageDialog(this, 
                "Access granted! Welcome to La Victoria Supermarket.", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); 
            java.awt.EventQueue.invokeLater(() -> {
                FrmMenu mainMenu = new FrmMenu("admin");
                mainMenu.setVisible(true);
            });
            return;
        } 
        
        if (username.equals("santiagolomas") && password.equals("santiago123")) {
            JOptionPane.showMessageDialog(this, 
                "Access granted!\nWelcome, Cashier Santiago Lomas.", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            java.awt.EventQueue.invokeLater(() -> {
                FrmMenu mainMenu = new FrmMenu("cashier");
                mainMenu.setVisible(true);
            });
            return;
        } 
        
        if (username.equals("mateolomas") && password.equals("mateo123")) {
            JOptionPane.showMessageDialog(this, 
                "Access granted!\nWelcome, Cashier Mateo Lomas.", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            java.awt.EventQueue.invokeLater(() -> {
                FrmMenu mainMenu = new FrmMenu("cashier");
                mainMenu.setVisible(true);
            });
            return;
        } 
        
        try {
            com.mongodb.client.MongoDatabase db = ec.edu.espe.Billing.utils.MongoDBConnection.getDatabase();
            com.mongodb.client.MongoCollection<org.bson.Document> usersCollection = db.getCollection("Users");
            org.bson.Document userQuery = usersCollection.find(com.mongodb.client.model.Filters.eq("username", username)).first();
            
            if (userQuery != null) {
                String passwordBD = userQuery.getString("password");
                String role = userQuery.getString("role");
                
                if (password.equals(passwordBD)) {
                    JOptionPane.showMessageDialog(this, 
                        "Access granted! Role: " + role.toUpperCase(), 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    java.awt.EventQueue.invokeLater(() -> {
                        FrmMenu mainMenu = new FrmMenu(role);
                        mainMenu.setVisible(true);
                    });
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect password.", "Authentication Failure", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "User does not exist in database.", "Authentication Failure", JOptionPane.ERROR_MESSAGE);
                txtPassword.setText("");
                txtUsername.requestFocus();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Connection error while validating user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmLogin().setVisible(true));
    }

    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
}
