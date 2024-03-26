package model.calculadoras;

public class ContieneCaracterEspecial implements Calcular{

    public int calcular(String password){
        if(!password.matches("^[a-zA-Z0-9]*$")){
            return 2;
        }
        return 0;
    }
}
