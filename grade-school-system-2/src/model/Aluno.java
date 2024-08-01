package model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluno {
    private  final String nome;
    private final String sobrenome;
    private Date dataNascimento;
    private List<Materia> materias = new ArrayList<>();

    DateFormat formataData = DateFormat.getDateInstance();

    public Aluno(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    public void setDataNascimento(int dia, int mes, int ano){
        this.dataNascimento = FormataData.nascimento(dia,mes,ano);
    }
    public void setMaterias(Materia materia){
        this.materias.add(materia);
    }

    public String toString(){
        return "Aluno: "+nome+" "+sobrenome+"\n"+
                "Data de nascimento: "+formataData.format(dataNascimento)+"\n"+
                "Materias: "+materias;
    }
}
