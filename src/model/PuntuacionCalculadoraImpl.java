package model;

import model.calculadoras.Calcular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuntuacionCalculadoraImpl implements PuntuacionCalculadora{

    private List<Calcular> calculadoras;

    public PuntuacionCalculadoraImpl(Calcular... calculadoras) {
        this.calculadoras = new ArrayList<>();
        this.calculadoras.addAll(Arrays.asList(calculadoras));

    }

    @Override
    public int calcularPuntuacion(String password) {
        int puntuacion = 0;

        for(Calcular c:calculadoras){
            puntuacion += c.calcular(password);
        }

        puntuacion = puntuacionExtra(puntuacion);

        return puntuacion;
    }

    private int puntuacionExtra(int puntuacion) {
        if (puntuacion == 9) {
            puntuacion++;
        }
        return puntuacion;
    }
}
