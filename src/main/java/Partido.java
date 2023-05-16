import java.util.Random;

public class Partido {
    private String nombre_jugador1;
    private String nombre_jugador2;
    private double prob_jugador1;
    private double best_of;
    private Set set;

    private int setGanadoJ1;
    private int setGanadoJ2;
    private int gamesGanadosJ1[];
    private int gamesGanadosJ2[];
    private double cantidadSetParaGanar;

    public Partido(){

    }

    public Partido(String nombre_jugador1, String nombre_jugador2, double prob_jugador1, double best_of, Set set) {
        this.nombre_jugador1 = nombre_jugador1;
        this.nombre_jugador2 = nombre_jugador2;
        this.prob_jugador1 = prob_jugador1;
        this.best_of = best_of;
        this.set = set;
    }

    public int[] getGamesGanadosJ1() {
        return gamesGanadosJ1;
    }

    public int[] getGamesGanadosJ2() {
        return gamesGanadosJ2;
    }

    public double getCantidadSetParaGanar() {
        return cantidadSetParaGanar;
    }

    public int seJuegaPartido(){
        int partidoGanado = 0;
        cantidadSetParaGanar =(best_of /2 )+0.5;
        gamesGanadosJ1 = new int[(int)best_of];
        gamesGanadosJ2 = new int[(int)best_of];
        System.out.println("Canitdad de set para ganar: " + cantidadSetParaGanar);
        System.out.println("Comienzo del partido.");
        for (int i = 0; i <= best_of; i++){
            System.out.println("=========================");
            if (set.seJuegaSet(nombre_jugador1, nombre_jugador2) == 1){
                setGanadoJ1 += 1;
            }
            else { setGanadoJ2 += 1; }
            gamesGanadosJ1[i] = set.getGameGanadoJ1();
            gamesGanadosJ2[i] = set.getGameGanadoJ2();
            System.out.println(nombre_jugador1 + ": " + gamesGanadosJ1[i]);
            System.out.println(nombre_jugador2 + ": " + gamesGanadosJ2[i]);
            if (partidoGanado == 0){
                set.setGameGanadoJ1(0);
                set.setGameGanadoJ2(0);
            }
            if (setGanadoJ1 == cantidadSetParaGanar){
                partidoGanado = 1;
                break;
            }
            else if (setGanadoJ2 == cantidadSetParaGanar) {
                partidoGanado = 2;
                break;
            }

        }
        return partidoGanado;
    }

}
