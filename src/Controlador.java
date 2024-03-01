import java.util.Scanner;

public class Controlador {

    private int puntuacion;
    private String contrasena;

    public Controlador() {
        this.puntuacion = 0;
    }

    public void comprobarContrasena() {
        leerContrasena();
        calcularPuntuacion();
        permitirAcceso();
    }

    private void leerContrasena() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca su nombre:");
        String nombre = teclado.nextLine();
        System.out.println("Introduzca su contraseña " + nombre + ":");
        contrasena = teclado.nextLine();
        contrasena = contrasena.replace(" ", "");
    }

    private void calcularPuntuacion() {
        calculaLongitud();
        puntuacionNumeros();
        puntuacionLetrasMinusMayus();
        puntuacionEspeciales();
        puntuacionExtra();
    }

    private void calculaLongitud() {
        int longitud = contrasena.length();

        if (longitud == 7 || longitud == 8) {
            puntuacion++;
        } else if (longitud >= 9 && longitud <= 12) {
            puntuacion += 2;
        } else if (longitud > 12) {
            puntuacion += 3;
        }
    }

    private void puntuacionNumeros() {
        boolean hayNumero = false;
        for (int i = 0; i < contrasena.length(); i++) {
            if (contrasena.substring(i).matches("[0-9]")) {
                hayNumero = true;
            }
        }
        if (hayNumero) {
            puntuacion++;
        }
    }

    private void puntuacionLetrasMinusMayus() {
        boolean hayLetraMinuscula = false;
        boolean hayLetraMayuscula = false;

        for (int i = 0; i < contrasena.length(); i++) {
            char caracter = contrasena.charAt(i);
            if (Character.isLowerCase(caracter)) {
                hayLetraMinuscula = true;
            } else if (Character.isUpperCase(caracter)) {
                hayLetraMayuscula = true;
            }
        }

        if (hayLetraMinuscula || hayLetraMayuscula) {
            puntuacion++;
        }

        if (hayLetraMinuscula && hayLetraMayuscula) {
            puntuacion += 2;
        }
    }
    private void puntuacionEspeciales() {
        if (!contrasena.matches("^[a-zA-Z0-9]*$")) {
            puntuacion += 2;
        }
    }

    private void puntuacionExtra() {
        if (puntuacion == 9) {
            puntuacion++;
        }
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
