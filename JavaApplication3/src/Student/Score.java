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
public class Score {
    String id_sub,id_std;
    float d_chuyencan, d_thi;


    public Score() {
    }

    public Score(String id_sub, String id_std, float d_chuyencan, float d_thi) {
        this.id_sub = id_sub;
        this.id_std = id_std;
        this.d_chuyencan = d_chuyencan;
        this.d_thi = d_thi;
    }

    public String getId_sub() {
        return id_sub;
    }

    public void setId_sub(String id_sub) {
        this.id_sub = id_sub;
    }

    public String getId_std() {
        return id_std;
    }

    public void setId_std(String id_std) {
        this.id_std = id_std;
    }

    public float getD_chuyencan() {
        return d_chuyencan;
    }

    public void setD_chuyencan(float d_chuyencan) {
        this.d_chuyencan = d_chuyencan;
    }

    public float getD_thi() {
        return d_thi;
    }

    public void setD_thi(float d_thi) {
        this.d_thi = d_thi;
    }

    
}
