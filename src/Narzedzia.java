import javax.swing.*;
import java.awt.*;

public class Narzedzia {

    //losuje wartośc (koloru) od 100 do 256

    public static class Kolor{

        public static int losujKolor() {
            return (int) ((Math.random() * 1000) % 156) + 100;
        }

        public static Color returnLosKol(){
            return new Color(Narzedzia.Kolor.losujKolor(), Narzedzia.Kolor.losujKolor(), Narzedzia.Kolor.losujKolor());
        }

        public static Color returnLosKol(int typPrzycisku){
            if (typPrzycisku == 1) return new Color((int) ((Math.random() * 1000) % 106) + 150, 70,50); //czerwony
            else if(typPrzycisku == 2) return new Color(255, 255, 80); //złoty
            int kolor = Narzedzia.Kolor.losujKolor(); // biało-czarny
            return new Color(kolor, kolor, kolor);
        }
    }

    public enum typPrzycisku{
        NORMAL,
        KABOOM,
        GOLD
    }

    public static typPrzycisku losujTyp(){
        int szansa =  (int) (Math.random() * 1000) % 100; // 0 do 99
        if (szansa <= 14) return typPrzycisku.KABOOM; // 15% na kaboom
        else if (szansa <=94) return typPrzycisku.NORMAL; // 80% na zwykly
        return typPrzycisku.GOLD; // 5% na golda
    }
}