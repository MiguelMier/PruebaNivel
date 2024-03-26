package model.validador;

public class ContieneLetrasMayusYMinus implements Validador {
    @Override
    public int calcular(String password) {
        ContieneLetrasMayus letrasMayus = new ContieneLetrasMayus();
        ContieneLetrasMinus letrasMinus = new ContieneLetrasMinus();

        if(letrasMinus.calcular(password) == 1 && letrasMayus.calcular(password) == 1){
            return 2;
        } else if (letrasMinus.calcular(password) == 1 || letrasMayus.calcular(password) == 1) {
            return 1;
        }
        return 0;
    }
}
