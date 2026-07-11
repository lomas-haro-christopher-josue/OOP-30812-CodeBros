package ec.edu.espe.Billing.controller;

import ec.edu.espe.Billing.model.Cashier;
import ec.edu.espe.Billing.model.IInvoice;
import ec.edu.espe.Billing.model.Invoice;
import ec.edu.espe.Billing.model.Payment;
import java.util.List;

/**
 * @author Didier Elbay, <Code_Bros>,ESPE
 */
public class InvoiceController {
    
    
    private final IInvoice invoiceRepository;


    public InvoiceController(IInvoice invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

  
    public boolean processInvoice(Invoice invoice, Payment payment) {
        if (invoice == null || payment == null) {
            return false;
        }
   
        return invoiceRepository.saveInvoice(invoice, payment);
    }


    public Cashier verifyLogin(String userName, String password) {
        if (userName == null || userName.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            return null;
        }
        return invoiceRepository.login(userName, password);
    }


    public List<Invoice> getSalesReport() {
        return invoiceRepository.findAllInvoices();
    }
}