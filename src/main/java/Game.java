import java.util.Random;

public class Game {
    private int puntoGanadoJ1;
    private int puntoGanadoJ2;
    private int saca;
    private double prob_j1;

    Random rm = new Random();
    String puntos[] = {"0", "15", "30", "40", "Ventaja"};

    public Game(int saca, double prob_j1) {
        this.puntoGanadoJ1 = 0;
        this.puntoGanadoJ2 = 0;
        this.saca = saca;
        this.prob_j1 = prob_j1;
    }

    public int seJuegaGame(String nom_j1, String nom_j2){
        int gameGanado = 0; // =1 game ganado para jugador 1. =2 game ganado para jugador2
        System.out.println();
        do{
            seJuegaPunto(nom_j1, nom_j2, false);

            if ((puntoGanadoJ1 == 4 && puntoGanadoJ2 <=2) || (puntoGanadoJ1 == 5)){
                System.out.println("Game para " + nom_j1);
                gameGanado = 1; //game ganado por el jugador 1
            }
            else if ((puntoGanadoJ2 == 4 && puntoGanadoJ1 <=2) || (puntoGanadoJ2 == 5)){
                System.out.println("Game para " + nom_j2);
                gameGanado = 2; // game ganado por el jugador 2
            }

            else if (puntoGanadoJ1 == 4 && puntoGanadoJ2 == 4){
                puntoGanadoJ1 -= 1;
                puntoGanadoJ2 -=1;
            }
        }while (!((gameGanado == 1 || gameGanado == 2)));
        if (saca == 1){ saca = 2; }
        else { saca = 1;}
        puntoGanadoJ1 = 0;
        puntoGanadoJ2 = 0;
        return gameGanado;
    }
    //{"0", "15", "30", "40", "Ventaja"}
    public int seJuegaTieBreak(String nom_j1, String nom_j2){
        int tieBreak = 0;
        System.out.println("Comienzo del Tie-Break");
        if (saca == 1){ saca = 2; }
        else { saca = 1;} //para hacer que en el tiebreak empiece sacando el que sacó ese game
        do {
            seJuegaPunto(nom_j1, nom_j2, true);

            if (puntoGanadoJ1 == 7 && puntoGanadoJ2 <= 5){
                System.out.println("Tie-Break para " + nom_j1);
                tieBreak = 1;
            }
            else if (puntoGanadoJ2 == 7 && puntoGanadoJ1 <= 5){
                System.out.println("Tie-Break para " + nom_j2);
                tieBreak = 2;
            }
            else if (puntoGanadoJ1 == 6 && puntoGanadoJ2 == 6){
                diferenciaTieBreak(nom_j1, nom_j2);
                if(puntoGanadoJ1 > puntoGanadoJ2) {tieBreak = 1;}
                else tieBreak = 2;
            }
        }while (!((tieBreak == 1 || tieBreak == 2)));
        puntoGanadoJ1 = 0;
        puntoGanadoJ2 = 0;
        return tieBreak;
    }

    public void diferenciaTieBreak(String nom_j1, String nom_j2){
        do {
            if(puntoGanado() == 1){
                puntoGanadoJ1 += 1;
                System.out.println("Punto para " + nom_j1);
            }
            else {
                puntoGanadoJ2 += 1;
                System.out.println("Punto para " + nom_j2);
            }
            System.out.println(nom_j1+": "+ puntoGanadoJ1);
            System.out.println(nom_j2+": "+ puntoGanadoJ2);
        }while (!((puntoGanadoJ1 - puntoGanadoJ2) == 2) || (puntoGanadoJ2 - puntoGanadoJ1) == 2);
    }

     public void seJuegaPunto(String nom_j1, String nom_j2, boolean tieBreak){
         if (saca == 1){
             System.out.println("Saca jugador " + nom_j1);
         }
         else {
             System.out.println("Saca jugador " +nom_j2);
         }
         if (tieBreak){
             System.out.println(nom_j1+": "+ puntoGanadoJ1);
             System.out.println(nom_j2+": "+ puntoGanadoJ2);
         }
         else {
             System.out.println(nom_j1+": "+ puntos[puntoGanadoJ1]);
             System.out.println(nom_j2+": "+ puntos[puntoGanadoJ2]);
         }
         if (puntoGanado() == 1){
             puntoGanadoJ1 += 1;
             System.out.println("Punto para " + nom_j1);
         }
         else {
             puntoGanadoJ2 += 1;
             System.out.println("Punto para " + nom_j2);
         }
         System.out.println("======================================");
     }

    public int puntoGanado(){
        double punto = rm.nextDouble();
        if (punto <= prob_j1){ return 1; }
        else { return 2; }
    }
}
