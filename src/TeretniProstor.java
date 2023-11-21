import java.util.ArrayList;

public class TeretniProstor {
    private ArrayList<Kofer> koferi;
    public TeretniProstor()
    {
        koferi=new ArrayList<Kofer>();
    }
    public void dodajKoferUTeretniProstor(Kofer kofer)
    {
        koferi.add(kofer);
    }
}
