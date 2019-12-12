/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Jardin;
import entities.Messages;
import entities.User;
import entities.produit_donation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Authentification;
import util.MyConnexion;

/**
 *
 * @author qyen
 */
public class ServiceJardins {

    private Connection cnx;
    public static Authentification instance;
    public static User user;

    public ServiceJardins() {
        cnx = MyConnexion.getInstance()
                            .getConnection();

    }

    public void deleteJardin(int id) {
        try {

            String req = "DELETE FROM jarenfant WHERE id=" + id;
            // String req = "DELETE FROM messages WHERE id_recepteur=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("supp success");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceMsgs.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());

        }

    }

    /*
 String  query = "select * from jarenfant where id = ? ";
        PreparedStatement ps;
        try {
            ps = MyConnexion.getInstance().getConnection().prepareCall(query);
            ps.setInt(1, j);
      ResultSet rest=  ps.executeQuery();
     */
    public List<Jardin> listjardins() {

        List<Jardin> jardins = new ArrayList<Jardin>();
        try {
            //String et="accepter";

            String req = "Select * from jarenfant where etat = 'accepter'";
            PreparedStatement st = cnx.prepareStatement(req);

            System.out.println("requete preparer");
            ResultSet res = st.executeQuery(req);
            while (res.next()) {

                Jardin j = new Jardin();
                j.id = res.getInt(1);
                j.nom = res.getString(2);
                j.description = res.getString(3);
                j.adresse = res.getString(4);
                j.logo = res.getString(5);
                j.proprietaire = res.getInt(6);
                j.numtel = res.getInt(9);
                j.adresseemail = res.getString(10);
                j.etat = res.getString(11);

                jardins.add(j);
            }
            System.out.println("aa");

        } catch (Exception e) {
            System.out.println(" erreuuur");
            System.out.println(e);
        }
        return jardins;

    }

    public List<Jardin> toutejardins() {
        List<Jardin> jardins = new ArrayList<Jardin>();
        try {

            String req = "Select * from jarenfant";
            PreparedStatement st = cnx.prepareStatement(req);
            System.out.println("requete preparer");
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                Jardin j = new Jardin();
                j.id = res.getInt(1);
                j.nom = res.getString(2);
                j.description = res.getString(3);
                j.adresse = res.getString(4);
                j.logo = res.getString(5);
                j.proprietaire = res.getInt(6);
                j.numtel = res.getInt(9);
                j.adresseemail = res.getString(10);
                j.etat = res.getString(11);

                jardins.add(j);
            }
            System.out.println("aa");

        } catch (Exception e) {
            System.out.println(" erreuuur");
        }
        return jardins;

    }

    public List<Jardin> Mesjardins(int idprop) {
        List<Jardin> mesjardins = new ArrayList<Jardin>();
        try {

            String req = "Select * from jarenfant where proprietaire=" + idprop;
            PreparedStatement st = cnx.prepareStatement(req);
            System.out.println("requete preparer");
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                Jardin j = new Jardin();
                j.id = res.getInt(1);
                j.nom = res.getString(2);
                j.description = res.getString(3);
                j.adresse = res.getString(4);
                j.logo = res.getString(5);
                j.proprietaire = res.getInt(6);
                j.numtel = res.getInt(9);
                j.adresseemail = res.getString(10);
                j.etat = res.getString(11);

                mesjardins.add(j);
            }
            System.out.println("aa");
            return mesjardins;

        } catch (Exception e) {
            System.out.println(" erreuuur");
            return null;
        }

    }

    public void addjardin(Jardin jar) throws SQLException {
        //
        try {
            String req = "Insert into jarenfant (nom,description,adresse,logo,proprietaire,numtel,adressemail,etat)"
                                + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("requete preparer");
            ps.setString(1, jar.nom);
            ps.setString(2, jar.description);
            ps.setString(3, jar.adresse);
            ps.setString(4, jar.logo);
            ps.setInt(5, jar.proprietaire);
            ps.setInt(6, jar.numtel);
            ps.setString(7, jar.adresseemail);
           ps.setString(8, "attente");

            ps.executeUpdate();
            System.out.println("aa");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public Jardin Getonejardin(int j) throws SQLException {
        //-------------------- Update ----------//
        Jardin jr = new Jardin();

        String query = "select * from jarenfant where id = ? ";
        PreparedStatement ps;
        try {
            ps = MyConnexion.getInstance().getConnection().prepareCall(query);
            ps.setInt(1, j);
            ResultSet rest = ps.executeQuery();

            while (rest.next()) {
                jr.setId(rest.getInt("id"));
                jr.setNom(rest.getString("nom"));
                jr.setDescription(rest.getString("description"));
                jr.setAdresse(rest.getString("adresse"));
                jr.setLogo(rest.getString("logo"));
                jr.setProprietaire(rest.getInt("proprietaire"));
                jr.setNumtel(rest.getInt("numtel"));
                jr.setAdresseemail(rest.getString("adressemail"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(MyServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jr;

    }

    public void updatejardin(Jardin j) {
        try {
            String req = "UPDATE jarenfant SET (nom=?,description=?,adresse=?,numtel=?) WHERE id=?";

            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);

            ste.setString(1, j.getNom());
            ste.setString(2, j.getDescription());

            ste.setString(3, j.getAdresse());

            ste.setInt(4, j.getNumtel());

            ste.setInt(5, j.getId());
            ste.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update erreur");

        }
    }

    public void updateetatjardin(int id, String etat) {
        try {
            String req = "UPDATE jarenfant SET etat=? WHERE id=?";

            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);

            ste.setString(1, etat);
            ste.setInt(2, id);

            ste.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update erreur");
            System.out.println(e);

        }
    }
    /**
     String selectSQL = "SELECT USER_ID, USERNAME FROM DBUSER WHERE USER_ID = ?";
PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
preparedStatement.setInt(1, 1001);
     
     */
     public int getStat(String e) {
         int i=-1;
try {
            
            String req = "SELECT COUNT(*) as nb FROM jarenfant where etat = ?";
PreparedStatement st = cnx.prepareStatement(req);
st.setString(1, e);

            System.out.println("requete preparer");
            ResultSet rs2 = st.executeQuery();
            System.out.println("Affichage Done");

            while (rs2.next()) {
               i = rs2.getInt("nb");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return i ;
    }
          public int getmesStat(String e,int p) {
         int i=-1;
try {
            
            String req = "SELECT COUNT(*) as nb FROM jarenfant where etat = ? and proprietaire = ?";
PreparedStatement st = cnx.prepareStatement(req);
st.setString(1, e);
st.setInt(2, p);

            System.out.println("requete preparer");
            ResultSet rs2 = st.executeQuery();
            System.out.println("Affichage Done");

            while (rs2.next()) {
               i = rs2.getInt("nb");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return i ;
    }
     

}
