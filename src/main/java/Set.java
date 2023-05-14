import java.util.List;

public class Set {
    private int gameGanadoJ1;
    private int gameGanadoJ2;
    private Game game;

    public Set(Game game) {
        this.gameGanadoJ1 = 0;
        this.gameGanadoJ2 = 0;
        this.game = game;
    }

    public int seJuegaSet(String nom_j1, String nom_j2, double prob_j1, double bo){
        int setGanado = 0;
        System.out.println("Comienzo del set.");
        System.out.println("========================================");
        do {
            if(game.seJuegaGame(nom_j1, nom_j2) == 1){
                gameGanadoJ1 += 1;
                System.out.println("Game para " + nom_j1);
            }
            else {
                gameGanadoJ2 += 1;
                System.out.println("Game para " + nom_j2);
            }

            if ((gameGanadoJ1 == 6 && gameGanadoJ2 <=4) || (gameGanadoJ1 == 7 && gameGanadoJ2 == 5)){
                System.out.println("Set para " + nom_j1);
                setGanado = 1;
            }
            else if ((gameGanadoJ2 == 6 && gameGanadoJ1 <=4) || (gameGanadoJ2 == 7 && gameGanadoJ1 == 5)){
                System.out.println("Set para " + nom_j2);
                setGanado = 2;
            }
            else if (gameGanadoJ1 == 6 && gameGanadoJ2 == 6){
                game.seJuegaTieBreak(nom_j1, nom_j2);
            }

        }while (!((setGanado == 1 || setGanado == 2)));
        return -1;
    }
}
