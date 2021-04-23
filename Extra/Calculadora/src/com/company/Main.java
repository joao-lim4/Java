package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Calc calc = new Calc();
        Scanner input = new Scanner(System.in);
        FormatString Format = new FormatString();
        init(menu, input, Format,calc);
    }

    public static void init(Menu menu, Scanner input, FormatString format, Calc calc){
        for(String i : menu.menuRender){
            System.out.println(i);
        }
        String escolha = format.Format(menu.escolha());
        Object[] value = menu.main(escolha);
        calc.main(input,value);
    }
}
