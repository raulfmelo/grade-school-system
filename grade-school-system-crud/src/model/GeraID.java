package model;

public class GeraID {
    private static int idAluno = 1;

    public static int geraIDAluno(){
        return idAluno++;
    }
}
