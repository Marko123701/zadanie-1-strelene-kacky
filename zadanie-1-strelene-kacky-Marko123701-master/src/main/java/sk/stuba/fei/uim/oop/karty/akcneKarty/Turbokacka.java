package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.karty.Voda;
import sk.stuba.fei.uim.oop.rybnik.Rybnik;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Turbokacka  extends AkcnaKarta{
    private String meno = "Turbokacka";

    @Override
    public void aktivuj(Rybnik rybnik, Hrac[] hraci, ArrayList<AkcnaKarta> akcneKarty,int momentalnyHrac) {

        int policko = ZKlavesnice.readInt("Zadaj policko kacky ktoru ches posunut dopredu:");

        while(policko < 1 || policko > 6 || (rybnik.getRybnik2().get(policko-1) instanceof Voda)){

            if(policko < 1 || policko > 6){
                System.out.println("Policko je mimo index. Musi byt od 1 po 6.");
            }
            else {
                System.out.println("Toto je voda zadaj kacku.");
            }
            policko = ZKlavesnice.readInt("Zadaj policko kacky ktoru ches posunut dopredu:");
        }


        rybnik.getRybnik2().add(0,rybnik.getRybnik2().get(policko-1));
        rybnik.getRybnik2().remove(policko);
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
