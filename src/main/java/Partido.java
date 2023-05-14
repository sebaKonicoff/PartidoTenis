import java.util.Random;

public class Partido {
    private String nombre_jugador1;
    private String nombre_jugador2;
    private double prob_jugador1;
    private int best_of;

    public Partido(){

    }

    public Partido(String nombre_jugador1, String nombre_jugador2, double prob_jugador1, int best_of) {
        this.nombre_jugador1 = nombre_jugador1;
        this.nombre_jugador2 = nombre_jugador2;
        this.prob_jugador1 = prob_jugador1;
        this.best_of = best_of;
    }

    public String getNombre_jugador1() {
        return nombre_jugador1;
    }

    public void setNombre_jugador1(String nombre_jugador1) {
        this.nombre_jugador1 = nombre_jugador1;
    }

    public String getNombre_jugador2() {
        return nombre_jugador2;
    }

    public void setNombre_jugador2(String nombre_jugador2) {
        this.nombre_jugador2 = nombre_jugador2;
    }

    public double getProb_jugador1() {
        return prob_jugador1;
    }

    public void setProb_jugador1(double prob_jugador1) {
        this.prob_jugador1 = prob_jugador1;
    }

    public int getBest_of() {
        return best_of;
    }

    public void setBest_of(int best_of) {
        this.best_of = best_of;
    }

}
