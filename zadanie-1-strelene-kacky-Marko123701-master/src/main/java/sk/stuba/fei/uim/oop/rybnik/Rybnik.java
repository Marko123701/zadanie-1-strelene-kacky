package sk.stuba.fei.uim.oop.rybnik;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.karty.Kacka;
import sk.stuba.fei.uim.oop.karty.Policko;
import sk.stuba.fei.uim.oop.karty.Voda;
import sk.stuba.fei.uim.oop.karty.Zameriavac;

import java.util.ArrayList;
import java.util.Collections;

public class Rybnik {

    private Zameriavac[] rybnik1; //zameriavace
    private ArrayList<Policko> rybnik2; //karty vody a kaciek v hre
    private ArrayList<Policko> balicekKaciekVody; //balicek na tahanie do rybnika

   public void nastavRybnik(int pocetHracov,Hrac[] hraci) {
        this.rybnik1 = new Zameriavac[]{
                new Zameriavac(),
                new Zameriavac(),
                new Zameriavac(),
                new Zameriavac(),
                new Zameriavac(),
                new Zameriavac()
        };
        this.balicekKaciekVody = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.balicekKaciekVody.add(new Voda());
        }
        for (int i = 0; i < pocetHracov; i++) {
            for (int j = 0; j < 5; j++) {
                this.balicekKaciekVody.add(new Kacka(hraci[i].getMeno(), i));
            }
        }
        Collections.shuffle(this.balicekKaciekVody);
       this.rybnik2 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            this.rybnik2.add(this.balicekKaciekVody.get(0));
            this.balicekKaciekVody.remove(0);

        }
    }
    public void vytlacRybnik() {
        for (int i = 0; i < 6; i++) {
            System.out.println(i + 1 + ". " + this.rybnik1[i].vykresli() + " - " + this.rybnik2.get(i).vykresli());
        }
        System.out.println();
    }

    public Zameriavac[] getRybnik1() {
        return rybnik1;
    }

    public ArrayList<Policko> getRybnik2() {
        return rybnik2;
    }

    public void setRybnik2(ArrayList<Policko> rybnik2) {
        this.rybnik2 = rybnik2;
    }

    public ArrayList<Policko> getBalicekKaciekVody() {
        return balicekKaciekVody;
    }

    public void setBalicekKaciekVody(ArrayList<Policko> balicekKaciekVody) {
        this.balicekKaciekVody = balicekKaciekVody;
    }
}
