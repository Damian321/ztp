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
public class ZamowienieRabat extends Dekorator{

    public ZamowienieRabat(ZamowienieInterfejs zamowienie) {
        super(zamowienie);
    }

    @Override
    public void RealizacjaZamowienia() {
        
        zamowienie.RealizacjaZamowienia();
    }
    
  
    public void ustawRabat(double rabat){
        ((Zamowienie)zamowienie).setRabat(rabat);
        System.out.println("rabat ustawiony");
    }


}
