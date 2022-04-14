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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.xml.crypto.Data;
/**
 *
 * @author ducnh
 */
public class StudentModify {
    public static ArrayList<ArrayList<String>> findAll(){
        ArrayList<ArrayList<String>> studentList = new ArrayList<ArrayList<String>>();
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager
                .getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB","sa","0866607200");
            
            //query
            String sql = "select STUDENTS.ID_STD, STUDENTS.NAME, GRADE.NAME as GRADE, STUDENTS.EMAIL, STUDENTS.PHONE, STUDENTS.ADDRESS, STUDENTS.AGE, STUDENTS.GENDER\n" +
                        "from STUDENTS join GRADE\n" +
                        "on STUDENTS.ID_GRA=GRADE.ID_GRA";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
//                Object[] std = {resultSet.getString("ID_STD"), 
//                        resultSet.getString("NAME"), resultSet.getString("EMAIL"), resultSet.getString("GRADE"),
//                        resultSet.getString("PHONE"), resultSet.getString("ADDRESS"),
//                        resultSet.getInt("AGE"), resultSet.getBoolean("GENDER")};
                studentList.add(new ArrayList<String>(){{add(resultSet.getString("ID_STD"));add(resultSet.getString("NAME"));
                                                        add(resultSet.getString("GRADE"));add(resultSet.getString("EMAIL"));
                                                        add(resultSet.getString("PHONE"));add(resultSet.getString("ADDRESS"));
                                                        add(resultSet.getString("AGE"));add(resultSet.getString("GENDER"));}});
            }
        } catch (Exception e) {
            System.out.println(e);
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
    
    public static void insert(Student std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql ="insert into STUDENTS values(?, ?, ?, ?, ?, ?, ?, ? )";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getId_std());
            statement.setString(2, std.getName());
            statement.setString(3, std.getEmail());
            statement.setString(4, std.getPhone());
            statement.setString(5, std.getAddress());
            statement.setInt(6, std.getAge());
            statement.setBoolean(7, std.getGender());
            statement.setString(8, std.getId_gra());
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
    
    public static void update(Student std, String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "update STUDENTS set ID_STD=?, NAME=?, EMAIL=?, PHONE=?, ADDRESS=?, AGE=?,GENDER=?, ID_GRA=? where ID_STD = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getId_std());
            statement.setString(2, std.getName());
            statement.setString(3, std.getEmail());
            statement.setString(4, std.getPhone());
            statement.setString(5, std.getAddress());
            statement.setInt(6, std.getAge());
            statement.setBoolean(7, std.getGender());
            statement.setString(8, std.getId_gra());
            statement.setString(9, id);
            
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
    
    public static void delete(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "delete from STUDENTS where ID_STD = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, id);
            
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
    
    public static ArrayList<ArrayList<String>> findByFullname(String NAME) {
        ArrayList<ArrayList<String>> studentList = new ArrayList<ArrayList<String>>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "select STUDENTS.ID_STD, STUDENTS.NAME, GRADE.NAME as GRADE, STUDENTS.EMAIL, STUDENTS.PHONE, STUDENTS.ADDRESS, STUDENTS.AGE, STUDENTS.GENDER\n" +
                        "from STUDENTS join GRADE\n" +
                        "on STUDENTS.ID_GRA=GRADE.ID_GRA where STUDENTS.NAME like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+NAME+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                studentList.add(new ArrayList<String>(){{add(resultSet.getString("ID_STD"));add(resultSet.getString("NAME"));
                                                        add(resultSet.getString("GRADE"));add(resultSet.getString("EMAIL"));
                                                        add(resultSet.getString("PHONE"));add(resultSet.getString("ADDRESS"));
                                                        add(resultSet.getString("AGE"));add(resultSet.getString("GENDER"));}});
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
    
    public static List<String> findByGra(String gra){
        List<String> studentList = new ArrayList<String>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "select STUDENTS.NAME\n" +
"	from STUDENTS\n" +
"	join GRADE \n" +
"		on STUDENTS.ID_GRA = GRADE.ID_GRA\n" +
"	where GRADE.NAME=? ";
            statement = connection.prepareCall(sql);
            statement.setString(1, gra);
            
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
    
    public static boolean isExistID(String ID_STD) {
        ArrayList<ArrayList<String>> studentList = new ArrayList<ArrayList<String>>();
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB;user=sa;password=0866607200");
            
            //query
            String sql = "select * from STUDENTS where ID_STD like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, ID_STD);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                studentList.add(new ArrayList<String>(){{add(resultSet.getString("ID_STD"));add(resultSet.getString("NAME"));
                                                        add(resultSet.getString("EMAIL"));
                                                        add(resultSet.getString("PHONE"));add(resultSet.getString("ADDRESS"));
                                                        add(resultSet.getString("AGE"));add(resultSet.getString("GENDER"));add(resultSet.getString("ID_GRA"));}});
                
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
    
    public static LinkedHashMap<String, String> getStdName(){
        
        LinkedHashMap<String, String> nameList = new LinkedHashMap<String, String>();
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager
                .getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV_DB","sa","0866607200");
            
            //query
            String sql = "select ID_STD, NAME from STUDENTS";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                nameList.put(resultSet.getString("ID_STD"), resultSet.getString("NAME"));
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
}
