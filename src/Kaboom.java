import java.util.Iterator;

public class Kaboom extends Przycisk{
    public Kaboom(Integer nrNaLiscie){
        super(nrNaLiscie);
        setText("Kaboom");
        setBG();
    }

    public void setBG(){
        setBackground(Narzedzia.Kolor.returnLosKol(1));
    }

    public void akcja(){
        Iterator<Integer> iter = Main.elementy.keySet().iterator();

        while(iter.hasNext()){
            Integer klucz = iter.next();
            if((int)(Math.random()*1000) % 10 <= 4){ // 40% na usunięcie
                System.out.println("Usunięty!");
                Main.usunPrzycisk(Main.elementy.get(klucz));
                iter.remove();
            }
        }
        try{
            removeYourselfNOW();
        }
        catch (Exception e){
            System.out.println("czerwony guzik został już usunięty :P");
        }
    }
}
