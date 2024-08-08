package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Materia {
    private String nome;
    private double prova1;
    private double prova2;
    private double trabalho;
    private double tarefa;

    public Materia(String nome, double prova1, double prova2, double trabalho, double tarefa) {
        this.nome = nome;
        this.prova1 = prova1;
        this.prova2 = prova2;
        this.trabalho = trabalho;
        this.tarefa = tarefa;
    }

    public void setProva1(double prova1) {
        this.prova1 = prova1;
    }

    public void setProva2(double prova2) {
        this.prova2 = prova2;
    }

    public void setTrabalho(double trabalho) {
        this.trabalho = trabalho;
    }

    public void setTarefa(double tarefa) {
        this.tarefa = tarefa;
    }

    public String getNome() {
        return nome;
    }
    public BigDecimal getNotaFinal(){
        BigDecimal nota = new BigDecimal((prova1+prova2)*0.2 + trabalho*0.5 + tarefa*0.1);
        return nota.setScale(2, RoundingMode.CEILING);
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nome='" + nome + '\'' +
                ", prova1=" + prova1 +
                ", prova2=" + prova2 +
                ", trabalho=" + trabalho +
                ", tarefa=" + tarefa +
                ", Media=" + getNotaFinal() +
                '}';
    }
}
