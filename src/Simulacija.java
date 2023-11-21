import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.Iterator;

public class Simulacija {
    public static ArrayBlockingQueue<Vozilo> granicniRed=new ArrayBlockingQueue<>(25);
    public static ArrayBlockingQueue<Vozilo> carinskiRed=new ArrayBlockingQueue<>(2);
    final static int BROJ_AUTOBUSA=5;
    final static int  BROJ_AUTA=10;
    final static int BROJ_KAMIONA=10;
    public static Handler handler;
    {
        try {
            // ime logger-a je naziv klase
            handler = new FileHandler("Dejo.log");
            Logger.getLogger(Simulacija.class.getName()).addHandler(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static CarinskiTerminal carinskiTerminalZaKamione=new CarinskiTerminal();
    public static CarinskiTerminal carinskiTerminal=new CarinskiTerminal();

    public static PolicijskiTerminal policijskiTerminalZaKamione=new PolicijskiTerminal();
    public static PolicijskiTerminal policijskiTerminal1=new PolicijskiTerminal();
    public static PolicijskiTerminal policijskiTerminal2=new PolicijskiTerminal();

    public static void main(String[] args) {
        for (int i = 0; i < BROJ_KAMIONA; i++) {
            granicniRed.add(new Kamion());
        }

        for(int i=0; i<BROJ_AUTA; i++)
        {
            granicniRed.add(new Automobil());
        }
        for(int i=0; i<BROJ_AUTOBUSA; i++)
        {
            granicniRed.add(new Autobus());
        }
        for (Vozilo vozilo :
                granicniRed) {
            vozilo.start();
        }
    }
}