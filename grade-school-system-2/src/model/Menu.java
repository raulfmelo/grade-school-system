package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Menu {
    Scanner scan = new Scanner(System.in);
    List<Aluno> listaDeAluno = new ArrayList<Aluno>();

    public static void menu(){
        System.out.print("!Bem vindo ao Menu!"+
                            "\nEscolha uma das opções:"+
                            "\n|1- Cadastrar Aluno"+
                            "\n|2- Listar Alunos\n"
        );
        switch (scan.nextInt()){
            case 1:
                //Metodo de cadastro
                System.out.println("Escolheu cadastrar");
                CadastrarAluno.cadastrar(listaDeAluno);
                break;
            case 2:
                //Metodo de listagem
                System.out.println("Escolheu listar");
                listaDeAluno.forEach(System.out::println);
                Menu.menu();
                break;
            default:
                System.out.println("!OPÇÃO INVÁLIDA!");
                System.out.println("Escolha uma das opções abaixo:");
                Menu.menu();
        }
    }
}
