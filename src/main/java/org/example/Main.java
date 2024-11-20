package org.example;

import java.util.Arrays;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Выводится инфа в консоль
        /*awdawdawd
        awd
        aw
        da
        wdawawawd
        //Целочисленное
        byte number = 120;
        short number1 = 318;
        int number2Result = 59578;
        long number3 = 894789498;
        //дроби
        float number4 = 12.24f;
        double number5 = 123.21;
        //Символ
        char symbol = '%';
        //Логические переменные
        boolean result = true;
        boolean result1 = false;
        int test = 15;
        int test1 = 5;
        int test2 = test / test1;
        System.out.println(test2);

        String name = "Алексей";
        String name1 = "Дмитрий";
        System.out.println(name+name1);
        System.out.println(name.toUpperCase(Locale.ROOT));
        System.out.println(name.toLowerCase(Locale.ROOT));
        System.out.println(name.length());
        boolean result;
        if (name.equals(name1)) {
            result = true;
        }
        else result = false;
        System.out.println(result);


        boolean result;
        int i = 2;
        if (i>3){
            System.out.println("Больше 3");
        }
        else if(i==3){
            System.out.println("Равно 3");
        }

        else System.out.println("Меньше 3");

        for (int i = 2; i < 10; i++){
            System.out.println(i);
          */
        int [] arr = new int [5];
        int [] arr2 = {5, 10, 15, 20, 25};
        for (int i = 0; i <arr2.length; i++)
        System.out.println(Arrays.toString(arr2));

        }
    }