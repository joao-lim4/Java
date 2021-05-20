package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

//        exercicio1(input);
//        exercicio2(input);
//        exercicio3(input);
//        exercicio4(input);
//        exercicio5(input);
//        exercicio6(input);
//        exercicio7(input);
    }

    public static void exercicio1(Scanner Entrada){
        final double[] maior = {-99999};
        double notas[] = new double[10];
        String nomes[] = new String[10];
        final int[] pointer = {(notas.length + 1)};

        IntStream.range(0,(notas.length == nomes.length ? nomes.length :  10) ).forEach(i -> {

            System.out.format("Insira o nome do %d aluno:", i + 1);
            nomes[i] = Entrada.next();

            System.out.format("Insira o nota do %d aluno:", i + 1);
            notas[i] = Entrada.nextDouble();

            if(i > 0){
                for(int k = i; k > -1; k--){
                    if(notas[k] > maior[0]){
                        pointer[0] = k;
                        maior[0] = notas[k];
                    }
                }
            }


        });

        System.out.format("O aluno com a maior nota foi: %s com a nota: %.2f", nomes[pointer[0]], notas[pointer[0]]);

    }

    public static void exercicio2(Scanner Entrada){
        HashMap<String, String[]> infos = new HashMap<String, String[]>();
        double notas[] = new double[12];

        IntStream.range(0, (notas.length - 2)).forEach(i -> {
            String nomeTemp = new String("");

            System.out.printf("Informe o nome do %d aluno:", i + 1);
            nomeTemp = Entrada.next();

            System.out.format("Informe a nota do %d aluno:", i + 1);
            notas[i] = Entrada.nextDouble();

            notas[notas.length - 1] += notas[i];



            infos.put(Integer.toString(i), new String[] {nomeTemp, Double.toString(notas[i])});

            if((i + 1) == (notas.length - 2)){
                notas[notas.length - 2] = notas[notas.length - 1] / (notas.length - 2);
            }
        });

        limpaTela();

        System.out.println("A media das notas foram: " + notas[notas.length - 2]);

        System.out.println("--------------- Notas ---------------");
        for(Map.Entry<String, String[]> aluno : infos.entrySet()){
            String[] value = aluno.getValue();
            if(Double.parseDouble(value[1]) < notas[notas.length - 2]){
                System.out.printf("Aluno %s abaixo da media, nota: %.2f\n", value[0], Double.parseDouble(value[1]));
            }else{
                System.out.printf("Aluno %s acima da media, nota: %.2f\n", value[0], Double.parseDouble(value[1]));
            }
        }

    }

    public static void exercicio3(Scanner Entrada){

        int numbers[] = {3,4,5,6,7,8,33,45,67,90};

        System.out.println("Insira um numero inteiro:");
        int number = Entrada.nextInt();

        if(Arrays.binarySearch(numbers, number) < 0){
            System.out.println("O numero informado não esta no array.");
        }else{
            System.out.format("O numero iformado esta na posicao %d do array.", Arrays.binarySearch(numbers, number));
        }
    }

    public static void exercicio4(Scanner Entrada){
        int arr1[] = {2,3,4,5,6,7,8,9,10};
        int arr2[] = {11,12,13,14,15,16,17,18,19,20};

        int mult[] = new int[10];
        int div[] = new int[10];

        for(int i = 0; i < arr1.length; i++){
            mult[i] = arr1[i] * arr2[i];
            div[i] = arr1[i] / arr2[i];
        }


        System.out.println("O primeiro array e: " + Arrays.toString(arr1));
        System.out.println("O segundo array e: " + Arrays.toString(arr2));
        System.out.println("O array que multiplica e: " + Arrays.toString(mult));
        System.out.println("O0 array que divide e: " + Arrays.toString(div));


    }

    public static void exercicio5(Scanner Entrada){
        int numbers[] = {10,5,-1,-4,50,-90,105,13,-954,100};

        IntStream.range(0, numbers.length).forEach(i -> {
            if(numbers[i] < 0) numbers[i] = 0;
        });

        System.out.println("O array alterado e: " + Arrays.toString(numbers));
    }

    public static void exercicio6(Scanner Entrada){

        int sort[] = {10,3,50,55,32,2};
        String split[];
        int point = 0;
        System.out.println("Informe os numeros jogados separando por espaco ou virgulas:");
        String numbersUser = Entrada.nextLine();

        split = numbersUser.split(numbersUser.indexOf(",") != -1 ? "," : " ");

        for(int i = 0; i < sort.length; i++){
            for (int k = 0; k < split.length; k++){
                if(sort[i] == Integer.parseInt(split[k])){
                    point+=1;
                }
            }
        }

        System.out.println("Voce obteve " + point + " " + (point != 1 ? "pontos" : "ponto"));



    }

    public static void exercicio7(Scanner Entrada){
        double media = 23.5;
        LinkedList<String> acimaDaMedia = new LinkedList<String>();
        LinkedList<String> abaixoDaMedia = new LinkedList<String>();

        IntStream.range(0,48).forEach(i  -> {
            double temp = 19.06 + 0.211 * Math.cos((0.08721 * (i + 1))) + (-5.51 * Math.sin((0.8721 * (i + 1))));

            if(temp < media)
                abaixoDaMedia.push(i + 1 + (i + 1 == 1 ? " hora" : " horas"));
            else
                acimaDaMedia.push(i + 1 + (i + 1 == 1 ? " hora" : " horas"));

        });

        System.out.println("A temperatura media foi: " + media);
        System.out.println("Horas em que a temperaturas acima da media: " + acimaDaMedia);
        System.out.println("Horas em que a temperaturas abaixo da media: " + abaixoDaMedia);


    }

    public static void limpaTela(){
        for(int i = 0; i < 30; i++){
            System.out.print("\n\r");
        }
    }
}
