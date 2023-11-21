public abstract class Terminal {
    protected volatile boolean slobodan=true;
    public abstract void obradaVozila(Vozilo vozilo);
    public boolean jeSlobodan() {
        return slobodan;
    }
    public synchronized void setSlobodan(boolean slobodan) {
        this.slobodan = slobodan;
    }
}
