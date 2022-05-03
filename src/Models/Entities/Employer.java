package Models.Entities;

import Models.EntitiesManagers.EmployersManager;

public class Employer {

    private int id;
    private String lastName;
    private String firstName;
    private String birthDate;
    private String sex;
    private String rule;
    private String tel;
    private String photo;

    public Employer(int id, String lastName, String firstName, String birthDate, String sex, String rule, String tel, String photo) {
        this.setId(id);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setBirthDate(birthDate);
        this.setSex(sex);
        this.setRule(rule);
        this.setTel(tel);
        this.setPhoto(photo);
    }

    public Employer(String lastName, String firstName, String birthDate, String sex, String rule, String tel, String photo) {
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setBirthDate(birthDate);
        this.setSex(sex);
        this.setRule(rule);
        this.setTel(tel);
        this.setPhoto(photo);
    }

    public String toString() {
        return "{\n\tid => \"" + this.id + "\",\n\tlastName  => \"" + this.lastName + "\",\n\tfirstName  => \""
                + this.firstName + "\",\n\tbirthDate  => \"" + this.birthDate + "\",\n\tsex  => \"" + this.sex
                + "\",\n\trule  => \"" + this.rule + "\",\n\ttel  => \"" + this.tel + "\"\n}";
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

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRule() {
        return this.rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
