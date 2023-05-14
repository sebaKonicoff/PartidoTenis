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
            System.out.println("Ingrese la probabilidad que tiene para ganar el partido el jugador " + jugador1 + "(del 1 al 100):");
            sprobJugador = sc.nextLine();
        }while (!esNumerico(sprobJugador));
        double probJugador1 = (Double.parseDouble(sprobJugador)) / 100;
        int bo;
        do {
            System.out.print("Sets al mejor de (3 o 5): ");
            bo = sc.nextInt();
        }while (!((bo == 3) || (bo == 5)));
        System.out.println("Probabilidad jugador 1: " + probJugador1);


        /*
        Game game = new Game(0,0,1);
        int gameGanado = game.seJuegaGame(jugador1, jugador2,probJugador1);
        if (gameGanado == 1){
            System.out.println("Gano jugador1");
        }
        else {
            System.out.println("Gano jugador2");
        }*/
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
