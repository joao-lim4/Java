package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random Randomico = new Random();
//        exercicio1(input);
//        exercicio2(input, Randomico);
//        exercicio3(input, Randomico);
//        exercicio4(input, Randomico);
//        exercicio5(input, Randomico);
    }

    public static void exercicio1(Scanner Entrada){
        double numbers[][] = {{1,2,3}, {4,5,6}, {7,8,9}};

        System.out.println("Insira o valor a se multiplicado:");
        double value = Entrada.nextDouble();

        for(int i = 0; i < numbers.length; i++){
            for (int k = 0; k < numbers[i].length; k++ ){
                System.out.println("Multiplicando:  " + numbers[i][k] + " x " + value + " = " + numbers[i][k] * value);
            }
        }
    }

    public static void exercicio2(Scanner Entrada, Random random){
        Integer matriz[][] = generateMatriz(4,4, random,true);
        int maiores[] = {-9999,-9999,-9999,-9999};

        for(int i = 0; i < matriz.length; i++){
            for(int k = 0; k < matriz[i].length; k++){
                if(matriz[i][k] > maiores[i]){
                    maiores[i] = matriz[i][k];
                }
            }
        }

        System.out.println("O maires numeros sao: " + Arrays.toString(maiores));
    }

    public static void exercicio3(Scanner Entrada, Random random){
        Integer matriz[][] = generateMatriz(4,4,random, true);

        System.out.println("Insira o numero da linha sendo de 1 a " + matriz.length);
        int line = Entrada.nextInt();

        System.out.println("Os numeros da linha informada e: " + Arrays.toString(matriz[line - 1]));

    }

    public static void exercicio4(Scanner Entrada, Random random){
        Integer matriz[][] = generateMatriz(4,4,random, true);

        System.out.println("Insira o numero da coluna sendo de 1 a " + matriz[0].length);
        int coluna = Entrada.nextInt();

        System.out.println("Os os valores da coluna sao: " + matriz[random.nextInt(matriz.length - 1)][coluna - 1]);
    }

    public static void exercicio5(Scanner Entrada, Random random){

        String candidatos[] = {"Jaozin", "Lima", "Marcella","Gustavo"};

        Integer votos[][] = generateMatriz(4,6,random,true);


        int maior = -9999;
        int mes = 0;
        int idiceCandidato = -99;
        int menor = 99999;
        int indiceCandidatoMenor = -99;

        while (mes < 6){
            for(int j = 0; j < votos.length; j++){
                if(votos[j][mes] > maior){
                    maior = votos[j][mes];
                    idiceCandidato = j;
                }

                if(votos[j][mes] < menor){
                    menor = votos[j][mes];
                    indiceCandidatoMenor = j;
                }
            }

            System.out.println("O candidato com maior quantidade de votos no " + (mes + 1) + " mes e: " + candidatos[idiceCandidato] + " com " + maior +  (maior == 1 ? " voto" : " votos"));
            System.out.println("O candidato com a menor quantidade de votos no " + (mes + 1) + " mes e: " + candidatos[indiceCandidatoMenor] + " com " + menor +  (menor == 1 ? " voto" : " votos"));

            mes++;
        }
    }

    public static Integer[][] generateMatriz(int linhas, int colunas,Random randomico, boolean random){
        Integer matriz[][] = new Integer[linhas][colunas];

        if(random){
            for(int i = 0; i < matriz.length; i++){
                for(int k = 0; k < matriz[i].length; k++){
                    matriz[i][k] = randomico.nextInt(100);
                }
            }

            return matriz;
        }else{
            return new Integer[linhas][colunas];
        }
    }
}
