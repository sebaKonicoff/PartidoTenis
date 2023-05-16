import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class partidoTenisTest {
    public static String nomTorneo;
    public static String nombJ1;
    public static String nombJ2;
    public static double probJ1;
    public static int saca;

    @Before
    public void inicializarDatos(){
        nomTorneo = "Arg Open";
        nombJ1 = "Coria";
        nombJ2 = "Del Potro";
        probJ1 = 0.8;
        saca = 1;
    }

    @Test //description="Validar que se simule correctamente un partido de tenes al mejor de 3 set"
    public void ingresoA3Set(){
        int resultSetGanadoJ1[];
        Game game = new Game(saca,probJ1);
        Set set = new Set(game);
        Partido partido = new Partido(nombJ1, nombJ2,probJ1, 3, set);
        int ganador = partido.seJuegaPartido();
        resultSetGanadoJ1 = partido.getGamesGanadosJ1();
        assert resultSetGanadoJ1.length == 3;

    }

    @Test //description="Validar que se simule correctamente un partido de tenes al mejor de 3 set"
    public void ingresoA5Set(){
        int resultSetGanadoJ1[];
        Game game = new Game(saca,probJ1);
        Set set = new Set(game);
        Partido partido = new Partido(nombJ1, nombJ2,probJ1, 5, set);
        int ganador = partido.seJuegaPartido();
        resultSetGanadoJ1 = partido.getGamesGanadosJ1();
        assert resultSetGanadoJ1.length == 5;

    }

    @Test
    public void ingresoSetIncorrecto() throws Exception{
        int resultSetGanadoJ1[];
        Game game = new Game(saca,probJ1);
        Set set = new Set(game);
        Partido partido = new Partido(nombJ1, nombJ2,probJ1, 7, set);
        int ganador = partido.seJuegaPartido();
        resultSetGanadoJ1 = partido.getGamesGanadosJ1();
        assert resultSetGanadoJ1.length != 3;
        assert resultSetGanadoJ1.length != 5;
    }


}
