import java.util.ArrayList;

public abstract class Vozilo extends Thread
{
    volatile boolean paoPolicijski=false;
    volatile boolean paoCarinski=false;
    private Vozac vozac;
    private static int globalniBrojac=0;
    private  int broj;
    private ArrayList<Putnik> putnici;
    public Vozilo(int brojPutnika)
    {
        globalniBrojac++;
        broj=globalniBrojac;
        System.out.println("Vozilo"+broj);
        putnici=new ArrayList<Putnik>();
        vozac=new Vozac();
        for(int i=0; i<brojPutnika-1;i++)
        {
            putnici.add(new Putnik());
        }
    }
    public boolean jePaoCarinski() {
        return paoCarinski;
    }

    public void setPaoCarinski(boolean a) {
        this.paoCarinski = a;
    }
    public boolean jePaoPolicijski() {
        return paoPolicijski;
    }
    public void setPaoPolicijski(boolean b) {
        this.paoPolicijski = b;
    }
    public void dodajPutnikaUVozilo(Putnik putnik) {
        putnici.add(putnik);
    }
    public void ukloniPutnikaIzVozila(Putnik putnik) {
        putnici.remove(putnik);
    }
    public ArrayList<Putnik> getPutnici()
    {
        return putnici;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }
    @Override
    public String toString()
    {
        return "Vozilo"+broj;
    }

    public int getBrojPutnika()
    {
        return putnici.size();
    }

}

