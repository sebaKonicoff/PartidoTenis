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

    public int getGameGanadoJ1() {
        return gameGanadoJ1;
    }

    public void setGameGanadoJ1(int gameGanadoJ1) {
        this.gameGanadoJ1 = gameGanadoJ1;
    }

    public int getGameGanadoJ2() {
        return gameGanadoJ2;
    }

    public void setGameGanadoJ2(int gameGanadoJ2) {
        this.gameGanadoJ2 = gameGanadoJ2;
    }

    public int seJuegaSet(String nom_j1, String nom_j2){
        int setGanado = 0;
        System.out.println("Comienzo del set.");
        System.out.println("========================================");
        do {
            System.out.println("Games:");
            System.out.println(nom_j1+": "+ gameGanadoJ1);
            System.out.println(nom_j2+": "+ gameGanadoJ2);
            if(game.seJuegaGame(nom_j1, nom_j2) == 1){
                gameGanadoJ1 += 1;
                //System.out.println("Game para " + nom_j1);
            }
            else {
                gameGanadoJ2 += 1;
                //System.out.println("Game para " + nom_j2);
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
                System.out.println("Comienzo de Tie-Break");
                int tieBreakGanado = game.seJuegaTieBreak(nom_j1, nom_j2);
                if (tieBreakGanado == 1){
                    gameGanadoJ1 += 1;
                    setGanado = 1;
                }
                else {
                    gameGanadoJ2 += 1;
                    setGanado = 2;
                }
            }

        }while (!((setGanado == 1 || setGanado == 2)));
        return setGanado;
    }
}
