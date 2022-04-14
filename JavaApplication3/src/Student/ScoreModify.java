/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ducnh
 */
public class ScoreModify {
    public static ArrayList<ArrayList<String>> findAll(){
        ArrayList<ArrayList<String>> ScoreList = new ArrayList<ArrayList<String>>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager
                .getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB","sa","0866607200");
            
            //query
            String sql = "select STUDENTS.ID_STD, STUDENTS.NAME, GRADE.NAME as GRADE, SUBJECT.NAME as SUBJECT, SCORE.D_CHUYENCAN, SCORE.D_THI, (SCORE.D_CHUYENCAN*0.2+SCORE.D_THI*0.8) as AVERAGE\n" +
"	from STUDENTS\n" +
"	join GRADE \n" +
"		on STUDENTS.ID_GRA = GRADE.ID_GRA\n" +
"	join SCORE \n" +
"		on STUDENTS.ID_STD =SCORE.ID_STD\n" +
"	join SUBJECT \n" +
"		on SUBJECT.ID_SUB=SCORE.ID_SUB\n" +
"       order by STUDENTS.ID_STD";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                ScoreList.add(new ArrayList<String>(){{add(resultSet.getString("ID_STD"));add(resultSet.getString("NAME"));
                                                        add(resultSet.getString("GRADE"));add(resultSet.getString("SUBJECT"));
                                                        add(resultSet.getString("D_CHUYENCAN"));add(resultSet.getString("D_THI"));
                                                        add(resultSet.getString("AVERAGE"));}});
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ScoreList;
    }
    
    public static ArrayList<ArrayList<String>> findByGradeName(String gra){
        ArrayList<ArrayList<String>> ScoreList = new ArrayList<ArrayList<String>>();
            
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "select STUDENTS.ID_STD, STUDENTS.NAME, GRADE.NAME as GRADE, SUBJECT.NAME as SUBJECT, SCORE.D_CHUYENCAN, SCORE.D_THI, (SCORE.D_CHUYENCAN*0.2+SCORE.D_THI*0.8) as AVERAGE\n" +
"	from STUDENTS\n" +
"	join GRADE \n" +
"		on STUDENTS.ID_GRA = GRADE.ID_GRA\n" +
"	join SCORE \n" +
"		on STUDENTS.ID_STD =SCORE.ID_STD\n" +
"	join SUBJECT \n" +
"		on SUBJECT.ID_SUB=SCORE.ID_SUB\n" +
"	where GRADE.NAME= ?\n" +
"	order by STUDENTS.ID_STD";
            statement = connection.prepareCall(sql);
            statement.setString(1, gra);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                ScoreList.add(new ArrayList<String>(){{add(resultSet.getString("ID_STD"));add(resultSet.getString("NAME"));
                                                        add(resultSet.getString("GRADE"));add(resultSet.getString("SUBJECT"));
                                                        add(resultSet.getString("D_CHUYENCAN"));add(resultSet.getString("D_THI"));
                                                        add(resultSet.getString("AVERAGE"));}});
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ScoreList;
    }
    
    public static void insert(Score std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql ="insert into SCORE values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getId_sub());
            statement.setString(2, std.getId_std());
            statement.setFloat(3, std.getD_chuyencan());
            statement.setFloat(4, std.getD_thi());
          
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void update(float d_chuyencan, float d_thi, String sub, String std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "update SCORE\n" +
"	set  SCORE.D_CHUYENCAN=?, SCORE.D_THI=?\n" +
"	where SCORE.ID_STD=(select ID_STD from STUDENTS where NAME=? ) and SCORE.ID_SUB=(select ID_SUB from SUBJECT where NAME=?)";
            statement = connection.prepareCall(sql);
            
            statement.setFloat(1, d_chuyencan);
            statement.setFloat(2, d_thi);
             statement.setString(3, sub);
            statement.setString(4, std);
            statement.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void delete(String id_sub, String id_std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "delete from SCORE where ID_SUB = ? and ID_STD = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, id_sub);
            statement.setString(1, id_std);
            
            statement.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    public static boolean isExistID(String ID_SUB, String ID_STD) {
        boolean temp=true;
        ArrayList<ArrayList<String>> studentList = new ArrayList<ArrayList<String>>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "select ID_SUB, ID_STD from SCORE where ID_SUB = ? and ID_STD = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, ID_SUB);
            statement.setString(2, ID_STD);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                studentList.add(new ArrayList<String>(){{add(resultSet.getString("ID_SUB"));add(resultSet.getString("ID_STD"));
                                                        }});
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        if(studentList.isEmpty())
            {return false;}
        else
            {return true;}
    }
}
