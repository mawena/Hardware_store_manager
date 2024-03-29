package Models.Entities;

import Models.EntitiesManagers.OrdersManager;

public class Order {

    private int id;

    private int idClient;

    private String clientName;

    private String employerName;

    private int idEmployer;

    private String dateOrder;

    public Order(int id, int idClient, int idEmployer, String dateOrder, String employerName, String clientName) {
        this.setId(id);
        this.setIdClient(idClient);
        this.setIdEmployer(idEmployer);
        this.setDateOrder(dateOrder);
        this.setClientName(clientName);
        this.setEmployerName(employerName);
    }

    public Order(int idClient, int idEmployer, String dateOrder) {
        this.setIdClient(idClient);
        this.setIdEmployer(idEmployer);
        this.setDateOrder(dateOrder);
    }

    public String toString() {
        return "{\n\tid => \"" + this.id + "\",\n\tidClient => \"" + this.idClient + "\",\n\tclientName => \"" + this.clientName + "\",\n\tidEmployer  => \""
                + this.idEmployer + "\",\n\temployerName => \"" + this.employerName + "\",\n\tdateOrder  => \"" + this.dateOrder + "\"\n}";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return this.idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdEmployer() {
        return this.idEmployer;
    }

    public void setIdEmployer(int idEmployer) {
        this.idEmployer = idEmployer;
    }

    public String getDateOrder() {
        return this.dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public void store() {
        Order tmp = OrdersManager.store(this);
        this.setId(tmp.getId());
    }

    public void update(Order order) {
        OrdersManager.update(this.getId(), order);
    }

    public boolean delete() {
        return OrdersManager.delete(this.id);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
}
