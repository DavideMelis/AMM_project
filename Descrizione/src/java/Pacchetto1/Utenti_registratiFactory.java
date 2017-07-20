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
public class Utenti_registratiFactory {
    
    private static Utenti_registratiFactory singleton;
    
    public static Utenti_registratiFactory getInstance() {
        if (singleton == null) {
            singleton = new Utenti_registratiFactory();
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
    
    private ArrayList<Utenti_registrati> listaUser = new ArrayList<Utenti_registrati>();
    
    private Utenti_registratiFactory() {
    }
    
    public Utenti_registrati getUtenti_registratiById(int id) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993"); 

            String query
                    = "select * from utenti_registrati "
                    + "where Id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Utenti_registrati current = new Utenti_registrati();

                current.setId(res.getInt("Id"));
                current.setNome(res.getString("Nome"));
                current.setCognome(res.getString("cognome"));
                current.setImmageUrl(res.getString("ImmageUrl"));
                current.setPresentazione(res.getString("Presentazione"));
                current.setDataN(res.getString("Data"));
                current.setPassword(res.getString("Password"));

                stmt.close();
                conn.close();

                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password) {

        try {
            Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993"); 

            String query
                    = "select * from utenti_registrati " 
                    + "where Nome = ? and Password = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, user);
            stmt.setString(2, password);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                int id = res.getInt("Id");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
    
    public boolean CheckProfile(int loggerUserID) {
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993"); 

            String query
                    = "select * from utenti_registrati " 
                    + "where Id= ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, loggerUserID);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                if(loggerUserID==res.getInt("Id"));

                stmt.close();
                conn.close();
                return true;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<Utenti_registrati> getUser() {
                
       ArrayList<Utenti_registrati> listaUser = new ArrayList<>();
            try {
            Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993"); 

           String query
                    = " select * from utenti_registrati " ; 

            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                
                Utenti_registrati current = new Utenti_registrati();
                
                current.setId(res.getInt("Id"));
                current.setNome(res.getString("Nome"));
                current.setCognome(res.getString("Cognome"));
                current.setImmageUrl(res.getString("ImmageUrl"));
                current.setPresentazione(res.getString("Presentazione"));
                current.setDataN(res.getString("DataN"));
                current.setPassword(res.getString("Password"));
                
                listaUser.add(current);
                
            }
            
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
            
        return listaUser;
    }
    
    public void deleteUtente (Utenti_registrati User) {
        
        String query;
        PreparedStatement stmt;
        Connection conn;
        

            try {
                
            conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993");
                     
            query = " delete from utenti_registrati " + " where Id = ? ";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, User.getId());
            stmt.executeUpdate();
            


            stmt.close();
            conn.close();

            } catch (SQLException e) {
                e.printStackTrace();

            }
    }
    
    public ArrayList<Utenti_registrati> listaLatoSx(String Nome) {
        
        ArrayList<Utenti_registrati> listaUser = new ArrayList<Utenti_registrati>();
        
        try {

            Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993");
            String query = "select * from utenti_registrati where Nome like ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + Nome + "%");
            ResultSet res = stmt.executeQuery();
            
            while (res.next()) {

                Utenti_registrati current = new Utenti_registrati();
                current.setId(res.getInt("Id"));
                current.setNome(res.getString("Nome"));
                current.setCognome(res.getString("Cognome"));
                current.setPassword(res.getString("Password"));
                current.setDataN(res.getString("Data"));
                current.setPresentazione(res.getString("Presentazione"));
                current.setImmageUrl(res.getString("ImmageUrl"));

                listaUser.add(0, current);

            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaUser;
    
    }
    
}
