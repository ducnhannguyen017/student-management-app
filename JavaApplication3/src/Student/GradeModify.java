/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import Student.Grade;
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
public class GradeModify {
    public static List<String> getGradeName(){
        List<String> GradeList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager
                .getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB","sa","0866607200");
            
            //query
            String sql = "select NAME from GRADE";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                String gra=resultSet.getString("NAME");
                GradeList.add(gra);
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
        //ket thuc.
        return GradeList;
    }
    
    public static List<String> getGradeId(){
        List<String> GradeList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager
                .getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB","sa","0866607200");
            
            //query
            String sql = "select ID_GRA from GRADE";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                String gra=resultSet.getString("ID_GRA");
                GradeList.add(gra);
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
        //ket thuc.
        return GradeList;
    }
    
    public static boolean isExistId_sub( String sub){
        List<String> GradeList = new ArrayList<String>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "select ID_GRA from GRADE where ID_GRA = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, sub);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                String name=resultSet.getString("ID_GRA");
                GradeList.add(name);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GradeModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
        //ket thuc.
        
        if(GradeList.isEmpty())
            {return false;}
        else
            {return true;}
    }
    public static void insert(Grade Gra) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "insert into GRADE values(?, ?, ? )";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, Gra.getId_gra());
            statement.setString(2, Gra.getName());
            statement.setString(3, Gra.getFaculty());
            
            statement.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GradeModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
        //ket thuc.
    }
    
    public static void update(Grade gra, String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "update GRADE set ID_GRA=?, NAME=?, FACULTY=? where ID_GRA = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, gra.getId_gra());
            statement.setString(2, gra.getName());
            statement.setString(3, gra.getFaculty());
            statement.setString(4, id);
            
            statement.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GradeModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
            String sql = "delete from GRADE where ID_GRA = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, id);
            
            statement.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GradeModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
        //ket thuc.
    }
    public static List<Grade> findAll(){
        List<Grade> GradeList = new ArrayList<Grade>();
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager
                .getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB","sa","0866607200");
            
            //query
            String sql = "select * from GRADE";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                Grade gra =new Grade(resultSet.getString("ID_GRA"),resultSet.getString("NAME"),resultSet.getString("FACULTY"));
                GradeList.add(gra);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
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
        //ket thuc.
        
        return GradeList;
    }
}
