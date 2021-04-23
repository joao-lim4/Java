package com.company;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Scanner;
public class Calc {


    public boolean main(Scanner input, Object[] indice){
        ScriptEngineManager Construct = new ScriptEngineManager();
        ScriptEngine Engine = Construct.getEngineByName("js");

        if(indice[0] == null){
            return false;
        }

        if((Integer) indice[0] >= 0 && (Integer) indice[0] < 4){
            comuns(input, (String)indice[1], Engine);
            return true;
        }else{
            switch ((Integer) indice[0]){
                case 4:
                    System.out.println("Você saiu, vai la man!");
                    System.exit(0);
                    break;
                case 5:
                    System.out.println("Essa é uma funcao onde você pode escrever a sua propria expressao");
                    System.out.println("Um exemplo: 2 + 2");
                    System.out.print("Escreva a sua conta: ");
                    String ex = input.nextLine();
                    Ex(ex, Engine);
                    break;
                default:
                    System.out.println("Nao foi prossivel entender o que você digitou!");
                    System.exit(0);
                    break;
            }
        }


        return false;
    };


    private void comuns(Scanner input, String operador, ScriptEngine engine){
        System.out.println("Insira o primeiro numero: ");
        float x = input.nextFloat();
        System.out.println("Insira o segundo numero: ");
        float y = input.nextFloat();
        try{
            String expresion = " " + x + " " + operador + " " + y +" ";
            System.out.println("Resultado da conta "+ expresion + " e: "+ engine.eval(expresion));
        }catch(Exception e){
            System.out.println("Aconteceu algo de errado em interpretar a string, foi mal!  Sequelei");
            System.exit(0);
        }
    }


    private void Ex(String ex,ScriptEngine engine){
        try{
            System.out.println("Resultado da conta "+ ex + " e: "+ engine.eval(ex));
        }catch(Exception e){
            System.out.println("Aconteceu algo de errado em interpretar a string, foi mal!  Sequelei");
            System.exit(0);
        }
    }



}
