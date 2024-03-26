package model.calculadoras;

public class ContieneNumeros implements Calcular{

    public int calcular(String password){
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return 1;
            }
        }
        return 0;
    }
}
