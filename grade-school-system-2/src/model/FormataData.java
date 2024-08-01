package model;

import java.util.Calendar;
import java.util.Date;

public interface FormataData {
    public static Date nascimento(int dia, int mes, int ano){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH,dia);
        c.set(Calendar.MONTH,mes-1);
        c.set(Calendar.YEAR,ano);
        return c.getTime();
    }
}
