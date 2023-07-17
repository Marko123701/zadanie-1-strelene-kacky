package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.rybnik.Rybnik;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;


public class Zamierit extends AkcnaKarta {
    private String meno = "Zamierit";

@Override
public void aktivuj(Rybnik rybnik, Hrac[] hraci, ArrayList<AkcnaKarta> akcneKarty,int momentalnyHrac) {

    if(!(this.jeHratelna(rybnik)) && this.vsetkyKartyRovnake(rybnik,hraci,akcneKarty,momentalnyHrac)){
        int zahoditKartu = ZKlavesnice.readInt("Vsetky policka su zamerane a vsetky tvoje karty su Zamerat, ktoru kartu ches vyhodit ?");

        while(zahoditKartu < 1 || zahoditKartu > 3){
                zahoditKartu = ZKlavesnice.readInt("Neplatny index. Musi byt od 1 do 3.");
            }
            akcneKarty.add(hraci[momentalnyHrac].getMojeKarty().get(zahoditKartu-1));
            hraci[momentalnyHrac].getMojeKarty().remove(zahoditKartu-1);
            hraci[momentalnyHrac].getMojeKarty().add(akcneKarty.get(0));
            akcneKarty.remove(0);
        }

    else {
        int policko = ZKlavesnice.readInt("Zadaj policko ktore chces zamierit:");

        while (policko < 1 || policko > 6 || rybnik.getRybnik1()[policko - 1].isZamerane()) {
            System.out.println("Policko ktore ches zamerat je mimo index alebo je uz zamerane.");
            policko = ZKlavesnice.readInt("Zadaj policko ktore chces zamierit:");
        }

        if (!rybnik.getRybnik1()[policko - 1].isZamerane()) {
            rybnik.getRybnik1()[policko - 1].setZamerane(true);
        }
    }
    }



    public String getMeno() {
    return this.meno;
    }

    @Override
    public boolean jeHratelna(Rybnik rybnik) {
        boolean vsetkyPolickaZamierene=true;
        var policka = rybnik.getRybnik1();

        for(var policko : policka){
            if(!policko.isZamerane()){
                vsetkyPolickaZamierene = false;
                break;
            }
        }

        return !(vsetkyPolickaZamierene);
    }

    @Override
    public boolean vsetkyKartyRovnake(Rybnik rybnik, Hrac[] hraci, ArrayList<AkcnaKarta> akcneKarty, int momentalnyHrac) {
        boolean vsetkyKartyNaRukeZamierit=true;
        var kartyNaRuke = hraci[momentalnyHrac].getMojeKarty();

        for(var karta : kartyNaRuke){
            if (!(karta instanceof Zamierit)) {
                vsetkyKartyNaRukeZamierit = false;
                break;
            }
        }

        return vsetkyKartyNaRukeZamierit;
    }
}

