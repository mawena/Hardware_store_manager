package Models.Entities;

import Models.EntitiesManagers.EmployersManager;

public class Employer {

    private int id;
    private String lastName;
    private String firstName;
    private String birthDate;
    private char sex;
    private String role;

    public Employer(int id, String lastName, String firstName, String birthDate, char sex, String role) {
        this.setId(id);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setBirthDate(birthDate);
        this.setSex(sex);
        this.setRole(role);
    }

    public Employer(String lastName, String firstName, String birthDate, char sex, String role) {
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setBirthDate(birthDate);
        this.setSex(sex);
        this.setRole(role);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public char getSex() {
        return this.sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return "{\n\tid => \"" + this.id + "\",\n\tlastName  => \"" + this.lastName + "\",\n\tfirstName  => \""
                + this.firstName + "\",\n\tbirthDate  => \"" + this.birthDate + "\",\n\tsex  => \"" + this.sex
                + "\",\n\trole  => \"" + this.role + "\"\n}";
    }

    public void store() {
        Employer tmp = EmployersManager.store(this);
        this.setId(tmp.getId());
    }

    public void update(Employer employer) {
        EmployersManager.update(this.getId(), employer);
    }

    public boolean delete() {
        return EmployersManager.delete(this.id);
    }
}
