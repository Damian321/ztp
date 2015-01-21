/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kostek
 */
public class DatabaseConn {

    private static final String dbURL = "jdbc:derby://localhost:1527/magazyn;create=true;user=sa;password=sa";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static DatabaseConn instance = new DatabaseConn();

    private DatabaseConn() {
    }

    public static DatabaseConn GetInstance() {
        return instance;
    }

    public void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
            System.out.println(conn.getSchema());
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    public void addTowar(Towar towar){
          try {
          
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO TOWAR(nazwa,ilosc,cena,stawkavat) VALUES('"
                    +towar.getNazwa()+"',"+towar.getIlosc()
            + "," + towar.getCena()+","+towar.getStawkaVAT()+")");
           
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }
    
    public Towar findTowarByName(String nazwa){
            Towar towar = new Towar();
         try {
          
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from towar where nazwa like '"+nazwa+"'");

            System.out.println("\n-------------------------------------------------");

            while (rs.next()) {     
                towar.setId(rs.getInt("id"));
                towar.setNazwa(rs.getString("nazwa"));
                towar.setIlosc(rs.getInt("ilosc"));
                towar.setCena(rs.getDouble("cena"));
                towar.setStawkaVAT(rs.getDouble("stawkavat"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return towar;       
    }
    
    public List<Towar> findAllTowar() {
        List<Towar> lista_towarow=new ArrayList<Towar>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from towar");

            while (rs.next()) {
                Towar towar = new Towar();
                towar.setId(rs.getInt("id"));
                towar.setNazwa(rs.getString("nazwa"));
                towar.setIlosc(rs.getInt("ilosc"));
                towar.setCena(rs.getDouble("cena"));
                towar.setStawkaVAT(rs.getDouble("stawkavat"));
                lista_towarow.add(towar);
            }
            rs.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return lista_towarow;
    }
      public List<Zamowienie> findAllZamowienie() {
        List<Zamowienie> lista_zamowien=new ArrayList<Zamowienie>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from zamowienia");

            while (rs.next()) {
                Zamowienie zamowienie = new Zamowienie();
                zamowienie.setId(rs.getInt("id"));
                zamowienie.setImie(rs.getString("imie"));
                zamowienie.setNazwisko(rs.getString("nazwisko"));
                zamowienie.setData_zamowienia(rs.getDate("data_zamowienia"));
                zamowienie.setRabat(rs.getDouble("rabat"));
                lista_zamowien.add(zamowienie);
            }
            rs.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return lista_zamowien;
    }

}
