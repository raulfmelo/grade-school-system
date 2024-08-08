package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private int id;
    private String nome;
    private String sobrenome;
    private LocalDate nascimento;
    private List<Materia> listaDeMaterias = new ArrayList<Materia>();

    public Aluno(int id, String nome, String sobrenome, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nascimento = nascimento;
    }

    public int getID(){
        return id;
    }

    public String getFullName(){
        return nome+" "+sobrenome;
    }

    public void addMateria(Materia materia){
        this.listaDeMaterias.add(materia);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public List<Materia> getListaDeMaterias(){
        return listaDeMaterias;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", nascimento=" + nascimento +
                ", listaDeMaterias=" + listaDeMaterias +
                '}';
    }
}
