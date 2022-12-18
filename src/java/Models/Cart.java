/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Cart {
    private List<Items> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Items> items) {
        this.items = items;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
    public Items getItemById(String pid){
        for (Items i : items) {
            if(i.getProduct().getPid()==pid){
                return i;
            }
        }
        return null;
    }
    
    public int getQuantityById(String pid){
        return getItemById(pid).getQuantity();
    }
    
    public void addItem(Items i){
        if(getItemById(i.getProduct().getPid())!=null){
            Items tmp = getItemById(i.getProduct().getPid());
            tmp.setQuantity(i.getQuantity()+tmp.getQuantity());
        }else{
            items.add(i);
        }
    }
    public void removeItem(String pid){
        if(getItemById(pid)!=null){
            items.remove(getItemById(pid));
        }
    }
    public double getTotalPrice(){
        double tmp=0;
        for (Items i : items) {
            tmp+=i.getPrice()*i.getQuantity();
        }
        return tmp;
    }
}
