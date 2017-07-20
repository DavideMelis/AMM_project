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
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Kronox
 */
public class PostFactory {
    
    private static PostFactory singlepost;

    public static PostFactory getInstance() {
        if (singlepost == null) {
            singlepost = new PostFactory();
        }
        return singlepost;
    }
    private PostFactory() {
    }
    
        private String connectionString;

    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    private Post.PostType getPostType(String string) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private Post.PostType postTypeFromString(String type) {

        if (type.equals("Post_immage")) {
            return Post.PostType.post_immage;
        }

        return Post.PostType.post_text;
    }

    private int postTypeFromEnum(Post.PostType type) {
        //È realizzabile in modo più robusto rispetto all'hardcoding degli indici
        if (type == Post.PostType.post_text) {
            return 1;
        } else {
            return 2;
        }
    }
    
    private ArrayList<Post> listaPost = new ArrayList<Post>();

    public Post getPostById(int id) {

        Utenti_registratiFactory utentiFactory = Utenti_registratiFactory.getInstance();

        try {
            Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993"); 

            String query
                    = " select * from Posts " 
                    + " join postType on Posts.postType = postType.id_postType "
                    + " where id_post = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Post current = new Post();
                current.setId(res.getInt("id_post"));
                current.setIdUserBacheca(res.getInt("idUserBacheca"));
                current.setFrase(res.getString("Frase"));
                current.setImmagine(res.getString("Immagine"));
                current.setPostType(this.postTypeFromString(res.getString("postType")));
                Utenti_registrati autore = utentiFactory.getUtenti_registratiById(res.getInt("User"));
                current.setUser(autore);

                stmt.close();
                conn.close();
                return current;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public List getPostList(Utenti_registrati User) {

        try {

            Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993"); //username e password del database

            String query
                    = "select * from Posts "
                    + " join postType on Posts.postType = postType.id_postType "
                    + "where User = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, User.getId());

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Post current = new Post();

                current.setId(res.getInt("Id"));

                current.setFrase(res.getString("Frase"));

                current.setImmagine(res.getString("Immagine"));

                current.setPostType(this.postTypeFromString(res.getString("postType")));

                current.setUser(User);

                listaPost.add(current);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
    
    public List getPostListByIdUser(int id) {
        List<Post> listaPost = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993"); 

            String query
                    = "select * from Posts "
                    + "join postType on Posts.postType = postType.id_postType "
                    + "where User = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Post current = new Post();

                current.setId(res.getInt("Id"));

                current.setFrase(res.getString("Frase"));

                current.setImmagine(res.getString("Immagine"));

                current.setPostType(this.postTypeFromString(res.getString("postType")));

                current.setUser(Utenti_registratiFactory.getInstance().getUtenti_registratiById(res.getInt("User")));

                listaPost.add(current);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;

    }
    
    public void addNewPost(Post post){
        try {
            
            Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993");
            
            String query = 
                      "insert into posts (Id, Frase, postType , User, idUtenteBacheca) "
                    + "values (default, ? , ? , ?, ?)";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, post.getFrase());

            stmt.setInt(2, this.postTypeFromEnum(post.getPostType()));
            
            stmt.setInt(3, post.getUser().getId());
            
            stmt.setInt(4, post.getUser().getId());
            
            // Esecuzione query
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deletePostsBacheca(int id) {
            List<Post> listaPost = PostFactory.getInstance().getPostListByIdUser(id);
            String query;

        for (Post post : listaPost) {

            try {

                Connection conn = DriverManager.getConnection(connectionString, "Kronox", "Kronox1993");
                query
                        = "delete from posts "
                        + "where id_post = ? ";

                PreparedStatement stmt = conn.prepareStatement(query);

     
                stmt.setInt(1, post.getId());


                stmt.executeUpdate();
                stmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
            
     }
    
}
