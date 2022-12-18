/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Questions {
    private int qid;
    private String infor;

    public Questions() {
    }

    public Questions(int qid, String infor) {
        this.qid = qid;
        this.infor = infor;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    @Override
    public String toString() {
        return "Questions{" + "qid=" + qid + ", infor=" + infor + '}';
    }
    
}
