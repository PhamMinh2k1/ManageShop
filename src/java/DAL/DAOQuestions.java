/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;
import java.util.*;
import Models.*;

public class DAOQuestions extends DBContext{
    Connection con = new DBContext().connection;
    PreparedStatement ps;
    ResultSet rs;
    public ArrayList<Questions> loadQuestion(){
        ArrayList<Questions> list = new ArrayList<>();
        String sql = "select * from [Questions_HE153232]";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Questions(
                        rs.getInt(1), 
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
