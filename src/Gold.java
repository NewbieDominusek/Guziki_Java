public class Gold extends Przycisk{
    public Gold(Integer nrNaLiscie){
        super(nrNaLiscie);
        setText("Golden");
        setBG();
    }

    public void setBG(){
        setBackground(Narzedzia.Kolor.returnLosKol(2));
    }

    public void akcja(){
        for (int i = 1; i <= (int)(Math.random()*1000) % 11;i++){
            Main.dodajPrzycisk();
        }
        removeYourselfNOW();
    }
}