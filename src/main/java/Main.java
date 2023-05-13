import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre del torneo: ");
        String nombreTorneo = sc.nextLine();
        System.out.println("Ingrese nombre del primer Jugador: ");
        String jugador1 = sc.nextLine();
        System.out.println("Ingrese nombre del segundo Jugador: ");
        String jugador2 = sc.nextLine();
        String sprobJugador;
        do {
            System.out.println("Ingrese la probabilidad que tiene para ganar el partido el jugador " + jugador1 +"(del 1 al 100):");
            sprobJugador = sc.nextLine();
        }while (!esNumerico(sprobJugador));
        int probJugador1 = Integer.parseInt(sprobJugador);

    }



    public static boolean esNumerico(String cadena){
        int v;
        boolean flag = false;
        try {
            v=Integer.parseInt(cadena);
            if (v >= 1 && v <= 100){
                flag = true;
            }
            return flag;
        } catch (NumberFormatException ex) {
            return flag;
        }
    }

}
