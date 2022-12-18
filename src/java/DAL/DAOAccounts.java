/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;
import java.util.*;
import Models.*;

public class DAOAccounts extends DBContext {

    Connection con = new DBContext().connection;
    PreparedStatement ps;
    ResultSet rs;

    public Accounts getAccounts(String username, String pass) {
        String sql = "select * from Accounts_HE153232 \n"
                + "where [username] = ? and [password] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Accounts(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getInt(6),
                        rs.getString(7));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Accounts checkExist(String username) {
        String sql = "select * from Accounts_HE153232\n"
                + "where [username] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Accounts(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getInt(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public void changePass(String username, String pass){
        String sql = "update Accounts_HE153232 set [password] = ? where [username] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void signUp(String uid, String username, String password, String qid, String answer) {
        String sql = "INSERT INTO [Users_HE153232]([uid])\n"
                + "VALUES(?)\n"
                + "INSERT INTO [Accounts_HE153232]([username],[password],[uid], [qid], [answer])\n"
                + "VALUES(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, uid);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, uid);
            ps.setString(5, qid);
            ps.setString(6, answer);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        DAOAccounts dao = new DAOAccounts();
        Accounts acc = dao.getAccounts("admin1", "1234");
        System.out.println(acc);
        System.out.println(dao.checkExist("admin5"));
    }
}
