/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author AHMED
 */
public class MyConnexion {

     String url="jdbc:mysql://localhost:3306/pidev";//3a22 nom base de données
        String login="root";
            String pwd="";
        private Connection cnx;
        private static MyConnexion instance ;
        
    public MyConnexion(){
        
              try {
             cnx=DriverManager.getConnection(url,login, pwd);
                 System.out.println("connexion établi");   
                   System.out.println("*******************");       
                
                    // TODO code application logic here
                    } catch (SQLException ex) {
                        
            Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
       
                    }
    
    
    }
    
    
    
    public static MyConnexion getInstance() {
        
        if (instance==null)
            instance =new MyConnexion();
        return instance ;
    }
    
    
    public Connection getConnection(){
        
                    return cnx;
   
    }
    
    
}
