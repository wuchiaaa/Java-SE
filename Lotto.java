/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import java.util.Random;

/**
 *
 * @author student
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //【Lotto】樂透
        //宣告整數陣列長度6
        int[] lotto = new int[6];
        boolean boo;
                
        do {
            boo = false;
            for (int i = 0; i < lotto.length; i++) {
                lotto[i] = new Random().nextInt(49) + 1;   //nextInt(49) 會產生 0~48 //nextInt(int n) 獲取一個偽隨機 
            }
            
            //檢查是否有重複
            //迴圈標籤 --> 可跳脫好幾層迴圈
            outer:
            for (int i = 0; i < lotto.length - 1; i++) {
                for (int j = i + 1; j < lotto.length; j++) {
                    if (lotto[i] == lotto[j]) {
                        System.out.printf("%2d --> 在索引位置 [%d] 和 [%d] 相同", lotto[j], i, j);
                        boo = true;
                        break outer;    // --> 如未使用break，檢查機制在檢查出第1個重複後，仍會再繼續檢查 --> 浪費時間
                    }
                    
                    //排序，由小到大
                    if(lotto[i]>lotto[j]){
                        int temp = lotto[i];
                        lotto[i] = lotto[j];
                        lotto[j] = temp;
                    }
                }
            }
            System.out.println("\n--------");
        } while (boo);
                
        
        for (int i : lotto) {
            System.out.printf("%02d | ", i);
        }
        System.out.println("\n結束");

    }

}
