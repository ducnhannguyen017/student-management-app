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
public class Grade {
    String id_gra, name, Faculty;

    public Grade() {
    }
    
    public Grade(String id_gra, String name, String Faculty) {
        this.id_gra = id_gra;
        this.name = name;
        this.Faculty = Faculty;
    }

    public String getId_gra() {
        return id_gra;
    }

    public void setId_gra(String id_gra) {
        this.id_gra = id_gra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String Faculty) {
        this.Faculty = Faculty;
    }

    
    
}
