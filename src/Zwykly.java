public class Zwykly extends Przycisk{
    public Zwykly(Integer nrNaLiscie){
        super(nrNaLiscie);
        setText("Zwykły");
        setBG();
    }
    public void akcja(){
        Main.dodajPrzycisk();
    }

    public void setBG(){
        setBackground(Narzedzia.Kolor.returnLosKol(0));
    }
}
