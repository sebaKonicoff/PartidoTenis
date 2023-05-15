import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int resultSetGanadoJ1[];
        int resultSetGanadoJ2[];
        String resultJ1 = "";
        String resultJ2 = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre del torneo: ");
        String nombreTorneo = sc.nextLine();
        System.out.println("Ingrese nombre del primer Jugador: ");
        String jugador1 = sc.nextLine();
        System.out.println("Ingrese nombre del segundo Jugador: ");
        String jugador2 = sc.nextLine();
        String sprobJugador;
        do {
            System.out.println("Ingrese la probabilidad que tiene para ganar el partido el jugador " + jugador1 + "(del 1 al 100):");
            sprobJugador = sc.nextLine();
        }while (!esNumerico(sprobJugador));
        double probJugador1 = (Double.parseDouble(sprobJugador)) / 100;
        double bo;
        do {
            System.out.print("Sets al mejor de (3 o 5): ");
            bo = sc.nextInt();
        }while (!((bo == 3) || (bo == 5)));
        System.out.println("Probabilidad jugador 1: " + probJugador1);
        int quienSaca = saca();
        Game game = new Game(quienSaca,probJugador1);
        Set set = new Set(game);
        Partido partido = new Partido(jugador1, jugador2,probJugador1, bo, set);
        int ganador = partido.seJuegaPartido();
        if(ganador ==1){
            System.out.println("Partido finalizado. Ganó " + jugador1 + " el torneo " + nombreTorneo);
        }
        else {
            System.out.println("Partido finalizado. Ganó " + jugador2 + " el torneo " + nombreTorneo);
        }
        resultSetGanadoJ1 = partido.getGamesGanadosJ1();
        resultSetGanadoJ2 = partido.getGamesGanadosJ2();
        for (int i = 0; i < partido.getCantidadSetParaGanar(); i++){
            resultJ1 += Integer.toString(resultSetGanadoJ1[i]) + " ";
            resultJ2 += Integer.toString(resultSetGanadoJ2[i]) + " ";
        }
        System.out.println("Marcador final: ");
        System.out.println(jugador1 + " " + resultJ1);
        System.out.println(jugador2 + " " + resultJ2);
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

    public static int saca(){
        Random rn = new Random();
        double nroAleatorio = rn.nextDouble();
        if (nroAleatorio <= 0.5) { return 1;}
        else return 2;
    }
}
