package sk.stuba.fei.uim.oop.karty;

public class Kacka extends Policko {
    private final String meno;
    private final int hracove_id;

    public String getMeno() {
        return meno;
    }

    public int getHracove_id() {
        return hracove_id;
    }

    public Kacka(String meno, int hracove_id) {
        this.meno = "Kacka hraca " + meno;
        this.hracove_id = hracove_id;
    }

    @Override
    public String vykresli() {
        return this.meno;
    }
}
