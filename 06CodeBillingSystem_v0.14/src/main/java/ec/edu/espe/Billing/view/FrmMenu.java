package ec.edu.espe.Billing.view;

import javax.swing.JOptionPane;

public class FrmMenu extends javax.swing.JFrame {
    
    private String userRole;

    public FrmMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public FrmMenu(String role) {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.userRole = role;
        applyRoleRestrictions();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCompany = new javax.swing.JMenu();
        itmRegisterCompany = new javax.swing.JMenuItem();
        mnuCustomer = new javax.swing.JMenu();
        itmRegisterCustomer = new javax.swing.JMenuItem();
        itmDeleteCustomer = new javax.swing.JMenuItem();
        mnuProduct = new javax.swing.JMenu();
        itmRegisterProduct = new javax.swing.JMenuItem();
        itmDeleteProduct = new javax.swing.JMenuItem();
        itmViewInventory = new javax.swing.JMenuItem();
        mnuSales = new javax.swing.JMenu();
        itmCreateSale = new javax.swing.JMenuItem();
        itmPrintInvoice = new javax.swing.JMenuItem();
        mnuReports = new javax.swing.JMenu();
        menuExit = new javax.swing.JMenu();

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Stencil", 3, 36)); 
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME TO LA VICTORIA SUPERMARKET SYSTEM");
        getContentPane().add(jLabel1, java.awt.BorderLayout.CENTER);

        mnuCompany.setText("Company");

        itmRegisterCompany.setText("Register Company");
        itmRegisterCompany.addActionListener(this::itmRegisterCompanyActionPerformed);
        mnuCompany.add(itmRegisterCompany);

        jMenuBar1.add(mnuCompany);

        mnuCustomer.setText("Customer");

        itmRegisterCustomer.setText("Register Customer");
        itmRegisterCustomer.addActionListener(this::itmRegisterCustomerActionPerformed);
        mnuCustomer.add(itmRegisterCustomer);

        itmDeleteCustomer.setText("Delete Customer");
        itmDeleteCustomer.addActionListener(this::itmDeleteCustomerActionPerformed);
        mnuCustomer.add(itmDeleteCustomer);

        jMenuBar1.add(mnuCustomer);

        mnuProduct.setText("Product");

        itmRegisterProduct.setText("Register Product");
        itmRegisterProduct.addActionListener(this::itmRegisterProductActionPerformed);
        mnuProduct.add(itmRegisterProduct);

        itmDeleteProduct.setText("Delete Product");
        itmDeleteProduct.addActionListener(this::itmDeleteProductActionPerformed);
        mnuProduct.add(itmDeleteProduct);

        itmViewInventory.setText("View Inventory");
        itmViewInventory.addActionListener(this::itmViewInventoryActionPerformed);
        mnuProduct.add(itmViewInventory);

        jMenuBar1.add(mnuProduct);

        mnuSales.setText("Sales");

        itmCreateSale.setText("Make Sale");
        itmCreateSale.addActionListener(this::itmCreateSaleActionPerformed);
        mnuSales.add(itmCreateSale);

        itmPrintInvoice.setText("Print Invoice");
        itmPrintInvoice.addActionListener(this::itmPrintInvoiceActionPerformed);
        mnuSales.add(itmPrintInvoice);

        jMenuBar1.add(mnuSales);

        mnuReports.setText("Reports");
        mnuReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuReportsMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuReports);

        menuExit.setText("Exit");
        menuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuExitMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuExit);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>                        

    private void applyRoleRestrictions() {
        if ("cashier".equalsIgnoreCase(userRole)) {
            mnuReports.setEnabled(false); 
        }
    }

    private void itmRegisterCompanyActionPerformed(java.awt.event.ActionEvent evt) {
        FrmCompany companyFrame = new FrmCompany();
        companyFrame.setVisible(true);
    }

    private void itmDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {
        ec.edu.espe.Billing.view.FrmDeleteCustomer deleteCustFrame = new ec.edu.espe.Billing.view.FrmDeleteCustomer();
        deleteCustFrame.setVisible(true);
    }

    private void itmDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {
        FrmDeleteProduct deleteProdFrame = new FrmDeleteProduct();
        deleteProdFrame.setVisible(true);
    }

    private void itmViewInventoryActionPerformed(java.awt.event.ActionEvent evt) {
        FrmShowStock stockFrame = new FrmShowStock();
        stockFrame.setVisible(true);
    }

    private void itmPrintInvoiceActionPerformed(java.awt.event.ActionEvent evt) {
        ec.edu.espe.Billing.view.FrmPrintInvoice printFrame = new ec.edu.espe.Billing.view.FrmPrintInvoice();
        printFrame.setVisible(true);
    }

    private void itmRegisterCustomerActionPerformed(java.awt.event.ActionEvent evt) {
        ec.edu.espe.Billing.view.FrmCustomerRegistration customerRegFrame = new ec.edu.espe.Billing.view.FrmCustomerRegistration();
        customerRegFrame.setVisible(true);
    }

    private void itmRegisterProductActionPerformed(java.awt.event.ActionEvent evt) {
        ec.edu.espe.Billing.view.FrmProductRegistration productRegFrame = new ec.edu.espe.Billing.view.FrmProductRegistration();
        productRegFrame.setVisible(true);
    }

    private void itmCreateSaleActionPerformed(java.awt.event.ActionEvent evt) {
        ec.edu.espe.Billing.view.FrmSale saleFrame = new ec.edu.espe.Billing.view.FrmSale();
        saleFrame.setVisible(true);
    }

    private void menuExitMouseClicked(java.awt.event.MouseEvent evt) {
        int response = javax.swing.JOptionPane.showConfirmDialog(
            this, 
            "Are you sure you want to exit the system?", 
            "Logout", 
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
        );
        
        if (response == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0); 
        }
    }

    private void mnuReportsMouseClicked(java.awt.event.MouseEvent evt) {
        ec.edu.espe.Billing.view.FrmReport reportFrame = new ec.edu.espe.Billing.view.FrmReport();
        reportFrame.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmMenu().setVisible(true);
        });
    }

    private javax.swing.JMenuItem itmCreateSale;
    private javax.swing.JMenuItem itmDeleteCustomer;
    private javax.swing.JMenuItem itmDeleteProduct;
    private javax.swing.JMenuItem itmPrintInvoice;
    private javax.swing.JMenuItem itmRegisterCompany;
    private javax.swing.JMenuItem itmRegisterCustomer;
    private javax.swing.JMenuItem itmRegisterProduct;
    private javax.swing.JMenuItem itmViewInventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuExit;
    private javax.swing.JMenu mnuCompany;
    private javax.swing.JMenu mnuCustomer;
    private javax.swing.JMenu mnuProduct;
    private javax.swing.JMenu mnuReports;
    private javax.swing.JMenu mnuSales;
    private javax.swing.JPanel panelContenedor;
}
