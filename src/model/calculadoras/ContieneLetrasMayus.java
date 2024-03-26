package model.calculadoras;

public class ContieneLetrasMayus implements Calcular{

    public int calcular(String password){
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return 1;
            }
        }
        return 0;
    }
}
