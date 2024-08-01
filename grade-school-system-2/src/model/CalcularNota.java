package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface CalcularNota {
    public static BigDecimal calcular(double grade1, double grade2, double assignment, double homeWork){
        BigDecimal finalGrade = new BigDecimal((grade1+grade2)*0.2 + assignment*0.5 + homeWork*0.1);
        return finalGrade.setScale(2, RoundingMode.CEILING);
    }
}
