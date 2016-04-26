package com.geekbrains.java.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Demiurg on 24.04.2016.
 */
public class Xo {

    private boolean fin = false, userwin = false;
    private char[][] xxxooo = new char[3][3];
    private String userin;
    private char aiChar = '*';
    private int x = 0, y = 0;
    private final int SIZE = 3;
    private int progress = SIZE * SIZE;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void xo() throws IOException {
        System.out.println("---------------------------XO----------------------------------");

        for (int iter = 0; iter < SIZE; iter++){
            Arrays.fill(xxxooo[iter], '-');
        }

        inputuserchar();

        for(; !fin ;) {
            inusercoor();
            progress--;
            xxxooo[x - 1][y - 1] = userin.charAt(0);
            xoprint(xxxooo);
            inspection();
            System.out.println("|-------|");
            setAiChar();
            progress--;
            xoprint(xxxooo);
            inspection();
            if (!fin && progress == 0){
                System.out.println("Dead heart!");
                break;
            }
        }
        if (userwin)
            System.out.println("USER WIN!!!");
        else
            System.out.println("COMPUTER WIN");
    }

    private void inputuserchar() throws IOException{
        while (true) {
            System.out.println("Please enter x or o (char o - not null):");
            userin = br.readLine();
            userin.toLowerCase();
            if (userin.charAt(0) == 'x') {
                aiChar = 'o';
                break;
            }else if (userin.charAt(0) == 'o'){
                aiChar = 'x';
                break;
            }
        }
        System.out.println("User char: " + userin);
    }

    private void xoprint(char[][] arg){
        for (int i = 0; i < SIZE; i++){
            System.out.println(Arrays.toString(arg[i]));
        }
    }

    private void inusercoor() throws IOException{
        boolean badX = true, badY = true;
        do {
            System.out.println("Please enter x coordinate:");
            try {
                x = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid format!");
            }
            if (x > 0 && x < 4)
                badX = false;
        } while (badX);

        do {
            System.out.println("Please enter y coordinate:");
            try {
                y = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid format!");
            }
            if (y > 0 && y < 4)
                badY = false;
        }while (badY);
    }

    private void inspection(){
        // Ispect Rows and Columns
        // Rows
        for(int iter = 0; iter < SIZE; iter++){
            if (xxxooo[iter][0] == xxxooo[iter][1] && xxxooo[iter][0] == xxxooo[iter][2] && (xxxooo[iter][0] == 'x' || xxxooo[iter][0] == 'o')){
                fin = true;
                if (xxxooo[iter][0] == userin.charAt(0))
                    userwin = true;
        // Columns
            }else if (xxxooo[0][iter] == xxxooo[1][iter] && xxxooo[0][iter] == xxxooo[2][iter] && (xxxooo[0][iter] == 'x' || xxxooo[0][iter] == 'o')){
                fin = true;
                if (xxxooo[0][iter] == userin.charAt(0))
                    userwin = true;
            }
        }
        // Inspect Diagonal
        if (xxxooo[0][0] == xxxooo[1][1] && xxxooo[0][0] == xxxooo[2][2] && (xxxooo[0][0] == 'x' || xxxooo[0][0] == 'o')){
            fin = true;
            if (xxxooo[0][0] == userin.charAt(0))
                userwin = true;
        }
        if (xxxooo[0][2] == xxxooo[1][1] && xxxooo[0][2] == xxxooo[2][0] && (xxxooo[0][2] == 'x' || xxxooo[0][2] == 'o')){
            fin = true;
            if (xxxooo[0][2] == userin.charAt(0))
                userwin = true;
        }
    }

    private void setAiChar(){
        int aiX , aiY ;
        Random random = new Random();
        while (true){
            aiX = random.nextInt(SIZE);
            aiY = random.nextInt(SIZE);
            if (xxxooo[aiX][aiY] != userin.charAt(0) && xxxooo[aiX][aiY] != aiChar) {
                xxxooo[aiX][aiY] = aiChar;
                break;
            }
        }
    }
}
