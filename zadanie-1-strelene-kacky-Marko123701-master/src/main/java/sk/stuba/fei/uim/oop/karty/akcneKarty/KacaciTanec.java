package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.karty.Policko;
import sk.stuba.fei.uim.oop.rybnik.Rybnik;

import java.util.ArrayList;
import java.util.Collections;

public class KacaciTanec  extends AkcnaKarta{
    private String meno = "KacaciTanec";

    @Override
    public void aktivuj(Rybnik rybnik, Hrac[] hraci, ArrayList<AkcnaKarta> akcneKarty,int momentalnyHrac) {
        var list1 = rybnik.getRybnik2();
        var list2 = rybnik.getBalicekKaciekVody();
        list1.addAll(list2);
        Collections.shuffle(list1);
        var list3 = new ArrayList<Policko>();
        for(int i=0;i<6;i++){
            list3.add(list1.get(0));
            list1.remove(0);
        }
        rybnik.setRybnik2(list3);
        rybnik.setBalicekKaciekVody(list1);
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public boolean jeHratelna(Rybnik rybnikc) {
        return true;
    }

    @Override
    public boolean vsetkyKartyRovnake(Rybnik rybnik, Hrac[] hraci, ArrayList<AkcnaKarta> akcneKarty, int momentalnyHrac) {
        return false;
    }
}
