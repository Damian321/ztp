/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

/**
 *
 * @author Kostek
 */
public class Towar {
    private int id;
    private String nazwa;
    private int ilosc;
    private double cena;
    private double stawkaVAT;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getStawkaVAT() {
        return stawkaVAT;
    }

    public void setStawkaVAT(double stawkaVAT) {
        this.stawkaVAT = stawkaVAT;
    }
    
    @Override
    public String toString() {
        return "Towar{" + "id=" + id + ", nazwa=" + nazwa + ", ilosc=" + ilosc + ", cena=" + cena + ", stawkaVAT=" + stawkaVAT + '}';
    }
}
