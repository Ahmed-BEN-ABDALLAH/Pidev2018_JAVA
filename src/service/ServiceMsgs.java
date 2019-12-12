/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mysql.jdbc.MySQLConnection;
import entities.Messages;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
public class ServiceMsgs {


    private Connection cnx;
    public static Authentification instance;
    public static User user;

    public ServiceMsgs() {
        cnx = MyConnexion.getInstance()
                .getConnection();

    }

    public void deletemsg(int id) {
        try {
      
      

    
     String req ="DELETE FROM messages WHERE id=" + id;
           // String req = "DELETE FROM messages WHERE id_recepteur=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("supp success");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceMsgs.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println(ex.getMessage());

        }

    }

    public List<Messages> listmsgs(int id) {
        List<Messages> mesmsg = new ArrayList<Messages>();
        try {
 
            String req = "Select * from messages";
            PreparedStatement st = cnx.prepareStatement(req);
            System.out.println("requete preparer");
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                Messages p = new Messages();
                p.id = res.getInt(1);
                p.idEmetteur = res.getInt(2);
                p.id_recepteur = res.getInt(3);
                p.objet = res.getString(4);
                p.contenu_message = res.getString(5);
                mesmsg.add(p);
            }
            System.out.println("aa");
            return mesmsg;

        } catch (Exception e) {
            System.out.println(" erreuuur");
            return null;
        }

    }

    public void addmsg(Messages msg) throws SQLException {
        //
        try {
                    System.out.println(msg);

            String req = "Insert into messages (id_recepteur,idEmetteur,objet,contenu_message)values(?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println("requete preparer");
            ps.setInt(1, msg.getId_recepteur());
            ps.setInt(2, msg.getIdEmetteur());
            ps.setString(3, msg.getObjet());
            ps.setString(4, msg.getContenu_message());
            ps.executeUpdate();
            System.out.println("aa");
        } catch (SQLException ex) {
            System.out.println(" erreuuur");
        }

    }

}
