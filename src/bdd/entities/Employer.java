package bdd.entities;

import bdd.entitiesManagers.EmployerManager;

/**
 * @author mawena
 */
public class Employer {
    private int id;
    private String lastName;
    private String firstName;
    private String birthDate;
    private char sex;
    private String role;

    /**
     * A Employer object represents the table employer from the database
     * @param id    The identifiant of the employer in the database
     * @param lastName  The last name of the employer
     * @param firstName The first name of the employer
     * @param birthDate The birth date of the employer
     * @param sex   The sex of the employer (M/F)
     * @param role The employer role in the hardware store
     */
    public Employer(int id, String lastName, String firstName, String birthDate, char sex, String role) {
        this.setId(id);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setBirthDate(birthDate);
        this.setSex(sex);
        this.setRole(role);
    }

    /**
     * A Employer object represents the table employer from the database
     * @param lastName  The last name of the employer
     * @param firstName The first name of the employer
     * @param birthDate The birth date of the employer
     * @param sex   The sex of the employer (M/F)
     * @param role The employer role in the hardware store
     */
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
        this.lastName = lastName.toUpperCase();
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
                + "\",\n\trole  => \"" + this.role + "\"\n}";
    }

    /**
     * Insert the Employer into the database
     */
    public void store() {
        EmployerManager.store(this);
    }

    /**
     * @param id The id of the employer that will be updated
     * Updates the Employer in the database
     */
    public void update(int id) {
        EmployerManager.update(id, this);
    }
    
    /** 
     * Deletes the Employer from the database
     * @return int
     */
    public int delete() {
        return EmployerManager.delete(this.id);
    }
}
