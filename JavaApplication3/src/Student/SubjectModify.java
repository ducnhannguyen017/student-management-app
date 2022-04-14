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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ducnh
 */
public class SubjectModify {
    public static List<Subject> findAll(){
        List<Subject> SubjectList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager
                .getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB","sa","0866607200");
            
            //query
            String sql = "select * from SUBJECT";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                Subject SUB = new Subject(resultSet.getString("ID_SUB"), 
                        resultSet.getString("NAME"), resultSet.getInt("CREDIT"), 
                        resultSet.getInt("FEE"));
                SubjectList.add(SUB);
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
        
        return SubjectList;
    }
    public static void insert(Subject SUB) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "insert into Subject values(?, ?, ?, ? )";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, SUB.getId_sub());
            statement.setString(2, SUB.getName());
            statement.setInt(3, SUB.getCredit());
            statement.setInt(4, SUB.getFee());
            
            statement.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
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
    }
    
    public static void update(Subject SUB, String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "update Subject set ID_SUB=?, NAME=?, CREDIT=?, FEE=? where ID_SUB = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, SUB.getId_sub());
            statement.setString(2, SUB.getName());
            statement.setInt(3, SUB.getCredit());
            statement.setInt(4, SUB.getFee());
            statement.setString(5, id);
            
            statement.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
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
    }
    
    public static void delete(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "delete from Subject where ID_SUB = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, id);
            
            statement.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SubjectModify.class.getName()).log(Level.SEVERE, null, ex);
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
    }
    public static LinkedHashMap<String, String>  getSubName(){
        
        LinkedHashMap<String, String>  nameList = new LinkedHashMap<String, String> ();
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager
                .getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB","sa","0866607200");
            
            //query
            String sql = "select ID_SUB, NAME from SUBJECT";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                nameList.put(resultSet.getString("ID_SUB"), resultSet.getString("NAME"));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GradeModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GradeModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return nameList;
    }
    
    public static List<String> findByStdGra(String std, String gra){
        List<String> studentList = new ArrayList<String>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "select SUB.NAME\n" +
"	from STUDENTS\n" +
"	join GRADE \n" +
"		on STUDENTS.ID_GRA = GRADE.ID_GRA\n" +
"	join SCORE \n" +
"		on STUDENTS.ID_STD =SCORE.ID_STD\n" +
"	join SUBJECT \n" +
"		on SUBJECT.ID_SUB=SCORE.ID_SUB\n" +
"	where STUDENTS.NAME=? and GRADE.NAME=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, std);
            statement.setString(2, gra);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                String name=resultSet.getString("NAME");
                studentList.add(name);
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
        
        return studentList;
    }
}
