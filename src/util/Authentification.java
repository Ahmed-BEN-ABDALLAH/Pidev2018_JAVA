/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import util.MyConnexion;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kaisser
 */
public class Authentification {
    
    private Connection cnx;
    public static Authentification instance;
    public static User user;
    
    public Authentification()
    {
    cnx=MyConnexion.getInstance().getConnection();
    user=null;
    }
    
    
    public static Authentification getSession()
    {if(instance==null)
    instance=new Authentification();
    return instance;
    }
           
    public boolean login(String name,String pwd){
        System.out.println("hihihihi");
        if (user==null){
             String req = "SELECT * FROM `fos_user` WHERE username=? and password=? ";
             
             try{
                 
                    PreparedStatement ps = cnx.prepareStatement(req);
                    ps.setString(1, name);
                     ps.setString(2, pwd);
                    
                    ResultSet r = ps.executeQuery();

                    if(r.next()){
                        user=new User(r.getInt("id"), r.getString("username"), r.getString("email"), r.getString("password"), r.getString("nom"), r.getString("prenom"),r.getString("roles"));
                        return true;
                    }
                                      
                }
                catch(SQLException ex){
                            System.out.println(ex);

                    return false;
                }
        }
        return false;
    }
    
    public boolean connected(){
        return user!=null;
    }
    
    public void logout(){
        user=null;
    }
    
    public User getUser(){
        if (connected()) return user;
        return null;
    }

    
}
