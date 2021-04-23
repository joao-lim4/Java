package com.company;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args){
        Scanner Input = new Scanner(System.in);
        DecimalFormat Decimal = new DecimalFormat("#0.00");
        //exercicio1(Input);
        //exercicio2(Input);
        //exercicio3(Input);
        //exercicio4(Input);
        //exercicio5(Input, Decimal);
        //exercicio6(Input, Decimal);
        //exercicio7(Input);
        //exercicio8(Input);
        //exercicio9(Input);
        //exercicio10(Input);
        //exercicio11(Input);
        //exercicio12(Input);
    }


    public static void exercicio1(Scanner entrada){
        System.out.println("Insira o primeiro numero: ");
        int x = entrada.nextInt();
        System.out.println("Insira o segundo numero:");
        int y = entrada.nextInt();

        if(x != y)
            System.out.println("O maior numero é: " + (x < y ? y : x) + " e o menor numero e: " + (x < y ? x : y));
        else
            System.out.println("Os numeros sao iguais");
    }

    public static void exercicio2(Scanner entrada){
        System.out.print("Insira a primeira nota: ");
        int x = entrada.nextInt();
        System.out.print("Insira a segunda nota: ");
        int y = entrada.nextInt();

        System.out.print((x + y) / 2 >= 7 ? "Aprovado" : "Reprovado");

    }

    public static void exercicio3(Scanner entrada){

        int[] notas = new int[3];
        int media = 0;
        for(int i = 0; i < 3; i++){
            System.out.print("Insira a nota do aluno: ");
            notas[i] = entrada.nextInt();
            media+=notas[i];
        }
        media = media / notas.length;

        System.out.println(media >= 0 && media < 3 ? "Reprovado" : media >= 3 && media < 7 ? "Exame" : "Aprovado" );

    }

    public static void exercicio4(Scanner entrada){
        // triangunlo e o meu ponto fraco, o meu primeiro execicio de logica a tres anos atras foi a mesma coisa desse aqui;
        // nao tenho emocional para fazer esse exercicio kkk
    }

    public static void exercicio5(Scanner entrada, DecimalFormat decimal){
        System.out.println("Informe o seu sexo, ex  1 para masculino || 2 para Feminino : ");
        int sexo = entrada.nextInt();
        System.out.println("Informe a sua altura em cm: ");
        int altura = entrada.nextInt();

        if(sexo == 1){
            System.out.print("Seu peso ideal e: " + decimal.format(((72.7 * ((float) altura / 100)) - 58)));
        }else{
            System.out.println("Seu peso ideial e: " + decimal.format(((62.1 * ((float) altura / 100)) - 44.7)));
        }
    }

    public static void exercicio6(Scanner entrada, DecimalFormat decimal){
        System.out.println("Insira o seu em kg: ");
        double peso = entrada.nextDouble();
        System.out.println("Insira a sua altura em cm: ");
        int altura = entrada.nextInt();

        double imc = (float) peso/Math.pow((float) altura / 100, 2);

        if(imc < 20){
            System.out.println("Abaixo do peso");
        }else if(imc >= 20 && imc < 25){
            System.out.println("Peso normal");
        }else if(imc >= 25 && imc < 30){
            System.out.println("Sobre peso");
        }else if(imc >= 30 && imc < 40){
            System.out.println("Obeso");
        }else{
            System.out.println("Obeso Morbido");
        }

    }

    public static void exercicio7(Scanner entrada){
        System.out.println("Insira o seu salario: ");
        double salario = entrada.nextDouble();

        if(salario < 1000){
            System.out.println("Salario reajustado: R$" + (salario + ((30 * salario) / 100)));
        }else {
            System.out.println("Nao tem direito ao reajuste!");
        }
    }

    public static void exercicio8(Scanner entrada){
        System.out.println("Insira a sua idade: ");
        int idade = entrada.nextInt();

        if(idade <= 7){
            System.out.println("INFANTIL");
        }else if(idade >= 8 && idade <= 10){
            System.out.println("JUVENIL");
        }else if(idade >= 11 && idade <= 15){
            System.out.println("ADOLESCENTE");
        }else if(idade >= 16 && idade <= 30){
            System.out.println("ADULTO");
        }else{
            System.out.println("SENIOR");
        }

    }

    public static void exercicio9(Scanner entrada){
        System.out.println("Insira a sua idade: ");
        int idade = entrada.nextInt();

        if(idade < 16){
            System.out.println(" não eleitor");
        }else if(idade >= 16 && idade < 18 || idade > 65 ){
            System.out.println("eleitor facultativo");
        }else{
            System.out.println("eleitor obrigatório");
        }
    }

    public static void exercicio10(Scanner entrada){
        System.out.println("Insira o dia da semana: ");
        int dia = entrada.nextInt();

        switch (dia){
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terca-feira");
                break;
            case 4:
                System.out.println("Quarta-feira");
                break;
            case 5:
                System.out.println("Quinta-feira");
                break;
            case 6:
                System.out.println("Sexta-feira");
                break;
            case 7:
                System.out.println("Sabado");
                break;
            default:
                System.out.println("Insira o dia corretamente, numeros entra 1 e 7");
                break;
        }

    }

    public static void exercicio11(Scanner entrada){
        System.out.println("Insira o dia da semana: ");
        int mes = entrada.nextInt();

        switch (mes){
            case 1:
                System.out.println("Janeiro");
                break;
            case 2:
                System.out.println("Fevereiro");
                break;
            case 3:
                System.out.println("Marco");
                break;
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Maio");
                break;
            case 6:
                System.out.println("Junho");
                break;
            case 7:
                System.out.println("Julho");
                break;
            case 8:
                System.out.println("Agosto");
                break;
            case 9:
                System.out.println("Setembro");
                break;
            case 10:
                System.out.println("Outubro");
                break;
            case 11:
                System.out.println("Novembro");
                break;
            case 12:
                System.out.println("Dezembro");
                break;
            default:
                System.out.println("Insira um mes corretamente, numeros entra 1 e 12");
                break;
        }
    }

    public static void exercicio12(Scanner entrada){
        //o mesmo exercicio de uma forma mais legal em https://github.com/joao-lim4/Calculadora-java

//        boolean loop = true;
//        double x,y;
//        while (loop) {
//            System.out.println("Insira o valor para executar a operacao");
//            System.out.println("1 - Somar");
//            System.out.println("2 - Subtrair");
//            System.out.println("3 - Multiplicar");
//            System.out.println("4 - Dividir");
//            System.out.println("5 - Sair");
//            System.out.print("Escolha: ");
//            int escolha = entrada.nextInt();
//
//            switch (escolha) {
//                case 1:
//                    System.out.println("Insira o primeiro numero");
//                    x = entrada.nextDouble();
//                    System.out.println("Insira o primeiro numero");
//                    y = entrada.nextDouble();
//
//                    System.out.println("O valor da soma é: " + (x + y));
//                    limpaTela();
//                    break;
//                case 2:
//                    System.out.println("Insira o primeiro numero");
//                    x = entrada.nextDouble();
//                    System.out.println("Insira o primeiro numero");
//                    y = entrada.nextDouble();
//
//                    System.out.println("O valor da subtracao é: " + (x - y));
//                    limpaTela();
//                    break;
//                case 3:
//                    System.out.println("Insira o primeiro numero");
//                    x = entrada.nextDouble();
//                    System.out.println("Insira o primeiro numero");
//                    y = entrada.nextDouble();
//
//                    System.out.println("O valor da multiplicacao é: " + (x * y));
//                    limpaTela();
//                    break;
//                case 4:
//                    System.out.println("Insira o primeiro numero");
//                    x = entrada.nextDouble();
//                    System.out.println("Insira o primeiro numero");
//                    y = entrada.nextDouble();
//
//                    System.out.println("O valor da divisao é: " + (x / y));
//                    limpaTela();
//                    break;
//                case 5:
//                    loop = false;
//                    System.out.println("Voce saiu!");
//                    System.exit(0);
//            }
//        }
    }

    public static void limpaTela(){
        for(int i = 0; i < 400; i++){
            System.out.print("\r\n");
        }
    }
}
