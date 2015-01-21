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
public class Projekt {

   
    
    public static void main(String[] args) {
        // TODO code application logic here
        DatabaseConn dbConn = DatabaseConn.GetInstance();
        dbConn.createConnection();
   
      //  System.out.println(dbConn.findAllTowar());
        System.out.println();
        System.out.println(dbConn.findTowarByName("lyzwy"));
        ZamowienieInterfejs zam = new ZamowienieFaktura(new ZamowienieRabat(new Zamowienie()));
       
     //   zma2.wystawFakture();
      
        
      //  System.out.println(zam.getClass() + "   ");
      
      //  zam.RealizacjaZamowienia();
        JFrameGlowna glownaFrame = new JFrameGlowna();
        glownaFrame.setVisible(true);
    }
    
}
