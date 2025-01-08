import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class Main {
    static HashMap<Integer, Przycisk> elementy = new HashMap<Integer, Przycisk>(); //Tablica HashMap przycisków
    static int nrPrzycisku = 0; //licznik dodanych przycisków. Zwiększany po dodaniu każdego nowego przycisku. Każdy przycisk dostaje unikalny numerek
    static Ramka ramka = new Ramka();
    static JPanel panel = new JPanel(new GridLayout(10, 10)); //Kontener 10x10


    public static void dodajPrzycisk(){
        if (elementy.size() >= 100) return; //sprawdź limit przycisków (100 max)

        Narzedzia.typPrzycisku wylosowanyTyp = Narzedzia.losujTyp();
        Przycisk handle = switch (wylosowanyTyp) {
            case KABOOM -> new Kaboom(nrPrzycisku++);
            case GOLD -> new Gold(nrPrzycisku++);
            default -> new Zwykly(nrPrzycisku++);
        };
        elementy.put(handle.getIndex(), handle); //wstaw przycisk do tablicy HashMap z etykietą index
        
        //Naciśnięcie przycisku lewym przyciskiem myszy doda nowy przycisk
        handle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Przycisk uchwyt = (Przycisk) actionEvent.getSource();
                uchwyt.akcja();
            }
        });

        //Naciśnięcie przycisku prawym/środkowym przyciskiem myszy usunie naciśnięty przycisk/zmieni jego kolor
        handle.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent event){
                Przycisk uchwyt = (Przycisk) event.getSource();
                if (event.getButton() == MouseEvent.BUTTON3){ //prawy przycisk usuwa
                    uchwyt.removeYourselfNOW(); //każ przyciskowi się usunąć
                } else if (event.getButton() == MouseEvent.BUTTON2) {//środkowy zmienia kolor
                    uchwyt.setBG();
                }
            }
        });
        //handle.setActionCommand(String.valueOf(handle.getIndex()));
        panel.add(handle);
        panel.revalidate();
        panel.repaint();
    }

    public static void usunPrzycisk(Integer numer){
        panel.remove(elementy.get(numer));
        elementy.remove(numer);
        panel.revalidate();
        panel.repaint();
        if (elementy.isEmpty()){
            koncowyPopup();
        }
    }

    public static void usunPrzycisk(Przycisk usuwany){
        panel.remove(usuwany);
        panel.revalidate();
        panel.repaint();
        if (elementy.isEmpty()){
            koncowyPopup();
        }
    }

    public static void koncowyPopup(){
        Object[] opcje = {"Zakończ program", "Nowy guzik"};
        int wybor = JOptionPane.showOptionDialog(ramka, "Skończyły się guziki :(", "Ojojoj", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, opcje, opcje[0]);
        if(wybor == JOptionPane.YES_OPTION)System.exit(0);
        else dodajPrzycisk();
    }

    public static void createGUI(){
        ramka.add(panel);
        dodajPrzycisk();
        ramka.pack();
        ramka.setSize(600, 600);
        
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
