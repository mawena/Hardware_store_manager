package bdd.entities;

import bdd.entitiesManagers.EmployerManager;

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

    /**
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String
     */
    public String getBirthDate() {
        return this.birthDate;
    }

    /**
     * @param birthDate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return char
     */
    public char getSex() {
        return this.sex;
    }

    /**
     * @param sex
     */
    public void setSex(char sex) {
        this.sex = sex;
    }

    /**
     * @return String
     */
    public String getRole() {
        return this.role;
    }

    /**
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return String
     */
    public String toString() {
        return "{\n\tid => \"" + this.id + "\",\n\tlastName  => \"" + this.lastName + "\",\n\tfirstName  => \""
                + this.firstName + "\",\n\tbirthDate  => \"" + this.birthDate + "\",\n\tsex  => \"" + this.sex
                + ",\n\ttrole  => \"" + this.role + "\"\n}";
    }

    public void store() {
        EmployerManager.store(this);
    }

    public void update() {
        EmployerManager.update(this);
    }
    
    /** 
     * @return int
     */
    public int delete() {
        return EmployerManager.delete(this.id);
    }
}
