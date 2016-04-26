package com.geekbrains.java.lesson1;

import java.util.Arrays;
import java.util.Random;
import java.io.IOException;

/**
 * Created by Demiurg on 18.04.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Xo xoplay = new Xo();
        Random random = new Random();
        int[] mas = {0,1,0,1,0,1,0,1,0,1};                                              // new int array. Task one
        int[] third = new int[8];
        float taskfive;

        int[] tasksix = new int[random.nextInt(20)+1];                                  // Integer array with random length
        int minelement = 0, maxelement = 0, indexmincount = 0, indexmaxcount = 0;
        int[] indexminelement = new int[tasksix.length];
        int[] indexmaxelement = new int[tasksix.length];   // Task 6 vars


        System.out.println("Task one: " + Arrays.toString(mas));
        mas = invert(mas);                                                              // invert integer array
        System.out.println("Task two: " + Arrays.toString(mas));

        for(int count = 0, iter = 1; iter <= 22; iter = iter + 3){                      // fill third array.
            third[count] = iter;
            count++;
        }
        System.out.println("Task three: " + Arrays.toString(third));

        // Task 5
        taskfive = division(multiplication(plus(2,3),5),2);
        System.out.println("Task five: " + taskfive);

        // Task 6
        for(int iter = 0; iter < tasksix.length; iter++){
            tasksix[iter] = random.nextInt();
            if (tasksix[iter] <= minelement){
                if (tasksix[iter] == minelement)
                    indexmincount++;
                indexminelement[indexmincount] = iter;
                minelement = tasksix[iter];
            }else if(tasksix[iter] >= maxelement){
                if (tasksix[iter] == maxelement)
                    indexmaxcount++;
                indexmaxelement[indexmaxcount] = iter;
                maxelement = tasksix[iter];
            }
        }
        System.out.println("Task Six:---------------------------------------------------------------");
        System.out.println("Array: " + Arrays.toString(tasksix));
        System.out.println("Max element: " + maxelement);
        System.out.print("Indexes of max element: ");
        for (int iter = 0; iter <= indexmaxcount; iter++){
            System.out.print(indexmaxelement[iter] + " ");
        }
        System.out.println("");
        System.out.println("Min element: " + minelement);
        System.out.print("Indexes of min element: ");
        for (int iter = 0; iter <= indexmincount; iter++){
            System.out.print(indexminelement[iter] + " ");
        }
        System.out.println("");
        System.out.println("Task Six:---------------------------------------------------------------");

        // Task XO
        xoplay.xo();
    }

    // Inversion method array
    public static int[] invert(int[] arg){
        for(int iter = 0; iter < arg.length; iter++){
            if(arg[iter] == 0){
                arg[iter] = 1;
            }
            else{
                arg[iter] = 0;
            }
        }
        return arg;
    }

    // The tassk four methods. All methods overloaded.
    // PLUS methods
    public static int plus(int a, int b){
        return a + b;
    }

    public static int plus(short a, short b){
        int c;
        c = a + b;
        return c;
    }

    public static float plus(float a, float b){
        return a + b;
    }

    public static double plus(double a, double b){
        return a + b;
    }

    // MINUS methods
    public static int minus(int a, int b){
        return a - b;
    }

    public static int minus(short a, short b){
        int c;
        c = a + b;
        return c;
    }

    public static float minus(float a, float b){
        return a - b;
    }

    public static double minus(double a, double b){
        return a - b;
    }

    // DIVISION methods
    public static float division(int a, int b){
        return (float) a / b;
    }

    public static float division(float a, float b){
        return a / b;
    }

    public static double division(double a, double b){
        return a / b;
    }

    // MULTIPLICATION methods
    public static int multiplication(int a, int b){
        return a * b;
    }

    public static int multiplication(short a, short b){
        int c;
        c = a * b;
        return c;
    }

    public static float multiplication(float a, float b){
        return a * b;
    }

    public static double multiplication(double a, double b){
        return a * b;
    }
}
