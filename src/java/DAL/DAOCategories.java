/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;
import java.util.*;
import Models.*;

public class DAOCategories extends DBContext{
    Connection con = new DBContext().connection;
    PreparedStatement ps;
    ResultSet rs;
    public ArrayList<Categories> loadCategories(){
        ArrayList<Categories> list = new ArrayList<>();
        String sql = "select * from Categories_HE153232";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                int cid = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new Categories(cid, name));
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        DAOCategories dao = new DAOCategories();
        ArrayList<Categories> list = dao.loadCategories();
        System.out.println(list);
    }
}
