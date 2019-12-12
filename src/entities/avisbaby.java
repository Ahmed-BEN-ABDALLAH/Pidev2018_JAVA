/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ghada
 */
public class avisbaby {

    public avisbaby(int idu, int idb, int nbrdislike, int nbrlike, int moyenne) {
        this.idu = idu;
        this.idb = idb;
        this.nbrdislike = nbrdislike;
        this.nbrlike = nbrlike;
        this.moyenne = moyenne;
    }

    public avisbaby() {
    }
    
       private int id;
    private int idu;
    private int idb ;
    private int nbrdislike ;
    private int nbrlike ;
        private int moyenne ;

    public int getNbrlike() {
        return nbrlike;
    }

    public void setNbrlike(int nbrlike) {
        this.nbrlike = nbrlike;
    }

    public int getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(int moyenne) {
        this.moyenne = moyenne;
    }


    public int getNbrdislike() {
        return nbrdislike;
    }

    public void setNbrdislike(int nbrdislike) {
        this.nbrdislike = nbrdislike;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public int getIdb() {
        return idb;
    }

    public void setIdb(int idb) {
        this.idb = idb;
    }

    @Override
    public String toString() {
        return "avisbaby{" + "id=" + id + ", idu=" + idu + ", idb=" + idb + ", nbrdislike=" + nbrdislike + ", nbrlike=" + nbrlike + ", moyenne=" + moyenne + '}';
    }

 
    
    
    
}
