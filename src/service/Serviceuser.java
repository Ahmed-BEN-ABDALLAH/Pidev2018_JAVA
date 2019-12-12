/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Authentification;
import static util.Authentification.user;
import util.MyConnexion;
public class Serviceuser {

    private Connection cnx;
    public static Authentification instance;
    public static User user;

    public Serviceuser() {
        cnx = MyConnexion.getInstance()
                .getConnection();

    }

    public User login(String name) {
        user = new User();

        System.out.println("hihihihi");
        String req = "SELECT * FROM `fos_user` WHERE username=? ";

        try {
            System.out.println("try");

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, name);

            ResultSet r = ps.executeQuery();

            if (r.next()) {
                user = new User(r.getInt("id"), r.getString("username"), r.getString("email"), r.getString("password"), r.getString("nom"), r.getString("prenom"), r.getString("roles"));
            }

        } catch (SQLException ex) {
            System.out.println("catch");

          System.out.println(ex);
            user.setId(0);
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);

        }

        return user;

    }
      public String inscription(User user) {
String req = "INSERT INTO fos_user"
		+ "(username, username_canonical, email, email_canonical, enabled, password, roles, nom, prenom, image, adrese, numtel) VALUES"
		+ "(?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println("hihihihi");
   
// execute insert SQL stetement
        try {
            
            System.out.println("try");

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, user.getUsername());
            ps.setString(2,user.getUsername_canonical());
                                
            ps.setString(3, user.getEmail());
                ps.setString(4, user.getEmail_canonical());
                            ps.setInt(5, 1);

            ps.setString(6, user.getPassword());
             ps.setString(7, user.getRoles());
          ps.setString(8, user.getNom());
          ps.setString(9, user.getPrenom());
          ps.setString(10, user.getImage());
          ps.setString(11, user.getAdrese());
          ps.setInt(12, user.getNumtel());
            boolean r = ps.execute();
            return "done";
          
        } catch (SQLException ex) {
            System.out.println("catch");

            System.out.println(ex);
            user.setId(0);
            return ex.toString();

        }

    }

}
