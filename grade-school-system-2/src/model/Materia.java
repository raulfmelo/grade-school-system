package model;

import java.math.BigDecimal;

public class Materia {
    private final String materia;
    private BigDecimal finalGrade;

    public Materia(String materia) {
        this.materia = materia;
    }
    public void setFinalGrade(BigDecimal finalGrade){
        this.finalGrade = finalGrade;
    }
    public String toString(){
        return "\nDisciplina: "+materia+
                "\nNota: "+finalGrade+"\n";
    }
}
