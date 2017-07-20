/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacchetto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Kronox
 */
public class GruppiFactory {
    
    private static GruppiFactory singleton;

    public static GruppiFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppiFactory();
        }
        return singleton;
    }
    
    private String connectionString;
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    private GruppiFactory() {
    }
    
    public Gruppi getGruppiById(int id) {
        //ripescaggio Gruppi
        try {
            Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993");

            String query
                    = " select * from gruppi " 
                    + " where id_gruppi = ? ";
            String query2
                    = "select * from listaUtentiGroup" +
                    "join id_listaUser on listaUserGroup.id_listaUser=id_gruppi "
                    + " where id_listaUtenti = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            PreparedStatement stmt2 = conn.prepareStatement(query2);

            stmt.setInt(1, id);
            stmt2.setInt(2, id);
           
            ResultSet res = stmt.executeQuery();
            ResultSet res2 = stmt2.executeQuery();

            if (res.next()) {
                Gruppi current = new Gruppi();
                
                current.setId(res.getInt("id_gruppi"));
                current.setIdUserProprietario(res.getInt("idUserProprietario"));
                current.setNomeGruppo(res.getString("NomeGruppo"));
                
                current.setId(res2.getInt("id_listaUser"));
                
                
                stmt.close();
                conn.close();
                stmt2.close();
                conn.close();
                return current;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public Gruppi getGruppiByNome(String nome) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993"); 

            String query
                    = " select * from gruppi " 
                    + " where NomeGruppo = ? ";
            String query2
                    = "select * from listaUserGruppi " +
                    "join id_listaUser on listaUserGruppi.id_listaUser=id_gruppi " 
                    + " where id_listaUser = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            PreparedStatement stmt2 = conn.prepareStatement(query2);

            stmt.setString(1, nome);
            stmt2.setString(2, nome);
           
            ResultSet res = stmt.executeQuery();
            ResultSet res2 = stmt2.executeQuery();

            if (res.next()) {
                Gruppi current = new Gruppi();
                
                current.setId(res.getInt("id_gruppi"));
                current.setIdUserProprietario(res.getInt("idUtenteProprietario"));
                current.setNomeGruppo(res.getString("NomeGruppo"));
                
                current.setId(res2.getInt("id_listaUser"));
                
                
                stmt.close();
                conn.close();
                stmt2.close();
                conn.close();
                
                return current;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
        
    }
    
    public ArrayList<Gruppi> getGruppi() {
        
       ArrayList<Gruppi> listaGruppi = new ArrayList<>();
            try {
            Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993"); 

           String query
                    = " select * from gruppi " ;

            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                
                Gruppi current = new Gruppi();
                
                current.setId(res.getInt("id_gruppi"));
                current.setIdUserProprietario(res.getInt("idUserProprietario"));
                current.setNomeGruppo(res.getString("NomeGruppo"));

                listaGruppi.add(current);
                
            }
            
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
            
            return listaGruppi;


    }
}
