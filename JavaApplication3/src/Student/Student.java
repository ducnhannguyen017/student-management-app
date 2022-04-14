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
public class Student {
    private String id_std, name, email, phone, address;
    private int  age;
    private boolean gender;
    private String id_gra;
    
    public Student() {
    }

    public Student(String id_std, String name, String email, String phone, String address, int age, boolean gender, String id_gra) {
        this.id_std = id_std;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.id_gra = id_gra;
    }

    public String getId_std() {
        return id_std;
    }

    public void setId_std(String id_std) {
        this.id_std = id_std;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getId_gra() {
        return id_gra;
    }

    public void setId_gra(String id_gra) {
        this.id_gra = id_gra;
    }

    

    
    
}

