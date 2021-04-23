package com.company;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Scanner Entrada = new Scanner(System.in);
        DecimalFormat Decimanl = new DecimalFormat("#");

//        exercicio1(Entrada);
//        exercicio2(Entrada);
//        exercicio3(Entrada);
//        exercicio4(Entrada);
//        exercicio5(Entrada);
//        exercicio6(Entrada, Decimanl);
//        exercicio7(Entrada);
//        exercicio8(Entrada);
    }


    /*
    *   1. Faça um programa que solicite ao usuário que informe a 
    *   matrícula e as três notas de um conjunto de alunos. O programa 
    *   deverá exibir a mensagem informando se o aluno foi aprovado (média maior ou igual a 70), 
    *   exame (nota maior ou igual a 60 e menor que 70) ou reprovado (nota inferior a 60). 
    *   O programa irá terminar quando o usuário informar uma matrícula negativa. 
    */

    public static void exercicio1(Scanner entrada){
        int val[] = new int[3];

        System.out.printf("Informe a matricula do aluno: ");
        int matricula  = entrada.nextInt();

        while (matricula >= 0){

            IntStream.range(0, val.length).forEach(i -> {
                System.out.format("Insira %d nota: ", (i + 1));
                val[i] = entrada.nextInt();
                if(i > 0){
                    val[i] = (val[i - 1] + val[i]);
                }
            });

            System.out.println("O anulo correspondente a matricula " + matricula + " esta: " + (val[val.length - 1] / val.length >= 70 ? "Aprovado" : val[val.length - 1] / val.length >= 60 && val[val.length - 1] / val.length < 70 ? "Exame" : "Reprovado"));

            System.out.printf("Informe a matricula do aluno: ");
            matricula = entrada.nextInt();
        }


    }


    /*
    *    2. A prefeitura de uma cidade fez uma pesquisa entre os seus habitantes, 
    *    coletando dados sobre o salário e o número de filhos. 
    *    A prefeitura deseja saber: 
    *    a ) A média do salário da população; 
    *    b ) A média do número de filhos. 
    *    O final da leitura de dados dar-se-á com a entrada de salários negativos. 
    */

    public static void exercicio2(Scanner entrada){

        float populacao[] = {0,0};
        int filhos[] = new int[1];

        System.out.println("Informe a renda da familia: ");
        float renda = entrada.nextFloat();

        while (renda > 0){
            System.out.println("Insira a quantidade de filhos: ");
            filhos[0] += entrada.nextInt();

            populacao[0] += renda;
            populacao[1] += 1;

            System.out.println("Informe a renda da familia: ");
            renda = entrada.nextFloat();
        }

        System.out.format("A media salararial da populacao e: %,.2f\n" +
                "A media do numero de filhos é: %,.0f ", (populacao[0] / populacao[1]), (filhos[0] / populacao[1]));

    }


    /**
    *   3. Faça um programa que faça a leitura de 5 valores, e para cada valor, 
    *   mostre o seu dobro na tela. 
    */
    public static void exercicio3(Scanner entrada){
        float val[] = new float[5];

        IntStream.range(0, val.length).forEach(i -> {
            System.out.format("Insira %d valor: ", (i + 1));
            val[i] = entrada.nextFloat();

            System.out.println("O dobro do valor digitado e: " + (val[i] * 2));
        });
    }


    /*
    *   4. Faça um programa que leia um número e que 
    *   imprima os números ímpares de 1 até o número informado. 
    */
    public static void exercicio4(Scanner entrada){
        System.out.println("Insira um numero inteiro: ");
        int num = entrada.nextInt();

        IntStream.range(1,num + 1).forEach(i -> {
            if(i % 2 != 0){
                System.out.format("O numero %d e impar\n", i);
            }
        });
    }


    /*
    *   5. Faça um programa que solicite ao usuário que 
    *   informe o valor das temperaturas coletadas nos 
    *   10 primeiros dias do mês de janeiro de 2021, 
    *   em Belo Horizonte. Imprima em seguida a média dessas temperaturas.
    */ 
    public static void exercicio5(Scanner entrada){
        float temp[] = new float[1];

        IntStream.range(0,10).forEach(i -> {
            System.out.format("Insira a temperatura do %d dia: ", i + 1);
            temp[0]+= entrada.nextFloat();
        });

        System.out.println("A media das temperaturas informdas e: " + (temp[0] / 10));
    }

    /*
    *   6. Faça um programa que leia o sexo e o peso de 
    *   10 pessoas, e mostre quantas pessoas do sexo masculino 
    *   possuem peso entre 60 e 80 kg, bem como a quantidade de
    *   mulheres que possuem peso entre 50 e 70 kg. 
    */
    public static void exercicio6(Scanner entrada, DecimalFormat format){

        String val[] = new String[10];
        float pesos[] = new float[2];

        IntStream.range(0, val.length).forEach(i -> {
            System.out.format("Insira o seu sexo, homem ou mulher: ");
            val[i] = entrada.next();

            if(val[i].equalsIgnoreCase("mulher")){
                System.out.printf("Insira o seu peso: ");
                float peso = entrada.nextFloat();

                if(peso >= 50 && peso <= 70)
                    pesos[0]+=1;

            }else{
                System.out.printf("Insira o seu peso: ");
                float peso = entrada.nextFloat();

                if(peso >= 60 && peso <= 80)
                    pesos[1]+=1;
            }
        });

        System.out.printf("" + (pesos[1] > 1 ? format.format(pesos[1])  + " homens" : format.format(pesos[1]) +" homem") + " possuem o peso entre 60Kg e 80Kg.\n" +
                (pesos[0] > 1 ? format.format(pesos[0]) + " mulheres" : format.format(pesos[0]) + " mulher") + " possuem o peso entre 50Kg e 70Kg.");
    }

    /*
    *    7. Faça um programa que leia as notas de 5
    *    alunos, e que exiba a maior e menor notas entre elas.
    */
    public static void exercicio7(Scanner entrada){

        float val[] = {-999999,999999};

        IntStream.range(0, 5).forEach(i -> {
            System.out.format("Insira a nota do %d aluno: ", (i + 1));
            float nota = entrada.nextFloat();

            if(nota > val[0]){
                val[0] = nota;
            }
            if(nota < val[1]){
                val[1] = nota;
            }
        });

        System.out.format("A maior nota digitada foi: %,.2f\n" +
                "A menor nota digitada foi: %,.2f", val[1], val[0]);


    }

    /*
    *    8. Faça um programa que leia a idade e peso de sete pessoas. Calcule e mostre:
    *    - a quantidade de pessoas com mais de 90 kg
    *    - a média das idades das sete pessoas
    */
    public static void exercicio8(Scanner entrada){

        float val[] = {0,0,0};

        IntStream.range(0, 7).forEach(i -> {
            System.out.format("Insira o peso da %d pessoa: ", (i + 1));
            float peso = entrada.nextFloat();
            val[0] += peso;

            System.out.format("Insira a idade da %d pessoa: ", (i + 1));
            val[1] += entrada.nextFloat();

            if(peso > 90){
                val[val.length - 1]++;
            }
        });

        System.out.format("A media dos pesos digitados e: %,.2fKg\n" +
                "A media das idades informadas e: %,.0f\n" +
                "%,.0f pessoas estao com mais 90Kg.", (val[0] / 7), (val[1] / 7) , val[val.length - 1]);
    }
}
