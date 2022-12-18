/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;
import java.util.*;
import Models.*;

public class DAOProducts extends DBContext {

    Connection con = new DBContext().connection;
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Products> loadProduct() {
        ArrayList<Products> list = new ArrayList<>();
        String sql = "select * from products_he153232";
        try {
            con = new DBContext().connection;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String pid = rs.getString(1);
                String pname = rs.getString(2);
                float price = rs.getFloat(3);
                String infor = rs.getString(4);
                String image = rs.getString(5);
                int cid = rs.getInt(6);
                int quantity = rs.getInt(7);
                float discount = rs.getFloat(8);
                String uid = rs.getString(9);
                if (infor == null) {
                    infor = "Hiện đang cập nhật";
                }
                list.add(new Products(pid, pname, price, infor, image, cid, quantity, discount, uid));

                
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }
    public ArrayList<Products> loadProductByCid(String cid) {
        ArrayList<Products> list = new ArrayList<>();
        String sql = "select * from products_he153232 where [cid] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                String pid = rs.getString(1);
                String pname = rs.getString(2);
                float price = rs.getFloat(3);
                String infor = rs.getString(4);
                String image = rs.getString(5);
                int quantity = rs.getInt(7);
                float discount = rs.getFloat(8);
                String uid = rs.getString(9);
                if (infor == null) {
                    infor = "Hiện đang cập nhật";
                }
                list.add(new Products(pid, pname, price, infor, image, rs.getInt(6), quantity, discount, uid));

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }
    public ArrayList<Products> loadProductByName(String name) {
        ArrayList<Products> list = new ArrayList<>();
        String sql = "select * from Products_HE153232 where [pname] like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+name+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String pid = rs.getString(1);
                String pname = rs.getString(2);
                float price = rs.getFloat(3);
                String infor = rs.getString(4);
                String image = rs.getString(5);
                int quantity = rs.getInt(7);
                float discount = rs.getFloat(8);
                String uid = rs.getString(9);
                if (infor == null) {
                    infor = "Hiện đang cập nhật";
                }
                list.add(new Products(pid, pname, price, infor, image, rs.getInt(6), quantity, discount, uid));

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }
    public ArrayList<Products> loadProductByUid(String uid) {
        ArrayList<Products> list = new ArrayList<>();
        String sql = "select * from products_he153232 where [uid] = ?";
        try {
            con = new DBContext().connection;
            ps = con.prepareStatement(sql);
            ps.setString(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                String pid = rs.getString(1);
                String pname = rs.getString(2);
                float price = rs.getFloat(3);
                String infor = rs.getString(4);
                String image = rs.getString(5);
                int cid = rs.getInt(6);
                int quantity = rs.getInt(7);
                float discount = rs.getFloat(8);
                rs.getString(9);
                if (infor == null) {
                    infor = "Hiện đang cập nhật";
                }
                list.add(new Products(pid, pname, price, infor, image, cid, quantity, discount, rs.getString(9)));

                
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }
    public ArrayList<Products> getByPrice(String from, String to) {
        ArrayList<Products> list = new ArrayList<>();
        String sql = "select * from products_he153232\n"
                + "where price between ? and ? \n"
                + "order by price";
        try {
            con = new DBContext().connection;
            ps = con.prepareStatement(sql);
            ps.setString(1, from);
            ps.setString(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                String pid = rs.getString(1);
                String pname = rs.getString(2);
                float price = rs.getFloat(3);
                String infor = rs.getString(4);
                String image = rs.getString(5);
                int cid = rs.getInt(6);
                int quantity = rs.getInt(7);
                float discount = rs.getFloat(8);
                String uid = rs.getString(9);
                if (infor == null) {
                    infor = "Hiện đang cập nhật";
                }
                list.add(new Products(pid, pname, price, infor, image, cid, quantity, discount, uid));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }
    public Products getProductById(String pid){
        String sql = "select * from Products_HE153232 where [pid] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Products(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getFloat(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
                
        }
        return null;
    }
    public void addProducts(String pid, String pname, String price,
            String infor, String image, String cid, String quantity, String discount, String uid) {
        String sql = "insert into Products_HE153232\n"
                + "([pid],[pname],[price],[infor],[image],[cid],[quantity],[discount],[uid])\n"
                + "Values(?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pid);
            ps.setString(2, pname);
            ps.setString(3, price);
            ps.setString(4, infor);
            ps.setString(5, image);
            ps.setString(6, cid);
            ps.setString(7, quantity);
            ps.setString(8, discount);
            ps.setString(9, uid);
            ps.execute();
            System.out.println("Success");
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }
    public void deleteProduct(String pid){
        String sql = "delete from Products_HE153232 where pid = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pid);
            ps.executeUpdate();
            System.out.println("Success");
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }
    public void updateProduct(String pid, String pname, String price,
            String infor, String image, String cid, String quantity, String discount){
        String sql = "update [Products_HE153232] \n"
                + "set [pname] = ? , [price] = ?, [infor] = ?, [image] = ?,\n"
                + "[cid] = ?, [quantity] = ?, [discount] = ?\n"
                + "where [pid] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pname);
            ps.setString(2, price);
            ps.setString(3, infor);
            ps.setString(4, image);
            ps.setString(5, cid);
            ps.setString(6, quantity);
            ps.setString(7, discount);
            ps.setString(8, pid);
            ps.executeUpdate();
            System.out.println("Success");
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }
    public static void main(String[] args) {
        DAOProducts dao = new DAOProducts();
        ArrayList<Products> list = dao.loadProductByName("G");
        dao.updateProduct("123456", "Test 5", "14.5", "Chua co", "Chua co", "1", "20", "0.02");
//        for (Products p : list) {
//            System.out.println(p);
//        }
        
    }
}
