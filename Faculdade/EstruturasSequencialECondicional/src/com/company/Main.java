package com.company;

import com.github.underscore.lodash.U;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Main {

    /*
    *    Url defaul para pegar o valor atual do dolar. 
    *    Evitar trocar a url para que tudo funcione como o esperado.
    *    Se trocar a url, refatore o metodo JsonConvert. Pois atualmente 
    *    ele converte somente o JSON rotarnado dessa api.
    */
    private static String url = "https://economia.awesomeapi.com.br/last/USD-BRL";


    public static void main(String[] args) {
        Scanner Entrada = new Scanner(System.in);
        Random Random = new Random();

        //exercicio1(Entrada);
        //exercicio2(Entrada);
        //exercicio3(Entrada);
        //exercicio4(Entrada);
        //exercicio5(Entrada);
        //exercicio6(Entrada);
        //exercicio7(Entrada);
        //exercicio8(Entrada);
        exercicio9(Entrada, Random);
        //exercicio10(Entrada);

    }

    /*
    *    1- Receba um número positivo, calcule e mostre:
    *        a. O número digitado ao quadrado
    *        b. O número digitado ao cubo
    *        c. A raiz quadrada do número digitado
    *        d. A raiz cúbica do número digitado.
    */
    public static void exercicio1(Scanner entrada){
        System.out.println("Insira um numero positivo: ");
        int num = entrada.nextInt();

        System.out.format("O quadrado do numero e: %,.0f \n" +
                        "O cubo do numero e: %,.0f \n" +
                        "A raiz quadrada do numero e: %,.2f \n" +
                        "A raiz cubica do numero e: %,.2f",
                (Math.pow(num,2)), (Math.pow(num,3)), Math.sqrt(num), Math.cbrt(num));
    }

    /*
    *    2. Faça um programa que, tendo como dados de entrada a 
    *    altura (H - em metros) de um homem, calcule e apresente seu peso 
    *    ideal utilizando a seguinte fórmula: 
    *    Peso ideal (P) = (72,7 * H) – 58.
    */
    public static void exercicio2(Scanner entrada){
        System.out.println("Insira a sua altura em metros: ");
        float altura = entrada.nextFloat();

        System.out.format("Seu peso ideal e: %,.2f", ((72.7 * altura) - 58));

    }

    /*
    *    3. Faça um programa que receba a cotação do dólar em reais, 
    *    e um valor que o usuário possui em dólares. Imprima este valor em reais.
    */
    public static void exercicio3(Scanner entrada){
        
        /*
        *    Para rodar esse exercico e preciso instalar a lib
        *    O arquivo java da lib pode ser baixado em 
        *    https://github.com/joao-lim4/EstruturasSequencialCondicional;
        *    Apos baixar e so instalar em seu projeto e rodar o exercicio.
        */

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

            System.out.format("Na cotacao do dolar atual, na baixa voce tem: R$%,.2f\nNa alta do dolar voce tem: R$%,.2f", (DolarUserValue * ValoresDoDolar[0]), (DolarUserValue * ValoresDoDolar[1]));

        }else{
            System.out.println("Confira a url de destino, algo de errado aconteceu!");
        }

    }
    
    /*
    *    4. Faça um programa que receba uma temperatura em Celsius, 
    *    calcule e mostre essa temperatura em Fahrenheit (F = (C*1,8) + 32)
    */
    public static void exercicio4(Scanner entrada){
        System.out.println("Insira a temperatura em celsius: ");
        float tempCelsius = entrada.nextFloat();

        System.out.println("A temperatura em fahrenheit  e: " + ((tempCelsius * 1.8) + 32));
    }

    /*
    *    5. Faça um programa que solicite ao usuário que informe os 
    *    coeficientes a, b e c de uma equação de segundo grau, 
    *    e que imprima as raízes desta equação (considere que os 
    *    valores informados sempre retornarão raízes reais para a equação).
    */
    public static void exercicio5(Scanner entrada){
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

    /*
    *    6. Faça um programa que receba dois números e mostre o 
    *    maior e o menor. Emita uma mensagem, caso os dois sejam iguais.
    */
    public static void exercicio6(Scanner entrada){
        System.out.println("Insira o primeiro numero: ");
        int x = entrada.nextInt();
        System.out.println("Insira o segundo numero:");
        int y = entrada.nextInt();

        if(x != y)
            System.out.println("O maior numero é: " + (x < y ? y : x) + " e o menor numero e: " + (x < y ? x : y));
        else
            System.out.println("Os numeros sao iguais");
    }

    /*
    *    7. Faça um programa que receba as duas notas de um aluno, 
    *    calcule sua média, e que imprima a sua situação: 
    *        >= 7 -> Aprovado
    *        < 7 -> Reprovado
    */
    public static void exercicio7(Scanner entrada){
        float val[] = new float[1];

        IntStream.range(0,2).forEach(i -> {
            System.out.format("insira a %d nota do aluno: ", i + 1);
            val[val.length - 1] += entrada.nextFloat();
        });

        System.out.println("O aluno esta: " + ((val[val.length - 1] / 2) >= 7 ? "Aprovado" : "Reprovado"));
    }

    /*
    *    8. Faça um programa que receba 3 notas de um aluno, 
    *    calcule e mostre uma mensagem de acordo com sua média:
    *       >= 0 && < 3 Reprovado
    *       >= 3 && < 7 Exame
    *       >= 7 && <= 10 Aprovado
    */
    public static void exercicio8(Scanner entrada){

        float val[] = new float[2];

        IntStream.range(0, 3).forEach(i -> {
            System.out.format("Insira a %d nota do aluno: ", (i  + 1));
            val[val.length - val.length] += entrada.nextFloat();

            if(i == val.length){
                val[val.length - 1] = val[val.length - val.length] / 3;
            }
        });

        System.out.println("O aluno esta: " + (val[1] >= 0 && val[1] < 3 ? "Reprovado" : val[1] >= 3 && val[1] < 7 ? "Exame" : val[1] >= 7 && val[1] <= 10 ? "Aprovado" : "O aluno ta mais que aprovado pow!"));
    }

    /*
    *    9. Dados três valores X,Y,Z, verificar se eles podem ser os 
    *    comprimentos dos lados de um triângulo. 
    *    Se eles não formarem um triângulo escrever uma mensagem. 
    *    Considerar que o comprimento de cada lado de um 
    *    triângulo é menor que a soma dos outros dois lados.
    */
    public static void exercicio9(Scanner entrada, Random random){
        int val[] = new int[3];

        IntStream.range(0, val.length).forEach(i -> {
            System.out.format("Insira um valor inteiro do %d lado: ", (i + 1));
            val[i] = entrada.nextInt();
        });

        if(TestCaseTriangulo(val,random, 50)){
            System.out.println("Os valores informados forma um triangulo!");
        }else{
            System.out.println("Os valores informados nao formam um triangulo!");
        }

    }


    /*
    *    10. Construa um programa para determinar se o 
    *    indivíduo está com um peso favorável. Essa situação é 
    *    determinada através do IMC (Índice de Massa Corpórea), 
    *    que é definida como sendo a relação entre o peso 
    *    (PESO – em kg) e o quadrado da Altura (ALTURA – em m) 
    *    do indivíduo. Ou seja,
    *        IMC= PESO/ALTURA2
    *    e, a situação do peso é determinada pela tabela abaixo:
    *
    *    IMC < 20 == Abaixo do peso
    *    IMC >= 20 && < 25 == Peso normal
    *    IMC >= 25 && < 30 == Sobre peso
    *    IMC >= 30 && < 40 == Obeso
    *    IMC > 40  == Obeso Morbido
    */
    public static void exercicio10(Scanner entrada){
        float val[] = new float[2];

        String outputs[] = {
                "Insira o seu peso em Kg: ",
                "Insira a sua altura em metros: "
        };

        IntStream.range(0, val.length).forEach(i -> {
            System.out.println(outputs[i]);
            val[i] = entrada.nextFloat();
        });

        double imc = (val[0] / (Math.pow(val[1],2)));

        if(imc < 20){
            System.out.println("Abaixo do peso!");
        }else if(imc >= 20 && imc <= 25){
            System.out.println("Peso normal!");
        }else if(imc > 25 && imc <= 30){
            System.out.println("Sobre peso!");
        }else if(imc > 30 && imc <= 40){
            System.out.println("Obeso!");
        }else{
            System.out.println("Obeso morbido!");
        }

    }


    //Utils

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

    public static boolean TestCaseTriangulo(int lados[], Random random, int iterations){
        Integer randons[] = {99,99,99};
        int count = 0;
        int not = 0;
        while (count < iterations){
            for(int k = 0; k < randons.length; k++){
                int numberRandom = random.nextInt((2 - 0) + 1) + 0;
                if(!Arrays.asList(randons).contains(numberRandom)){
                    randons[k] = numberRandom;
                }else{
                    while (Arrays.asList(randons).contains(numberRandom)){
                        int newGenerate = random.nextInt((2 - 0) + 1) + 0;
                        if(!Arrays.asList(randons).contains(newGenerate)){
                            randons[k] = newGenerate;
                            break;
                        }else{
                            continue;
                        }
                    }
                }
            }
            if((lados[randons[0]] + lados[randons[1]]) < lados[randons[2]]){
                return true;
            }else{
                IntStream.range(0, randons.length).forEach(j -> {
                    randons[j] = 99;
                });
                not++;
                if((count + 1) == iterations && not > 0){
                    return false;
                }
            }
            count++;
        }
        return false;
    }

}
