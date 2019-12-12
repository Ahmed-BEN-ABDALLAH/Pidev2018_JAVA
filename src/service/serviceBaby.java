/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.User;
import entities.avisbaby;
import entities.baby;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Authentification;

import iservicebabysitter.babysitterinterface;
import util.MyConnexion;

/**
 *
 * @author ghada
 */
public class serviceBaby implements babysitterinterface{

  
 private final User currentUser=Authentification.user;
    public static baby GetBabybyid(int id_courant) {

      baby bb = new baby();
        try {
            //-------------------- Update ----------//
      
            
            String query = "select * from baby where id = ? ";
            PreparedStatement ps;
            
            ps = MyConnexion.getInstance().getConnection().prepareCall(query);
            ps.setInt(1, id_courant);
            ResultSet rest=  ps.executeQuery();
            
            
            while(rest.next())
            {
                
                
                bb.setId(rest.getInt("id"));
                bb.setNom(rest.getString("nom"));
                bb.setPrenom(rest.getString("prenom"));
                bb.setAdrese(rest.getString("adrese")); 
                 bb.setNumtel(rest.getInt("numtel"));
                
                   bb.setPrix(rest.getInt("prix")); 
                     bb.setEmail(rest.getString("email")); 
                       bb.setDescription(rest.getString("description")); 
                         bb.setDisponibilite(rest.getDate("disponibilite")); 
                           bb.setDatefin(rest.getDate("datefin"));
                           bb.setImage(rest.getString("image"));
                           bb.setLongitude(rest.getDouble("longitude"));
                           bb.setLatitude(rest.getDouble("latitude"));
            }
            
            
     
        } catch (SQLException ex) {
            Logger.getLogger(serviceBaby.class.getName()).log(Level.SEVERE, null, ex);
        }

       return bb;

    }


   
    
    
 @Override
      public void updatebaby(baby b) throws SQLException{
                        //-------------------- Update ----------//

                String reqUp="update baby set nom=?,prenom=?,adrese=?,disponibilite=?,email=?,prix=?,description=?,datefin=?,numtel=?,image=? where id=?";
                    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);

                    
    pss.setString(1,b.getNom());
            pss.setString(2,b.getPrenom());
            pss.setString(3,b.getAdrese());
            pss.setDate(4,b.getDisponibilite());
              
            pss.setString(5,b.getEmail());
            pss.setInt(6,b.getPrix());
            pss.setString(7,b.getDescription());
            pss.setDate(8, b.getDatefin());
            pss.setInt(9,b.getNumtel());
            pss.setString(10,b.getImage());
            pss.setInt(11,b.getId());

            pss.executeUpdate();

      
      }
    
    
    
    
    
    
 @Override
    public  void ajouterP (baby p){
    
        try {
            String req = " insert into baby (id,nom,prenom,adrese,disponibilite,idb,email,prix,description,datefin,numtel,image,etat,longitude,latitude) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps= MyConnexion.getInstance().getConnection().prepareStatement(req);
             ps.setInt(1, p.id);
            ps.setString(2,p.nom);
            ps.setString(3,p.prenom);
            ps.setString(4,p.adrese);
             ps.setDate(5, p.disponibilite);
              ps.setInt(6,p.idb);
               ps.setString(7,p.email);
               ps.setInt(8,p.prix);
               ps.setString(9,p.description);
                ps.setDate(10, p.datefin);
                  ps.setInt(11,p.numtel);
                   ps.setString(12,p.image);
                         ps.setString(13,p.etat);
                ps.setDouble(14,p.longitude);
                     ps.setDouble(15,p.latitude);
           
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceBaby.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
                 
                 
    }

    
    
 @Override
        public void SupprimerBaby(baby b)
    {
        try {
            String query = "delete from baby where id = ? ";
            PreparedStatement ps;
            
            ps = MyConnexion.getInstance().getConnection().prepareCall(query);
            ps.setInt(1, b.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceBaby.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    
 @Override
    public List<baby> Afficherbaby()
    {           List Allbabies = new ArrayList();

        
        try {
        
        String query="select * from baby";
        Statement st= MyConnexion.getInstance().getConnection().createStatement();
        ResultSet rest = st.executeQuery(query);
        while(rest.next())
        {
            
            baby b  = new baby();
            
            b.setId(rest.getInt("id"));
            b.setNom(rest.getString("nom"));
            b.setPrenom(rest.getString("prenom"));
            b.setAdrese(rest.getString("adrese"));
           // b.setDisponibilite(rest.getDate("disponibilite"));
            b.setEmail(rest.getString("email"));
            b.setPrix(rest.getInt("prix"));
           // b.setDescription(rest.getString("description"));
           // b.setDatefin(rest.getDate("datefin"));
            b.setNumtel(rest.getInt("numtel"));
                   b.setImage(rest.getString("image"));
//                   System.out.println(b.getImage());
                        Allbabies.add(b);
            
            
            
            
     
            
        }   } catch (SQLException ex) {                 
            Logger.getLogger(serviceBaby.class.getName()).log(Level.SEVERE, null, ex);
        }
                   return Allbabies;     
    }
    
    
    
 @Override
        public List<baby> Affichermesbaby()
    {           List Allbabies = new ArrayList();

        
        try {
        
        String query="select * from baby where idb="+currentUser.getId();
        Statement st= MyConnexion.getInstance().getConnection().createStatement();
        ResultSet rest = st.executeQuery(query);
        baby b1  = new baby();

        while(rest.next())
        {
            
            
            baby b  = new baby();
            b.setId(rest.getInt("id"));
            System.out.println(b.getId());
            b.setNom(rest.getString("nom"));
            b.setPrenom(rest.getString("prenom"));
            b.setAdrese(rest.getString("adrese"));
           // b.setDisponibilite(rest.getDate("disponibilite"));
            b.setEmail(rest.getString("email"));
            b.setPrix(rest.getInt("prix"));
           // b.setDescription(rest.getString("description"));
           // b.setDatefin(rest.getDate("datefin"));
            b.setNumtel(rest.getInt("numtel"));
                   b.setImage(rest.getString("image"));
//                   System.out.println(b.getImage());

                        Allbabies.add(b);
            
            
            
            
     
            
        } 
        } catch (SQLException ex) {                 
            Logger.getLogger(serviceBaby.class.getName()).log(Level.SEVERE, null, ex);
        }
                   return Allbabies;     
    }

 @Override
    public int verifavis(int idb) throws SQLException {

        
                List <avisbaby> avisbaby = new ArrayList();

        
        try {
        
        String query="select * from avisbaby where idu="+currentUser.getId()+" AND idb="+idb;
        Statement st= MyConnexion.getInstance().getConnection().createStatement();
        ResultSet rest = st.executeQuery(query);
     

        while(rest.next())
        {
            
               avisbaby b  = new avisbaby();
      
            b.setId(rest.getInt("id"));

            b.setIdb(rest.getInt("idb"));
            b.setIdu(rest.getInt("idu"));
            b.setMoyenne(rest.getInt("moyenne"));
            b.setNbrlike(rest.getInt("nbrlike"));
            b.setNbrdislike(rest.getInt("nbrdislike"));


                        avisbaby.add(b);
             } 
        } catch (SQLException ex) {                 
            Logger.getLogger(serviceBaby.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        System.out.println(avisbaby.toString());
        if (avisbaby.size()>0)
        {
            if(avisbaby.get(0).getNbrlike()==1)
                {
                    System.out.println("mawjoud liked");
                
                return 0;
                }
            else if (avisbaby.get(0).getNbrlike()==0)
            {
                    String reqUp="update avisbaby set nbrdislike=?,nbrlike=?,moyenne=? where idu=? AND idb=?";
                    PreparedStatement ps = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);
                    ps.setInt(1,0);
                    ps.setInt(2,1);
                    ps.setInt(3, 1);
                    ps.setInt(4, currentUser.getId());
                    ps.setInt(5, idb);

    ps.executeUpdate();
    
     System.out.println("updated");
 return 1;
 }
    }
        else{
            
             try {
            String req = " insert into avisbaby (idu,idb,nbrdislike,nbrlike,moyenne) values (?,?,?,?,?)";
            PreparedStatement ps= MyConnexion.getInstance().getConnection().prepareStatement(req);
             ps.setInt(1,currentUser.getId());
             ps.setInt(2, idb);
             ps.setInt(3, 0);
                 ps.setInt(4, 1);
             ps.setInt(5,1);
           
            ps.executeUpdate();
            
             System.out.println("insert intooooooo");
             return 2;
        } catch (SQLException ex) {
            Logger.getLogger(serviceBaby.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        }
      return 0;
    }


 @Override
    public int nbrelike(int idb) {


                List <avisbaby> avisbaby = new ArrayList();

        
        try {
        
        String query="select * from avisbaby where nbrlike="+1+" AND idb="+idb;
        Statement st= MyConnexion.getInstance().getConnection().createStatement();
        ResultSet rest = st.executeQuery(query);
     

        while(rest.next())
        {
            
               avisbaby b  = new avisbaby();
      
            b.setId(rest.getInt("id"));

            b.setIdb(rest.getInt("idb"));
            b.setIdu(rest.getInt("idu"));
            b.setMoyenne(rest.getInt("moyenne"));
            b.setNbrlike(rest.getInt("nbrlike"));
            b.setNbrdislike(rest.getInt("nbrdislike"));


                        avisbaby.add(b);
             } 
        } catch (SQLException ex) {                 
            Logger.getLogger(serviceBaby.class.getName()).log(Level.SEVERE, null, ex);
        }
     
return avisbaby.size();
    }
        
 @Override
    public int  nbredislike(int idb) {


                List <avisbaby> avisbaby = new ArrayList();

        
        try {
        
        String query="select * from avisbaby where nbrdislike="+1+" AND idb="+idb;
        Statement st= MyConnexion.getInstance().getConnection().createStatement();
        ResultSet rest = st.executeQuery(query);
     

        while(rest.next())
        {
            
               avisbaby b  = new avisbaby();
      
            b.setId(rest.getInt("id"));

            b.setIdb(rest.getInt("idb"));
            b.setIdu(rest.getInt("idu"));
            b.setMoyenne(rest.getInt("moyenne"));
            b.setNbrlike(rest.getInt("nbrlike"));
            b.setNbrdislike(rest.getInt("nbrdislike"));


                        avisbaby.add(b);
             } 
        } catch (SQLException ex) {                 
            Logger.getLogger(serviceBaby.class.getName()).log(Level.SEVERE, null, ex);
        }
     
return avisbaby.size();
    }

 @Override
    public List<baby> top10baby() {
        
             List <baby> allbaby = Afficherbaby();
             List <baby> top3baby = new ArrayList();
             
       for (baby b:allbaby )
        {
            b.setMoyenne(nbrelike(b.getId())-nbredislike(b.getId()));
      
        }
        allbaby.sort((t, t1) -> {
            
            return t1.getMoyenne()-t.getMoyenne(); //To change body of generated lambdas, choose Tools | Templates.
        });
        
        
        
       for (int i=0;i<3;i++)
        {
            
            top3baby.add(allbaby.get(i));

            
        }
          
        return top3baby;
        
    }

 @Override
    public int verifavis1(int  idb) throws SQLException {
{

        
                List <avisbaby> avisbaby = new ArrayList();

        
        try {
        
        String query="select * from avisbaby where idu="+currentUser.getId()+" AND idb="+idb;
        Statement st= MyConnexion.getInstance().getConnection().createStatement();
        ResultSet rest = st.executeQuery(query);
     

        while(rest.next())
        {
            
               avisbaby b  = new avisbaby();
      
            b.setId(rest.getInt("id"));

            b.setIdb(rest.getInt("idb"));
            b.setIdu(rest.getInt("idu"));
            b.setMoyenne(rest.getInt("moyenne"));
            b.setNbrlike(rest.getInt("nbrlike"));
            b.setNbrdislike(rest.getInt("nbrdislike"));


                        avisbaby.add(b);
             } 
        } catch (SQLException ex) {                 
            Logger.getLogger(serviceBaby.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        System.out.println(avisbaby.toString());
        if (avisbaby.size()>0)
        {
            if(avisbaby.get(0).getNbrdislike()==1)
                {
                    System.out.println("mawjoud liked");
                
                return 0;
                }
            else if (avisbaby.get(0).getNbrdislike()==0)
            {
                    String reqUp="update avisbaby set nbrdislike=?,nbrlike=?,moyenne=? where idu=? AND idb=?";
                    PreparedStatement ps = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);
                    ps.setInt(1,1);
                    ps.setInt(2,0);
                    ps.setInt(3, 1);
                    ps.setInt(4, currentUser.getId());
                    ps.setInt(5, idb);

    ps.executeUpdate();
    
     System.out.println("updated");
 return 1;
 }
    }
        else{
            
             try {
            String req = " insert into avisbaby (idu,idb,nbrdislike,nbrlike,moyenne) values (?,?,?,?,?)";
            PreparedStatement ps= MyConnexion.getInstance().getConnection().prepareStatement(req);
             ps.setInt(1,currentUser.getId());
             ps.setInt(2, idb);
             ps.setInt(3, 1);
                 ps.setInt(4,0);
             ps.setInt(5,1);
           
            ps.executeUpdate();
            
             System.out.println("insert intooooooo");
             return 2;
        } catch (SQLException ex) {
            Logger.getLogger(serviceBaby.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        }
      return 0;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    }
        

    
 @Override
  public User AfficherProfil(){
    {           List Allbabies = new ArrayList();

         User b  = new User();
        try {
        
        String query="select * from fos_user where id="+currentUser.getId();
        Statement st= MyConnexion.getInstance().getConnection().createStatement();
        ResultSet rest = st.executeQuery(query);
//        baby b1  = new baby();

        while(rest.next())
        {
            
            
           
            b.setNom(rest.getString("nom"));
//            b.setPrenom(rest.getString("prenom"));
           // b.setDisponibilite(rest.getDate("disponibilite"));
            b.setEmail(rest.getString("email"));
            b.setNumtel(rest.getInt("numtel"));

             b.setAdrese(rest.getString("adrese"));
            b.setDescription(rest.getString("description"));

            b.setPrix(rest.getInt("prix"));
           // b.setDatefin(rest.getDate("datefin"));
            b.setImage(rest.getString("image"));
//                   System.out.println(b.getImage());
//                        Allbabies.add(b);
            
            
                        
                        
                        
                        
                        
            
        } 
        } catch (SQLException ex) {                 
            Logger.getLogger(serviceBaby.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
         return b;  
    }

                     




  }



 @Override
  public void updatProfil(User b) throws SQLException{
                        //-------------------- Update ----------//

                String reqUp="update fos_user set nom=?,prenom=?,image=?,adrese=?,description=?,numtel=?,prix=? where id=?";
                    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);

                    
    pss.setString(1,b.getNom());
     pss.setString(2,b.getPrenom());
//       pss.setString(3,b.getEmail());
              pss.setString(3,b.getImage());
            pss.setString(4,b.getAdrese());
           
            pss.setString(5,b.getDescription());

              pss.setInt(6,b.getNumtel());
               pss.setInt(7,b.getPrix());
                 
              pss.setInt(8,currentUser.getId());
      System.out.println(b.getPrix());
      System.out.println(currentUser.getId());
      

    

    pss.executeUpdate();



}

                   
                   
                   public void approuver(baby e) throws SQLException{
                        //-------------------- Update ----------//

                String reqUp="update baby set etat=? where id=?";
                    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);
    
     pss.setString(1,e.getEtat());
      
     pss.setInt(2,e.getId());
    
    pss.executeUpdate();

}
                   
                   
                         
                   public void desapprouver(baby e) throws SQLException{
                        //-------------------- Update ----------//

                String reqUp="update baby set etat=? where id=?";
                    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);
    
     pss.setString(1,e.getEtat());
     
     pss.setInt(2,e.getId());
    
    pss.executeUpdate();

}


}


    
