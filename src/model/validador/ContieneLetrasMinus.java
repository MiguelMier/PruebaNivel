package model.validador;

public class ContieneLetrasMinus implements Validador {

    public int calcular(String password){
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return 1;
            }
        }
        return 0;
    }
}
