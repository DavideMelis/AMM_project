/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacchetto1;

/**
 *
 * @author Kronox
 */
public class Utenti_registrati {
    
    public enum UserType {
        Admin, User,
    };
    
    private String Nome;
    private String Cognome;
    private String DataN;
    private String Presentazione;
    private String ImmageUrl;
    private String Password;
    private int Id;
    private UserType usertype;
    
    public Utenti_registrati() {
        this.Id = -1;
        this.Nome = "";
        this.Cognome = "";
        this.ImmageUrl = "";
        this.Presentazione = "";
        this.DataN = "";
        this.Password = "";
        this.usertype = UserType.User;
    }
    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the Cognome
     */
    public String getCognome() {
        return Cognome;
    }

    /**
     * @param Cognome the Cognome to set
     */
    public void setCognome(String Cognome) {
        this.Cognome = Cognome;
    }

    /**
     * @return the Data
     */
    public String getDataN() {
        return DataN;
    }

    /**
     * @param Data the Data to set
     */
    public void setDataN(String DataN) {
        this.DataN = DataN;
    }

    /**
     * @return the Presentazione
     */
    public String getPresentazione() {
        return Presentazione;
    }

    /**
     * @param Presentazione the Presentazione to set
     */
    public void setPresentazione(String Presentazione) {
        this.Presentazione = Presentazione;
    }

    /**
     * @return the ImmageUrl
     */
    public String getImmageUrl() {
        return ImmageUrl;
    }

    /**
     * @param ImmageUrl the ImmageUrl to set
     */
    public void setImmageUrl(String ImmageUrl) {
        this.ImmageUrl = ImmageUrl;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the usertype
     */
    public UserType getUsertype() {
        return usertype;
    }

    /**
     * @param usertype the usertype to set
     */
    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }
    public boolean controlloprofilo(Utenti_registrati utente) {
        if (utente.getNome().equals("") || utente.getCognome().equals("") || utente.getDataN().equals("")
                || utente.getImmageUrl().equals("") || utente.getPresentazione().equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
