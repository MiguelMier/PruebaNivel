package model.validador;

public class ContieneCaracterEspecial implements Validador {

    public int calcular(String password){
        if(!password.matches("^[a-zA-Z0-9]*$")){
            return 2;
        }
        return 0;
    }
}
