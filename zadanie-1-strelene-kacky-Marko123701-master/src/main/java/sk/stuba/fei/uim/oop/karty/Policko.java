package sk.stuba.fei.uim.oop.karty;

public abstract class Policko {
    private int hracove_id;

    protected Policko() {
    }

    public abstract String vykresli();

    public int getHracove_id(){
        return hracove_id;
    }
}
