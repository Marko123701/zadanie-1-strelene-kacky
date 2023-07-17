package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.rybnik.Rybnik;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class DivokyBill extends AkcnaKarta{
    private String meno = "DivokyBill";

    @Override
    public void aktivuj(Rybnik rybnik, Hrac[] hraci, ArrayList<AkcnaKarta> akcneKarty,int momentalnyHrac) {
        int policko = ZKlavesnice.readInt("Zadaj policko na ktore chces zamierit a vystrelit:");

        while(policko < 1 || policko > 6){
            System.out.println("Policko na ktore ches strielat je mimo index. Musi byt od 1 po 6.");
            policko = ZKlavesnice.readInt("Zadaj policko na ktore chces zamierit a vystrelit:");
        }

        rybnik.getRybnik1()[policko-1].setZamerane(true);
        Vystrelit.vystrelNaPolicko(rybnik, hraci, policko);
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
