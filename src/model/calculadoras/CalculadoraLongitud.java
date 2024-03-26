package model.calculadoras;

public class CalculadoraLongitud implements Calcular{

    public int calcular(String password){
        int longitud = password.length();
        if (longitud == 7 || longitud == 8) {
            return 1;
        } else if (longitud >= 9 && longitud <= 12) {
            return 2;
        } else if (longitud > 12) {
            return 3;
        }
        return 0;
    }
}
