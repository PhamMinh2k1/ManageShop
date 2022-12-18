/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;
import java.util.*;
import Models.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DAOOrders extends DBContext{
    Connection con = new DBContext().connection;
    PreparedStatement ps;
    ResultSet rs;
    public void addOrder(Users user, Cart cart){
        LocalDateTime getDate = java.time.LocalDateTime.now();
        String date = getDate.toString();
        try {
            String sql ="insert into Orders_HE153232([u_buy],[order_date],[totalprice])\n"
                    + "values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUid());
            ps.setString(2, date);
            ps.setDouble(3, cart.getTotalPrice());
            ps.executeUpdate();
            String sql2 = "select top 1 oid from Orders_HE153232 order by desc";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            rs = ps2.executeQuery();
            if(rs.next()){
                int oid = rs.getInt(1);
                for (Items i : cart.getItems()) {
                    String sql3 = "insert into OrderDetails_HE153232([oid],[pid],[quantity],[price])\n"
                    + "values(?,?,?,?)";
                    PreparedStatement ps3 = con.prepareStatement(sql3);
                    ps3.setInt(1, oid);
                    ps3.setString(2, i.getProduct().getPid());
                    ps3.setInt(3, i.getQuantity());
                    ps3.setDouble(4, i.getPrice());
                    ps3.executeUpdate();
                }
            }
        } catch (Exception e) {
        }
    }
}
