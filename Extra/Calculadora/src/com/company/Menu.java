package com.company;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

     Map<String, String> options = new HashMap<String, String>();

     String[] menuRender = {
             "----------------------------------------------------",
            "----------------------------------------------------",
            "--------------Bem vindo a calculadora---------------",
            "--       Siga as instrucoes para usar.            --",
            "--   Digite o nome da funcao mostrada no menu e   --",
            "--   em seguida aperte enter.                     --",
            "--   Ex: Somar                                    --",
            "--   Aqui vai o menu bagacera, digita certo em.   --",
            "--   --- Somar                                    --",
            "--   --- Subtrair                                 --",
            "--   --- Dividir                                  --",
            "--   --- Multiplicar                              --",
             "--   --- Ecrever                                  --",
            "--   --- Sair                                     --",
            "----------------------------------------------------",
            "----------------------------------------------------",
             "----------------------------------------------------",
    };
     String[] escolhaArr = {
             "----------------------------------------------------",
             "----------------------------------------------------",
             "---------------- Escolha uma opcao -----------------",
             "----------------------------------------------------",
             "----------------------------------------------------",
             "----------------------------------------------------",
     };

    String[][] valuesOfKey = {
            {"somar","suma","sona","som","sum","plus","mais","1 - somar","1 -somar", "1-somar","1- somar","1", "+"},
            {"subtrair","tirar", "remover","fazer conta de menos", "sub","2 - subtrair","2 -subtrair", "2-subtrair","2- subtrair","2","-"},
            {"dividir", "divisao", "divido", "dividendo","3 - dividir","3 -dividir", "3-dividir","3- dividir","3", "/"},
            {"vezes","fazer conta de vezes","multiplicar","4 - multiplicar","4 -multiplicar", "4-multiplicar","4- multiplicar","3","*"},
            {"ir de base", "sair", "cai fora", "vazar", "to indo","boa noite","5 - sair","5 -sair", "5-sair","5- sair", "5"},
            {"escrever", "escreva", "escreval", "escrev", "escrevaa", "fazer", "desenvolver","escriver","6"}
    };

    String[] keysOfMap = {
            "somar",
            "subtrair",
            "dividir",
            "multiplicar",
            "sair",
            "escrever"
    };

    public Object[] main(String key){
        for(int i = 0; i < this.keysOfMap.length; i++){
            this.options.put(this.keysOfMap[i], Arrays.toString(this.valuesOfKey[i]));
        }
        Object[] initialState = _constructor(key);
        return initialState;
    };



    public String escolha(){
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < this.escolhaArr.length / 2; i++){
            System.out.println(this.escolhaArr[i]);
        };
        String option = input.nextLine();
        for (int i = this.escolhaArr.length / 2; i < this.escolhaArr.length; i++){
            System.out.println(this.escolhaArr[i]);
        }
        return option;
    };



    private Object[] _constructor(String key){
        String format = new FormatString().Format(key);
        Object[] ObjectValue = new Object[2];
        for(int i = 0; i < this.keysOfMap.length; i++){
            for(int k = 0; k < this.valuesOfKey[i].length; k++){
                  if(format.equalsIgnoreCase(this.valuesOfKey[i][k])){
                        ObjectValue[0] = i;
                        ObjectValue[1] = this.valuesOfKey[i][this.valuesOfKey[i].length - 1];
                        return ObjectValue;
                  }
              }
        }

        return  null;
    };





}
