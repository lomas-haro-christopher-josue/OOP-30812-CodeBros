package ec.edu.espe.Billing.model;
import org.bson.Document;

/**
 *
 * @author Christopher Lomas, <Code_Bros , @ESPE>
 */
public class Cashier {
    private String id;
    private String name;
    private String userName;
    private String password;

   
    public Cashier() {
    }

   
    public Cashier(String id, String name, String userName, String password) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cashier{" + "id=" + id + ", name=" + name + ", userName=" + userName + '}';
    }

   
    public Document toDocument() {
        return new Document("_id", this.id) 
                .append("name", this.name)
                .append("userName", this.userName)
                .append("password", this.password);
    }
}