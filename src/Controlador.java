import model.PuntuacionCalculadoraImpl;
import model.validador.*;

import java.util.Scanner;

public class Controlador {

    private int puntuacion;
    private String contrasena;

    public Controlador(){
        this.puntuacion = 0;
    }

    public void start(){
        leerContrasena();
        calcularPuntuacion();
        permitirAcceso();
    }


    private void leerContrasena(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Intrioduzca su nombre:");
        String nombre = teclado.nextLine();
        System.out.println("Intrioduzca su contraseña " + nombre + ":");
        contrasena = teclado.nextLine();
        contrasena = contrasena.replace(" ","");

    }

    private void calcularPuntuacion(){
        PuntuacionCalculadoraImpl calculadora = new PuntuacionCalculadoraImpl(new CalculadoraLongitud(),
                new ContieneCaracterEspecial(), new ContieneNumeros(), new ContieneLetrasMayusYMinus());
        this.puntuacion = calculadora.calcularPuntuacion(contrasena);
    }

    private void permitirAcceso() {
        if (puntuacion >= 8) {
            System.out.println("Acceso permitido");
            System.out.println("Su puntuación de contraseña es: " + puntuacion);
        } else {
            System.out.println("Acceso denegado");
            System.out.println("Su puntuación de contraseña es: " + puntuacion);
        }
    }

}
