/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectstudentsluchacz.domain;

/**
 *
 * @author 48514
 */
public abstract  class Osoba {
    
    private String imie;
    private String nazwisko;
    private int iloscOcen;
    private int ocena;
    private double sredniaOcen;
    private int ocenaZla2;

    public int getOcenaZla2() {
        return ocenaZla2;
    }

    public void setOcenaZla2(int ocenaZla2) {
        this.ocenaZla2 = ocenaZla2;
    }
    

    public double getSredniaOcen() {
        return sredniaOcen;
    }

    public void setSredniaOcen(double sredniaOcen) {
        this.sredniaOcen = sredniaOcen;
    }
    
    
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getIloscOcen() {
        return iloscOcen;
    }

    public void setIloscOcen(int iloscOcen) {
        this.iloscOcen = iloscOcen;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
