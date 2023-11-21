import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PolicijskiTerminal extends Terminal
{
    @Override
    public void obradaVozila(Vozilo vozilo)
    {
        int vrijemeObradePutnika;
        if(vozilo instanceof KamionInterface || vozilo instanceof AutomobilInterface)
        {
            vrijemeObradePutnika=500;
        }
        else
        {
            vrijemeObradePutnika=100;
        }
        try {
            Thread.sleep(vrijemeObradePutnika);
        } catch (InterruptedException e) {
            Logger.getLogger(Simulacija.class.getName()).log(Level.WARNING, e.fillInStackTrace().toString());
        }
        if(vozilo.getVozac().getIdentifikacioniDokument().jeIspravan())
        {
            System.out.println(vozilo+" moze uspješno da prođe policijski terminal, id vozaca ispravan.");
        }
        else
        {
            System.out.println(vozilo+" ne moze preci granicu zbog neispravnosti dokumenta vozaca "+vozilo.getVozac());
            vozilo.setPaoPolicijski(true);
            return;
        }
        Iterator<Putnik> iterator=vozilo.getPutnici().iterator();
        while(iterator.hasNext()) {
            try {
                Thread.sleep(vrijemeObradePutnika);
            } catch (InterruptedException e) {
                Logger.getLogger(Simulacija.class.getName()).log(Level.WARNING, e.fillInStackTrace().toString());
            }
            Putnik putnik=iterator.next();
            if (!putnik.getIdentifikacioniDokument().jeIspravan()) {
                System.out.println("Putnik " + putnik.getIdentifikacioniDokument() + " ne moze preci granicu zbog neispravnosti identifikacionog dokumenta. Izbacuje se iz vozila.");
                iterator.remove();
            } else {
                System.out.println("Putnik " + putnik.getIdentifikacioniDokument() + " prosao policijsku provjeru.");
            }
        }

    }
}
