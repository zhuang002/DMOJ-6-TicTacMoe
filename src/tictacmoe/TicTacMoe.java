/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacmoe;

import java.util.Scanner;

/**
 *
 * @author zhuang001
 */
public class TicTacMoe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int[][] data=readInData(sc);
        System.out.println(judge(data));
    }

    private static int[][] readInData(Scanner sc) {
        int[][] data=new int[3][3];
        for (int i=0;i<3;i++) {
            char[] line=sc.nextLine().toCharArray();
            for (int j=0;j<3;j++) {
                data[i][j]=line[j];
            }
        }
        return data;
    }

    private static String judge(int[][] data) {
        boolean xWin=checkWin(data,'X');
        boolean oWin=checkWin(data,'O');
        if (oWin && xWin) return "Error, redo";
        if (xWin) return "Timothy";
        if (oWin) return "Griffy";
        return "Tie";
    }

    private static boolean checkWin(int[][] data,char c) {
        boolean win1=true;
        boolean win2=true;
        for (int i=0;i<3;i++) {
            win1=true;
            win2=true;
            for (int j=0;j<3;j++) {
                win1 &= data[i][j]==c;
                win2 &= data[j][i]==c;
            }
            if (win1 || win2) return true;
        }
        return data[0][0]==c && data[1][1]==c && data[2][2]==c
                || data[0][2]==c && data[1][1]==c && data[2][0]==c;
        
    }
}
