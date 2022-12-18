/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Validate {

    public String RamdomCode() {

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String sumStr = upper + lower + numbers;

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(sumStr.length());
            char randomChar = sumStr.charAt(index);
            sb.append(randomChar);
        }
        String rdCode = sb.toString();
        return rdCode;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            String rd = new Validate().RamdomCode();
            System.out.println(rd);
        }

    }
}
