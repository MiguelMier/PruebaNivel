package model.validador;

public class ContieneNumeros implements Validador {

    public int calcular(String password){
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return 1;
            }
        }
        return 0;
    }
}
