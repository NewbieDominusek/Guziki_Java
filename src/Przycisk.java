import javax.swing.*;

abstract class Przycisk extends JButton {
    private final Integer index; //unikatowy numer przycisku
    public Przycisk(Integer nrNaLiscie){
        index = nrNaLiscie;
    }

    public Integer getIndex(){
        return index; //zwróć numer przycisku
    }

    public void removeYourselfNOW(){
        Main.usunPrzycisk(index);
    }
    abstract void akcja();

    abstract void setBG();//zmień kolor przycisku
}
