/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

/**
 *;
 * @author way4ward
 */
public class LoadTables {
    private String id;
    private String surname;
    private String firstname;
    private String symtoms;
    private String date;
    private String phone;
    private String test;
   
    
public LoadTables(String id , String surname , String firstname, String symtoms , String date , String phone , String test){
   this.id = id;
    this.surname = surname;
    this.firstname = firstname;
    this.symtoms = symtoms;
    this.date = date;
    this.phone = phone;
    this.test = test;
   
}

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the symtoms
     */
    public String getSymtoms() {
        return symtoms;
    }

    /**
     * @param symtoms the symtoms to set
     */
    public void setSymtoms(String symtoms) {
        this.symtoms = symtoms;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the test
     */
    public String getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(String test) {
        this.test = test;
    }

    
   


}
