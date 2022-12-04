package student.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;

import javax.swing.*;

import student.model.Student;

public class studentController {
    private final static Student databaStudent = new Student("Student_management");

    public void Show_all(JTextArea textArea) {
        try {
            ResultSet rs = databaStudent.getStatement().executeQuery("select * from Student");
            String text = "";

            while (rs.next()) {
                text = text + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
                        + rs.getString(4) + " " + rs.getString(5) + '\n';
            }
            textArea.setText(text);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void Add(String id, String firstname, String lastname, String dateofbirth, String address, JPanel panel) {
        String updateValue = "insert into Student values (?,?,?,?,?)";
        try {
            PreparedStatement statement = databaStudent.getConnection().prepareStatement(updateValue);
            statement.setString(1, id);
            statement.setString(2, firstname);
            statement.setString(3, lastname);
            statement.setString(4, dateofbirth);
            statement.setString(5, address);

            statement.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, e.getStackTrace(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void Search(String id, String name, JTextArea textarea) {
        if (id.equals(""))
            id = "is null";
        if (name.equals(""))
            name = "is null";
    
        String query = "select * from Student st where st.last_name like ? and st.id = ? or st.last_name like ? or st.id = ? ";
        try {
            String text = "";
            System.out.println();
            
            PreparedStatement statement = databaStudent.getConnection().prepareStatement(query);
            statement.setString(1,name );
            statement.setString(2, id);
            statement.setString(3, name);
            statement.setString(4, id);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                text = text + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
                        + rs.getString(4) + " " + rs.getString(5) + '\n';
            }

            textarea.setText(text + "\n-----------------------------------");
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Update(String ID_update, String id, String fname, String lname, String dateofbirth, String address){
        String getall = "select * from Student st where st.id = ?";
        String Query = "update Student set id = ?, first_name = ?, last_name= ?, dateofbirth = ?, address = ? where Student.id = ?";
        try {
            PreparedStatement statement = databaStudent.getConnection().prepareStatement(getall);
            statement.setString(1, ID_update);

            ResultSet rs_1  = statement.executeQuery();
            
            rs_1.next();

            if (id.equals("")){
                id = rs_1.getString(1);
            }
            if (fname.equals("")){
                fname = rs_1.getString(2);
            }
            if (lname.equals("")){
                lname = rs_1.getString(3);
            }
            if (dateofbirth.equals("")){
                dateofbirth = rs_1.getString(4);
            }
            if (address.equals("")){
                address = rs_1.getString(5);
            }
            System.out.println(id + fname+ lname + dateofbirth + address);

            statement = databaStudent.getConnection().prepareStatement(Query);
            statement.setString(1, id);
            statement.setString(2, fname);
            statement.setString(3, lname);
            statement.setString(4, dateofbirth);
            statement.setString(5, address);
            statement.setString(6, ID_update);
            statement.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Delete (String id, JTextArea textArea){
        String Query = "delete from Student where id = ?";
        String getall = "select * from Student st where st.id = ?";
        try {
            
            PreparedStatement statement = databaStudent.getConnection().prepareStatement(getall);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            rs.getString(1);
            
            statement = databaStudent.getConnection().prepareStatement(Query);
            statement.setString(1, id);
            statement.execute();
            textArea.setText("Xóa thành công");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            textArea.setText("Xóa thất bại");
        }
    }
}
