/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacchetto1;
import java.util.*;
import java.util.ArrayList;
/**
 *
 * @author Kronox
 */
public class Gruppi {
    private int id;
    private String nomeGruppo;
    private int IdUserProprietario;
    private List<Utenti_registrati> listaUser = new ArrayList<>();

    public Gruppi() {
        id = 0;
        nomeGruppo ="";
        IdUserProprietario = 0;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nomeGruppo
     */
    public String getNomeGruppo() {
        return nomeGruppo;
    }

    /**
     * @param nomeGruppo the nomeGruppo to set
     */
    public void setNomeGruppo(String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }

    /**
     * @return the IdUtenteProprietario
     */
    public int getIdUserProprietario() {
        return IdUserProprietario;
    }

    /**
     * @param IdUtenteProprietario the IdUtenteProprietario to set
     */
    public void setIdUserProprietario(int IdUtenteProprietario) {
        this.IdUserProprietario = IdUserProprietario;
    }

    /**
     * @return the listaUtenti
     */
    public List<Utenti_registrati> getListaUtenti() {
        return listaUser;
    }

    /**
     * @param listaUtenti the listaUtenti to set
     */
    public void setListaUtenti(List<Utenti_registrati> listaUtenti) {
        this.listaUser = listaUtenti;
    }
    public void stampaListaUt() {
        this.getListaUtenti().forEach((i) -> {
            System.out.println(i.getNome());
        });
    /**
     *
     * @param utenti
     */
    }
    public void aggiungi(Utenti_registrati utenti) {

        this.getListaUtenti().add(utenti);

    }

    public void aggiungi(List<Utenti_registrati> lista) {
        lista.forEach((i) -> {
            this.getListaUtenti().add(i);
        });
    }
}

