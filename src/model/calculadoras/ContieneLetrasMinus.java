package model.calculadoras;

public class ContieneLetrasMinus implements Calcular{

    public int calcular(String password){
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return 1;
            }
        }
        return 0;
    }
}
