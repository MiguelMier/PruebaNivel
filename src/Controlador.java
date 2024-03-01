import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Controlador {

    private int puntuacion;
    private String contrasena;
    private Boolean mayusminus;

    public Controlador(){
        this.puntuacion = 0;
        this.mayusminus = false;
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
        calculaLongitud();
        numeros();
        letrasMinusMayus();
        calculaUsoEspeciales();
        puntoExtra();
    }

    private void calculaLongitud(){
        int longitud = contrasena.length();

        if(longitud == 7 || longitud == 8){
            puntuacion++;
        } else if (longitud >= 9 && longitud <= 12) {
            puntuacion += 2;
        } else if (longitud > 12) {
            puntuacion += 3;
        }
    }

    private void numeros(){
        boolean tempNum = false;
         for (int i = 0; i < contrasena.length(); i++){
            if (contrasena.substring(i).matches("[0-9]")) {
                tempNum = true;
            }
        }
        if(tempNum){
            puntuacion++;
        }

    }

    private void letrasMinusMayus(){
        boolean tempLetra = false;
        boolean tempMayus = false;
        for (int i = 0; i < contrasena.length(); i++){
            if(contrasena.substring(i).matches("[a-z]")){
                tempLetra = true;
            } else if (contrasena.substring(i).matches("[A-Z]")) {
                tempMayus = true;
            }
        }
        if(tempLetra || tempMayus){
            puntuacion++;
        }
        if(tempLetra && tempMayus){
            puntuacion += 2;
        }

    }

    private void calculaUsoEspeciales(){
        if(!contrasena.matches("^[a-zA-Z0-9]*$")){
            puntuacion += 2;
        }
    }

    private void puntoExtra(){
        if(puntuacion == 9){
            puntuacion++;
        }
    }

    private void permitirAcceso(){
        if(puntuacion >= 8){
            System.out.println("Acceso permitido");
            System.out.println("Su puntuación de contraseña es: " + puntuacion);
        }
        else {
            System.out.println("Acceso denegado");
            System.out.println("Su puntuación de contraseña es: " + puntuacion);
        }
    }
}
