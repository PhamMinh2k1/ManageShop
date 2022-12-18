/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Products {
    private String pid;
    private String pname;
    private float price;
    private String infor;
    private String image;
    private int cid;
    private int quantity;
    private float discount;
    private String uid;

    public Products() {
    }

    public Products(String pid, String pname, float price, String infor, String image, int cid, int quantity, float discount, String uid) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.infor = infor;
        this.image = image;
        this.cid = cid;
        this.quantity = quantity;
        this.discount = discount;
        this.uid = uid;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    @Override
    public String toString() {
        return "Products{" + "pid=" + pid + ", pname=" + pname + ", price=" + price + ", infor=" + infor + ", image=" + image + ", cid=" + cid + ", quantity=" + quantity + '}';
    }
    
}
