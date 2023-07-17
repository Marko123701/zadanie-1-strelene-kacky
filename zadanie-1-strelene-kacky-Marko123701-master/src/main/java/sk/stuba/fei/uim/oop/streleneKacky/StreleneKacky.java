package sk.stuba.fei.uim.oop.streleneKacky;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.karty.akcneKarty.*;
import sk.stuba.fei.uim.oop.rybnik.Rybnik;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.*;

public class StreleneKacky {
    private final Hrac[] hraci;
    private int momentalnyHrac;
    private int cisloKola;
    private final int pocetHracov;
    private ArrayList<AkcnaKarta> akcneKarty;

    public StreleneKacky() {
        System.out.println("Vytam Vas v hre Strelene Kacky");
        int pocetHracovPodmienka = ZKlavesnice.readInt("Zadaj pocet hracov(2-6): ");;
        while(pocetHracovPodmienka < 2 || pocetHracovPodmienka > 6) {
            pocetHracovPodmienka = ZKlavesnice.readInt("Nezadal si spravny pocet hracov. Zadaj pocet hracov(2-6):");
        }
        this.pocetHracov = pocetHracovPodmienka;
        this.hraci = new Hrac[pocetHracov];
        for (int i = 0; i < pocetHracov; i++) {
            this.hraci[i] = new Hrac(ZKlavesnice.readString("Napis meno hraca c." + (i + 1) + ":"));
        }
        var rybnik = new Rybnik();
        rybnik.nastavRybnik(this.pocetHracov,this.hraci);
        this.zamiesajAkcneKarty();
        this.zacni(rybnik);
    }



    private void zacni(Rybnik rybnik) {
    System.out.println("--- HRA ZACALA ---");
    for (this.momentalnyHrac = 0; this.SuNazive() > 1; this.zvacsiCisloKola()) {
        if (this.momentalnyHrac == 0) {
            System.out.println("--- KOLO " + (this.cisloKola / this.hraci.length + 1) + " ZACINA ---");
        }

        Hrac aktivnyHrac = this.hraci[this.momentalnyHrac];
        if (!aktivnyHrac.isJeNazive()) {
            if(aktivnyHrac.getMojeKarty().size() != 0){ //vrat karty do balika ak je hrac je mrtvy
                this.akcneKarty.addAll(aktivnyHrac.getMojeKarty());
                aktivnyHrac.getMojeKarty().clear();
            }
            continue;
        }
        System.out.println("--- HRAC " + aktivnyHrac.getMeno() + " ZACINA KOLO ---\n");
        rybnik.vytlacRybnik();
        System.out.println("Tvoje karty: ");
        for(int i=0;i<3;i++){
            System.out.print(i+1 + "." + aktivnyHrac.getMojeKarty().get(i).getMeno() + " ");
        }
        int momentalnaKarta = ZKlavesnice.readInt("\nKtoru kartu si zelas zahrat ?");
        while(momentalnaKarta<1 || momentalnaKarta > 3 || !(aktivnyHrac.getMojeKarty().get(momentalnaKarta-1).jeHratelna(rybnik))) {

            if(momentalnaKarta<1 || momentalnaKarta > 3) {
                System.out.println("Neplatny index. Musi byt od 1 do 3.");
            }
            else{
                if(aktivnyHrac.getMojeKarty().get(momentalnaKarta-1).vsetkyKartyRovnake(rybnik,this.hraci,this.akcneKarty,this.momentalnyHrac)){
                    break; //Ak sa karta neda zahrat a vsetky karty na ruke su rovnake preskakujem na AkcnaKarta.aktivuj kde to je osetrene a vyhodim kartu ktoru si vyberiem
                }
                System.out.println("Tuto kartu nemozes zahrat. Vyber inu.");
            }
            momentalnaKarta = ZKlavesnice.readInt("Ktoru kartu si zelas zahrat ?");
        }
        aktivnyHrac.getMojeKarty().get(momentalnaKarta-1).aktivuj(rybnik,this.hraci,this.akcneKarty,this.momentalnyHrac);
        this.akcneKarty.add(aktivnyHrac.getMojeKarty().get(momentalnaKarta-1)); //pouzitu kartu hod na koniec balicka
        aktivnyHrac.getMojeKarty().remove(momentalnaKarta-1);
        aktivnyHrac.addMojeKarty(this.akcneKarty.get(0)); //potiahni si kartu
        this.akcneKarty.remove(0);
        rybnik.vytlacRybnik();
        koniecKola(aktivnyHrac);
    }
        System.out.println("--- HRA SA SKONCILA ---");
        System.out.println("A VYHERCA JE HRAC " + Objects.requireNonNull(getVyherca()).getMeno());
    }

    private void zamiesajAkcneKarty(){

        this.akcneKarty = new ArrayList<>();
        for(int i = 0;i<10;i++){
            this.akcneKarty.add(new Zamierit());
        }
        for(int i = 0;i<12;i++){
            this.akcneKarty.add(new Vystrelit());
        }
        for(int i = 0;i<2;i++){
            this.akcneKarty.add(new DivokyBill());
        }
        for(int i = 0;i<6;i++){
            this.akcneKarty.add(new KacaciPochod());
        }

        this.akcneKarty.add(new Turbokacka());

        for(int i = 0;i<2;i++){
            this.akcneKarty.add(new Rosambo());
        }

        this.akcneKarty.add(new KacaciTanec());

        Collections.shuffle(this.akcneKarty);

        for(int i = 0; i < pocetHracov; i++) {
            var hracoveKarty = new ArrayList<AkcnaKarta>();
            for(int j =0;j <3;j++){
                hracoveKarty.add(this.akcneKarty.get(0));
                this.akcneKarty.remove(0);
            }
            this.hraci[i].setMojeKarty(hracoveKarty);
        }
        }

        private int SuNazive(){
        int suNazive=0;
        for(int i =0;i<this.pocetHracov;i++){
            if(this.hraci[i].isJeNazive()){
                suNazive++;
            }
        }
        return suNazive;
    }

    private void zvacsiCisloKola() {
        this.momentalnyHrac++;
        this.momentalnyHrac %= this.hraci.length;
        this.cisloKola++;
    }
    private void koniecKola(Hrac aktivnyHrac) {
        System.out.println("--- HRAC " + aktivnyHrac.getMeno() + " KONCI KOLO ---\n");
        ZKlavesnice.readString("STLAC ENTER A POKRACUJ");
    }

    private Hrac getVyherca() {
        for (Hrac hrac : this.hraci) {
            if (hrac.isJeNazive()) {
                return hrac;
            }
        }
        return null;
    }

}

