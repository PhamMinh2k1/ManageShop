/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;
import java.util.*;
import Models.*;

public class DAOUsers extends DBContext{
    Connection con = new DBContext().connection;
    PreparedStatement ps;
    ResultSet rs;
    public Users getUser(String uid){
        String sql = "select * from Users_HE153232 where [uid] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, uid);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Users(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public void updateUser(String name, String dob, String address, String phone, String email, String gender, String uid){
        String sql = "update Users_He153232 \n"
                + "set [name] = ? , [dob] = ?, [address] = ?, [phone] = ?, [email]=?, [gender] = ?\n"
                + "where [uid] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setString(5, email);
            ps.setString(6, gender);
            ps.setString(7, uid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        DAOUsers dao = new DAOUsers();
        Users u = dao.getUser("ua0G3S");
        //dao.updateUser("Phạm Văn Gì Đó", "2001-02-04", "Quảng Ninh", "0123456789", "exam123@gmail.com", true, "ua0G3S");
        System.out.println(u);
    }
}
