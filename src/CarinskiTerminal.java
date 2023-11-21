import java.util.logging.Level;
import java.util.logging.Logger;

public class CarinskiTerminal extends Terminal{
    @Override
    public void obradaVozila(Vozilo vozilo)
    {
        if(vozilo instanceof AutomobilInterface)
        {
            try
            {
                Thread.sleep(2000);
            }catch(InterruptedException e)
            {
                Logger.getLogger(Simulacija.class.getName()).log(Level.WARNING, e.fillInStackTrace().toString());
            }
            System.out.println("Auto "+vozilo+" proslo carinsku");
            vozilo.setPaoCarinski(false);
        }
        else if(vozilo instanceof AutobusInterface)
        {
            if(vozilo.getPutnici().size()!=0)
            {
                for (int i = 0; i < vozilo.getPutnici().size(); i++)
                {
                    try
                    {
                        Thread.sleep(100);
                    }catch(InterruptedException e)
                    {
                        Logger.getLogger(Simulacija.class.getName()).log(Level.WARNING, e.fillInStackTrace().toString());
                    }
                    if (vozilo.getPutnici().get(i).ImaLiKofer())
                    {
                        if (vozilo.getPutnici().get(i).getKofer().ImaLiNedozvoljeneStvari())
                        {
                            System.out.println("Putnik "+vozilo.getPutnici().get(i)+" ima nedozvoljene stvari u koferu. Ne moze preci granicu");
                            System.out.println("Uklanjanje "+vozilo.getPutnici().get(i)+" iz autobusa.");
                            vozilo.ukloniPutnikaIzVozila(vozilo.getPutnici().get(i));
                        }
                        else
                        {
                            System.out.println("Putnik " + vozilo.getPutnici().get(i) + " presao carinsku");
                        }
                    }
                }
            }
            else
            {
                System.out.println("Autobus je prazan. Prolazi carinsku kontrolu odmah.");
                vozilo.setPaoCarinski(false);
            }
        }
        else if (vozilo instanceof KamionInterface)
        {
            try
            {
                Thread.sleep(500);
            }catch(InterruptedException e)
            {
                Logger.getLogger(Simulacija.class.getName()).log(Level.WARNING, e.fillInStackTrace().toString());
            }
            Kamion kamion=(Kamion)vozilo;
            if(kamion.daLiJePotrebnaCarinskaDokumentacija())
            {
                if(kamion.daLiKamionImaVeciTeret())
                {
                    System.out.println("Kamion "+kamion+" ne moze da predje carinsku kontrolu jer je preopterecen.");
                    kamion.setPaoCarinski(true);
                }
                else
                {
                    System.out.println("Kamion "+kamion+" ima dozvoljen teret. Moze da predje carinsku.");
                }
            }
            else
            {
                System.out.println("Kamionu "+kamion+" nije  potrebna carinska dokumentacija. Prolazi carinsku kontrolu.");
            }
        }
    }
}
