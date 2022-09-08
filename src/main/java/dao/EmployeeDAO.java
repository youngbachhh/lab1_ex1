package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Employee;

public class EmployeeDAO extends DBconnection {

    public void registerEmployee(Employee employee) {
        String sql = "INSERT INTO ex1.employee(id, first_name, last_name, username, password, address, contact) VALUES(?, ?, ?, ?, ?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, getID());
            ps.setNString(2, employee.getFirstName());
            ps.setNString(3, employee.getLastName());
            ps.setNString(4, employee.getUsername());
            ps.setString(5, employee.getPassword());
            ps.setNString(6, employee.getAddress());
            ps.setNString(7, employee.getContact());
            ps.executeUpdate();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int getID() {
        String sql = "SELECT COUNT(id) FROM ex1.employee";
        int id = 0;

        try {
            PreparedStatement  ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return (id + 1);
    }
}