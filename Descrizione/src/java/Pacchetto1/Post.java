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
public class Post {
    
    public enum PostType {
        post_text, post_immage,
    };
    
    private int Id;
    private Utenti_registrati user;
    private String Frase;
    private PostType postType;
    private String Immagine;
    private int idUserBacheca;
    
    public Post() {
        Id = 0;
        user = null;
        Frase = "";
        Immagine = "";
        postType = PostType.post_text;
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
     * @return the user
     */
    public Utenti_registrati getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Utenti_registrati user) {
        this.user = user;
    }

    /**
     * @return the Frase
     */
    public String getFrase() {
        return Frase;
    }

    /**
     * @param Frase the Frase to set
     */
    public void setFrase(String Frase) {
        this.Frase = Frase;
    }

    /**
     * @return the postType
     */
    public PostType getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    /**
     * @return the Immagine
     */
    public String getImmagine() {
        return Immagine;
    }

    /**
     * @param Immagine the Immagine to set
     */
    public void setImmagine(String Immagine) {
        this.Immagine = Immagine;
    }

    /**
     * @return the idUserBacheca
     */
    public int getIdUserBacheca() {
        return idUserBacheca;
    }

    /**
     * @param idUserBacheca the idUserBacheca to set
     */
    public void setIdUserBacheca(int idUserBacheca) {
        this.idUserBacheca = idUserBacheca;
    }
    
}
