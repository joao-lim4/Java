package com.company;

import com.github.underscore.lodash.U;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;



public class Main {

    //url da api para pegar a cotacao atual do dolar;
    private static String url = "https://economia.awesomeapi.com.br/last/USD-BRL";


    public static void main(String[] args) {
        Scanner Entrada = new Scanner(System.in);
        DecimalFormat DecimalFormat = new DecimalFormat("##,##%");
//        exercicio1(Entrada);
//        exercicio2(Entrada);
//        exercicio3(Entrada);
//        exercicio4(Entrada);
//        exercicio6(Entrada);
//        exercicio7(Entrada);
//        exercicio8(Entrada);
//        exercicio9(Entrada);
//        exercicio10(Entrada);
//        exercicio11(Entrada);
//        exercicio12(Entrada);
//        exercicio12(Entrada);
//        exercicio14(Entrada);
//        exercicio15(Entrada, DecimalFormat);
    }


    public static void exercicio1(Scanner entrada){

        int val[] = new int[3];

        IntStream.range(0, val.length).forEach(i -> {
            System.out.format("Insira %d valor: ", (i + 1));
            val[i] = entrada.nextInt();
            if(i > 0){
                val[i] = (val[i - 1] + val[i]);
            }
        });

        System.out.println("A media dos valores digitados é: " + (val[val.length - 1] / val.length));

    }

    public static void exercicio2(Scanner entrada){

        int AnoAtual = GregorianCalendar.getInstance().get(Calendar.YEAR);
        System.out.println("Insira o ano em que voce nasceu: ");
        int AnoNasc = entrada.nextInt();
        System.out.format("Idade no ano atual %d e: %d\nIdade no ano de 2050 e: %d", AnoAtual,(AnoAtual - AnoNasc), (2050 - AnoNasc));

    }

    public static void exercicio3(Scanner entrada){
        Map DolarObject = HttpGetRequest();
        if(DolarObject != null){
            float ValoresDoDolar[] = {
                 Float.parseFloat(DolarObject.get("low").toString()),
                 Float.parseFloat(DolarObject.get("high").toString())
            };

            System.out.println("Insira o valor que voce tem em dolar: ");
            float DolarUserValue = entrada.nextFloat();

            /*
                *  valores do dolar no array:
                *   [0] baixa do dolar
                *   [1] alta do dolar
            */

            System.out.format("Na cotacao do dolar atual, na baixa voce tem: %f\nNa alta do dolar voce tem: %f", (DolarUserValue * ValoresDoDolar[0]), (DolarUserValue * ValoresDoDolar[1]));

        }else{
            System.out.println("Confira a url de destino, algo de errado aconteceu!");
        }

    }

    public static void exercicio4(Scanner entrada){
        System.out.println("Insira a diagonal maior: ");
        int DgMaior = entrada.nextInt();
        System.out.println("Insira a diagonal menor: ");
        int DgMenor = entrada.nextInt();

        System.out.println("A area do triangulo e: " + ((DgMaior * DgMenor) / 2));
    }

    public static void exercicio5(Scanner entrada){
        System.out.println("Insira a temperatura em celsius: ");
        float tempCelsius = entrada.nextFloat();

        System.out.println("A temperatura em fahrenheit  e: " + ((tempCelsius * 1.8) + 32));
    }

    public static void exercicio6(Scanner entrada){
        int Ig[] = new int[3];
        String Msg[] = {
                "Insira o valor de A: ",
                "Insira o valor de B: ",
                "Insira o valor de C: "
        };

        IntStream.range(0, Ig.length).forEach(i -> {
            System.out.println(Msg[i]);
            Ig[i] = entrada.nextInt();
        });

        int delta = (int) (Math.pow(Ig[1],2) - 4 * Ig[0] * Ig[2]);

        if(delta < 0){
            System.out.println("A equacao passadao não possui raizes pois o delta e menor 0");
        }else{
            double[] raizes = CalcRaizes(Ig, delta);
            System.out.println("O calculo" + (raizes.length > 1 ? " das raizes X1 e X2 sao: " : " da raiz X1 e: ") + (raizes.length > 1 ? "X1: " + (raizes[0]) + " X2: " + (raizes[1]) : "X1: " + (raizes[0])));
        }
    }

    public static void exercicio7(Scanner entrada){
        System.out.println("Insira o valor do salario minimo: ");
        float salarioMin = entrada.nextFloat();

        System.out.println("Insira o seu salario: ");
        float salarioFunc = entrada.nextFloat();

        System.out.println("Esse funcionario ganha: " + (int) ( salarioFunc / salarioMin) + " salario(s) minimo(s)");
    }

    public static void exercicio8(Scanner entrada){
        System.out.println("Insira um numero: ");
        int num = entrada.nextInt();

        IntStream.range(0, 11).forEach(i -> {
            System.out.println("" + num + " x " + i + " = " + (num * i) + "");
        });
    }

    public static void exercicio9(Scanner entrada){
        System.out.println("Insira um numero positivo: ");
        int num = entrada.nextInt();

        System.out.format("O quadrado do numero e: %,.0f \n" +
                "O cubo do numero e: %,.0f \n" +
                "A raiz quadrada do numero e: %,.2f \n" +
                "A raiz cubica do numero e: %,.2f",
                (Math.pow(num,2)), (Math.pow(num,3)), Math.sqrt(num), Math.cbrt(num));
    }

    public static void exercicio10(Scanner entrada){
        System.out.println("Insira o valo gasto no restaurante: ");
        float valorGasto = entrada.nextFloat();

        System.out.println("O valor da gorjeta e: R$" + ((valorGasto * 10) / 100));
    }

    public static void exercicio11(Scanner entrada){
        System.out.println("Insira um numero inteiro: ");
        int num = entrada.nextInt();

        System.out.format("O antecessor do numero e: %d\n" +
                "O sucessor do numero e: %d\n" +
                "O dobro e: %d\n" +
                "A metade e: %,.2f", (num - 1), (num + 1), (num * 2),((float) num / 2));
    }

    public static void exercicio12(Scanner entrada){
        System.out.println("Insira a sua altura em metros: ");
        float altura = entrada.nextFloat() * 100;

//      System.out.println("Seu peso ideal e: " + ((72.7 * altura) - 58));  resultado estranho peguei outra formula na web;

        System.out.format("Seu peso ideal e: %,.2f", ((altura - 100) * 0.90));
    }

    public static void exercicio13(Scanner entrada){
        System.out.println("Insira a sua altura em metros: ");
        float altura = entrada.nextFloat() * 100;

//      System.out.println("Seu peso ideal e: " + ((72.7 * altura) - 58));  resultado estranho peguei outra formula na web;

        System.out.format("Seu peso ideal e: %,.2f", ((altura - 100) * 85));
    }

    public static void exercicio14(Scanner entrada){
        float vals[] = new float[2];

        IntStream.range(0, vals.length).forEach(i -> {
            System.out.format("Insira %d valor: ", (i + 1));
            vals[i] = entrada.nextInt();
        });

        System.out.format("O valor de A: %,.2f\n" +
                "O valor de B: %,.2f", vals[1], vals[0]);
    }

    public static void exercicio15(Scanner entrada, DecimalFormat formatPercent){
        System.out.println("Insira a quantidade total de eleitores: ");
        int eleitores = entrada.nextInt();

        int vals[] = new int[2];

        IntStream.range(0, vals.length).forEach(i -> {
            System.out.format("Insira os votos do %d candidato: ", (i + 1));
            vals[i] = entrada.nextInt();
        });

        System.out.format("O primeiro candidato teve %s de votos.\n" +
                "O segundo candidato teve %s de votos.\n" +
                "A eleicao teve %d votos nulos.", formatPercent.format(((float)vals[0] / eleitores) * 100) , formatPercent.format (((float)vals[1] / eleitores) * 100), eleitores - (vals[0] + vals[1]));

    }

    /*
    * Utills
    */
    public static Map JsonConvert(String json){
        json = json.substring(10,(json.length() - 1)); // substring feito para o JSON retornado da API
        Map<String, Object> jsonObject = U.fromJsonMap(json);
        return jsonObject;
    }

    public static Map HttpGetRequest(){
        try {
            URL CotacaoDolar = new URL(url);
            URLConnection CotacaoDolarConection = CotacaoDolar.openConnection();
            BufferedReader response = new BufferedReader(new InputStreamReader(CotacaoDolarConection.getInputStream()));
            Map responseJSON = JsonConvert(response.readLine());
            response.close();
            return responseJSON;
        } catch (IOException e) {
            return null;
        }
    }

    public static double[] CalcRaizes(int Vals[], int delta){
        if(delta > 0){
            double x1 = (-Vals[1] + Math.sqrt(delta)) / (2 * Vals[0]);
            double x2 = (-Vals[1] - Math.sqrt(delta)) / (2 * Vals[0]);

            return new double[] {x1,x2};
        }else{
            double x1 = (-Vals[1] + Math.sqrt(delta)) / (2 * Vals[0]);
            return new double[] {x1};
        }
    }

}
