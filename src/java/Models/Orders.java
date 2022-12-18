/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Orders {
    private int oid;
    private String u_sell;
    private String u_buy;
    private String order_date;
    private double totalprice;

    public Orders() {
    }

    public Orders(int oid, String u_sell, String u_buy, String order_date, double totalprice) {
        this.oid = oid;
        this.u_sell = u_sell;
        this.u_buy = u_buy;
        this.order_date = order_date;
        this.totalprice = totalprice;
    }

    public Orders(int oid, String u_sell, String u_buy, String order_date) {
        this.oid = oid;
        this.u_sell = u_sell;
        this.u_buy = u_buy;
        this.order_date = order_date;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getU_sell() {
        return u_sell;
    }

    public void setU_sell(String u_sell) {
        this.u_sell = u_sell;
    }

    public String getU_buy() {
        return u_buy;
    }

    public void setU_buy(String u_buy) {
        this.u_buy = u_buy;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
    
}
