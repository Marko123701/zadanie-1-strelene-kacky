package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.karty.akcneKarty.AkcnaKarta;
import java.util.ArrayList;

public class Hrac {
    private final String meno;
    private int zivoty;
    private boolean jeNazive;
    private ArrayList<AkcnaKarta> mojeKarty;

    public Hrac(String meno) {
        this.meno = meno;
        this.zivoty=5;
        this.jeNazive=true;

    }

    public String getMeno() {
        return this.meno;
    }

    public void minusZivot(){
        this.zivoty--;
        if(this.zivoty==0)this.jeNazive = false;
    }

    public boolean isJeNazive() {
        return this.jeNazive;
    }

    public ArrayList<AkcnaKarta> getMojeKarty() {
        return this.mojeKarty;
    }

    public void setMojeKarty(ArrayList<AkcnaKarta> mojeKarty) {
        this.mojeKarty = mojeKarty;
    }

    public void addMojeKarty(AkcnaKarta akcnaKarta){
        this.mojeKarty.add(akcnaKarta);
    }
}
