package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.rybnik.Rybnik;
import java.util.ArrayList;

public abstract class AkcnaKarta {

    public abstract void aktivuj (Rybnik rybnik, Hrac[] hraci, ArrayList<AkcnaKarta> akcneKarty,int momentalnyHrac);

    public abstract String getMeno();

    public abstract boolean jeHratelna(Rybnik rybnik);

    public abstract boolean vsetkyKartyRovnake(Rybnik rybnik, Hrac[] hraci, ArrayList<AkcnaKarta> akcneKarty,int momentalnyHrac);

}

