package model;

import java.util.List;
import java.util.Scanner;

public interface CadastrarAluno {

    public static void cadastrar(List<Aluno> listaDeAluno){
        Scanner scan = new Scanner(System.in);

        System.out.println("Infome o nome do aluno:");
        String nome = scan.next();
        System.out.println("Informe o sobrenome do aluno:");
        String sobrenome = scan.next();
        Aluno aluno = new Aluno(nome, sobrenome);

        System.out.println("Informe o DIA de nascimento:");
        int dia = scan.nextInt();
        System.out.println("Informe o MÊS de nascimento:");
        int mes = scan.nextInt();
        System.out.println("Informe o ANO de nascimento:");
        int ano = scan.nextInt();
        aluno.setDataNascimento(dia,mes,ano);

        boolean loop = true;

        while (loop){
            System.out.println("Escolha uma opção:");
            System.out.println("1- Cadastrar Matéria \n2- Voltar ao início");
            if (scan.nextInt() == 1){
                aluno.setMaterias(CadastrarMateria.cadastrar());
                System.out.println(aluno);
            }else {
                loop = false;
                listaDeAluno.add(aluno);
                System.out.println("!Escolheu voltar ao início!");
                Menu.menu();
            }
        }
    }
}
