package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.karty.Kacka;
import sk.stuba.fei.uim.oop.karty.Voda;
import sk.stuba.fei.uim.oop.rybnik.Rybnik;

import java.util.ArrayList;

public class KacaciPochod extends AkcnaKarta{
    private String meno = "KacaciPochod";

    @Override
    public void aktivuj(Rybnik rybnik, Hrac[] hraci, ArrayList<AkcnaKarta> akcneKarty,int momentalnyHrac) {
        if(rybnik.getRybnik2().get(0)instanceof Kacka){
            rybnik.getBalicekKaciekVody().add(new Kacka(hraci[rybnik.getRybnik2().get(0).getHracove_id()].getMeno(),rybnik.getRybnik2().get(0).getHracove_id()));
        }else rybnik.getBalicekKaciekVody().add(new Voda());

        rybnik.getRybnik2().remove(0);
        rybnik.getRybnik2().add(rybnik.getBalicekKaciekVody().get(0));
        rybnik.getBalicekKaciekVody().remove(0);
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public boolean jeHratelna(Rybnik rybnik) {
        return true;
    }

    @Override
    public boolean vsetkyKartyRovnake(Rybnik rybnik, Hrac[] hraci, ArrayList<AkcnaKarta> akcneKarty, int momentalnyHrac) {
        return false;
    }
}
