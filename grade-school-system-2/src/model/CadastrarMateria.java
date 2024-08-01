package model;

import java.util.Scanner;

public interface CadastrarMateria {
    public static Materia cadastrar(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe a materia que deseja cadastrar:");
        Materia materia = new Materia(scan.next());
        System.out.println("Nota da prova 1");
        double grade1 = scan.nextInt();
        System.out.println("Nota da prova 2");
        double grade2 = scan.nextInt();
        System.out.println("Nota da trabalho");
        double assignment = scan.nextInt();
        System.out.println("Nota da tarefa");
        double homeWork = scan.nextInt();

        materia.setFinalGrade(CalcularNota.calcular(grade1,grade2,assignment,homeWork));
        return materia;
    }
}
