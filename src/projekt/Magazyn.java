/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kostek
 */
public class Magazyn {
    private static Magazyn instance = new Magazyn();
    private List<Towar> lista_towarow;
    private DatabaseConn dbConn = DatabaseConn.GetInstance();

    public void dodajTowar(Towar towar){
        dbConn.addTowar(towar);
        lista_towarow.add(towar);
    }
    
    public void zmniejszIlosc(Towar towar, int ilosc){
        Towar towar2 = new Towar();
        towar2 = towar;
        towar2.setIlosc(towar.getIlosc()-ilosc);
    }
    
    public void wydajTowar(Towar towar){
        
    }
    
    public List<Towar> getLista_towarow() {
        return lista_towarow;
    }

    public void setLista_towarow(List<Towar> lista_towarow) {
        this.lista_towarow = lista_towarow;
    }
    
    private Magazyn(){
    lista_towarow=new ArrayList<Towar>();
    lista_towarow = dbConn.findAllTowar();
    }
    
    public static Magazyn getInstance(){
        return instance;
    }

    @Override
    public String toString() {
        return "Magazyn{" + "lista_towarow=" + lista_towarow + '}';
    }
}
