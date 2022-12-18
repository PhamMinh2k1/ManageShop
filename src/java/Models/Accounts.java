/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Accounts {
    private String username;
    private String password;
    private String uid;
    private boolean isAdmin;
    private boolean isSell;
    private int qid;
    private String answer;

    public Accounts() {
    }

    public Accounts(String username, String password, String uid, boolean isAdmin, boolean isSell, int qid, String answer) {
        this.username = username;
        this.password = password;
        this.uid = uid;
        this.isAdmin = isAdmin;
        this.isSell = isSell;
        this.qid = qid;
        this.answer = answer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isIsSell() {
        return isSell;
    }

    public void setIsSell(boolean isSell) {
        this.isSell = isSell;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Accounts{" + "username=" + username + ", password=" + password + ", uid=" + uid + ", isAdmin=" + isAdmin + ", isSell=" + isSell + ", qid=" + qid + ", answer=" + answer + '}';
    }
    
}
