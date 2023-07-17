package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.karty.Voda;
import sk.stuba.fei.uim.oop.rybnik.Rybnik;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Vystrelit extends AkcnaKarta {
    private String meno = "Vystrelit";

    @Override
    public void aktivuj(Rybnik rybnik, Hrac[] hraci, ArrayList<AkcnaKarta> akcneKarty,int momentalnyHrac) {

        if(!(this.jeHratelna(rybnik)) && this.vsetkyKartyRovnake(rybnik,hraci,akcneKarty,momentalnyHrac)){
            int zahoditKartu = ZKlavesnice.readInt("Ziadne policko nie je zamerane a vsetky tvoje karty su Vystrelit, ktoru kartu ches vyhodit ?");

            while(zahoditKartu < 1 || zahoditKartu > 3){
                zahoditKartu = ZKlavesnice.readInt("Neplatny index. Musi byt od 1 do 3.");
            }

            akcneKarty.add(hraci[momentalnyHrac].getMojeKarty().get(zahoditKartu-1));
            hraci[momentalnyHrac].getMojeKarty().remove(zahoditKartu-1);
            hraci[momentalnyHrac].getMojeKarty().add(akcneKarty.get(0));
            akcneKarty.remove(0);
        }


            else {
            int policko = ZKlavesnice.readInt("Zadaj policko na ktore chces strelit:");

            while (policko < 1 || policko > 6 || !(rybnik.getRybnik1()[policko - 1].isZamerane())) {
                System.out.println("Policko na ktore ches strielat je mimo index alebo nie je zamerane.");
                policko = ZKlavesnice.readInt("Zadaj policko na ktore chces vystrelit:");
            }
            vystrelNaPolicko(rybnik, hraci, policko);
        }
        }


    public static void vystrelNaPolicko(Rybnik rybnik, Hrac[] hraci, int policko) {

        if(rybnik.getRybnik2().get(policko-1) instanceof Voda && rybnik.getRybnik1()[policko-1].isZamerane()){
            rybnik.getRybnik1()[policko-1].setZamerane(false);
        }
        else {
            hraci[rybnik.getRybnik2().get(policko-1).getHracove_id()].minusZivot();
            rybnik.getRybnik2().remove(policko - 1);
            if (rybnik.getBalicekKaciekVody().size() > 0) {
                rybnik.getRybnik2().add(rybnik.getBalicekKaciekVody().get(0));
                rybnik.getBalicekKaciekVody().remove(0);
            }
        }
        rybnik.getRybnik1()[policko-1].setZamerane(false);
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public boolean jeHratelna(Rybnik rybnik) {
        boolean vsetkyNezamerane=true;
        var policka = rybnik.getRybnik1();

        for(var policko : policka){
            if(policko.isZamerane()){
                vsetkyNezamerane=false;
                break;
            }
        }

        return !(vsetkyNezamerane);
    }

    @Override
    public boolean vsetkyKartyRovnake(Rybnik rybnik, Hrac[] hraci, ArrayList<AkcnaKarta> akcneKarty, int momentalnyHrac) {
        var kartyNaRuke = hraci[momentalnyHrac].getMojeKarty();
        boolean vssetkyKartyNaRukeVystrelit = true;

        for(var karta : kartyNaRuke){
            if (!(karta instanceof Vystrelit)) {
                vssetkyKartyNaRukeVystrelit = false;
                break;
            }
        }
        return vssetkyKartyNaRukeVystrelit;
    }
}
