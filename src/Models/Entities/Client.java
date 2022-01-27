package Models.Entities;

import Models.EntitiesManagers.ClientsManager;

public class Client {

    private int id;

    private String numCIN;

    private String lastName;

    private String firstName;

    private String category;

    private String tel;

    private String sex;

    public Client(int id, String numCIN, String lastName, String firstName, String category, String tel, String sex) {
        this.setId(id);
        this.setNumCIN(numCIN);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setCategory(category);
        this.setTel(tel);
        this.setSex(sex);
    }

    public Client(String numCIN, String lastName, String firstName, String category, String tel, String sex) {
        this.setNumCIN(numCIN);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setCategory(category);
        this.setTel(tel);
        this.setSex(sex);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumCIN() {
        return this.numCIN;
    }

    public void setNumCIN(String numCIN) {
        this.numCIN = numCIN;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toUpperCase();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "{\n\tid => \"" + this.id + "\",\n\tnumCIN => \"" + this.numCIN + "\",\n\tlastName  => \""
                + this.lastName + "\",\n\tfirstName  => \"" + this.firstName + "\",\n\tcategory  => \"" + this.category
                + ",\n\ttel  => \"" + this.tel + ",\n\tsex  => \"" + this.sex + "\"\n}";
    }

    public void store() {
        Client tmp = ClientsManager.store(this);
        this.setId(tmp.getId());
    }

    public void update(Client client) {
        ClientsManager.update(this.getId(), client);
    }

    public boolean delete() {
        return ClientsManager.delete(this.id);
    }
}
