/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservicebabysitter;

import entities.User;
import entities.baby;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ghada
 */
public interface babysitterinterface {
    
     public void updatebaby(baby b) throws SQLException;
       public  void ajouterP (baby p);
        public void SupprimerBaby(baby b);
         public List<baby> Afficherbaby();
          public List<baby> Affichermesbaby();
           public int verifavis(int idb) throws SQLException ;
           public int nbrelike(int idb);
           public int  nbredislike(int idb);
           public List<baby> top10baby();
          public int verifavis1(int  idb) throws SQLException ;
            public User AfficherProfil();
              public void updatProfil(User b) throws SQLException;
    
}
