import java.util.Random;

public class Game {
    private int puntoGanadoJ1;
    private int puntoGanadoJ2;
    private int saca;

    int diferenciaPuntos = 2;
    String puntos[] = {"0", "15", "30", "40", "Ventaja"};

    public Game(int saca) {
        this.puntoGanadoJ1 = 0;
        this.puntoGanadoJ2 = 0;
        this.saca = saca;
    }

    public int getPuntoGanadoJ1() {
        return puntoGanadoJ1;
    }

    public int getPuntoGanadoJ2() {
        return puntoGanadoJ2;
    }

    public int getSaca() {
        return saca;
    }

    public void setSaca(int saca) {
        this.saca = saca;
    }

    public int seJuegaGame(String nom_j1, String nom_j2, double prob_j1){
        int gameGanado = 0; // =1 game ganado para jugador 1. =2 game ganado para jugador2
        System.out.println();
        do{
            if (saca == 1){
                System.out.println("Saca jugador " + nom_j1);
            }
            else {
                System.out.println("Saca jugador " +nom_j2);
            }
            System.out.println(nom_j1+": "+ puntos[puntoGanadoJ1]);
            System.out.println(nom_j2+": "+ puntos[puntoGanadoJ2]);
            if (seJuegaPunto(prob_j1) == 1){
                puntoGanadoJ1 += 1;
                System.out.println("Punto para " + nom_j1);
            }
            else {
                puntoGanadoJ2 += 1;
                System.out.println("Punto para " + nom_j2);
            }
            System.out.println("======================================");
            if (puntoGanadoJ1 == 4 && puntoGanadoJ2 <=2){
                System.out.println("Game para " + nom_j1);
                gameGanado = 1; //game ganado por el jugador 1
            }
            else if (puntoGanadoJ2 == 4 && puntoGanadoJ1 <=2){
                System.out.println("Game para " + nom_j2);
                gameGanado = 2; // game ganado por el jugador 2
            }
            else if (puntoGanadoJ1 == 4 && puntoGanadoJ2 == 3){
                puntoGanadoJ1 -= 1;
            }
            else if (puntoGanadoJ2 == 4 && puntoGanadoJ1 == 3){
                puntoGanadoJ1 -= 1;
            }
        }while (!((gameGanado == 1 || gameGanado == 2)));
        if (saca == 1){ saca = 2; }
        else { saca = 1;}
        return gameGanado;
    }

    public int seJuegaPunto(double prob_jugador1){
        Random rm = new Random();
        double punto = rm.nextDouble();
        if (punto <= prob_jugador1){ return 1; }
        else { return 2; }
    }
}
