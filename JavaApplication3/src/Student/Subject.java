/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

/**
 *
 * @author ducnh
 */
public class Subject {
    String id_sub, name;
    int credit, fee;

    public Subject(String id_sub, String name, int credit, int fee) {
        this.id_sub = id_sub;
        this.name = name;
        this.credit = credit;
        this.fee = fee;
    }

    public Subject() {
    }
    
    public String getId_sub() {
        return id_sub;
    }

    public void setId_sub(String id_sub) {
        this.id_sub = id_sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    
}
