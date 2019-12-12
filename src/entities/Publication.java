/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ikbel
 */
public class Publication {
    

   

private int id;
    

    private int id_categorie;

    private String titre_qestion;

    private int nbr_vue;

    private int created;

    private int nbrReponse;

    private int iduser;

    private String location;

    private String contenu;
    
     private int idcategorie;

    private String pieceJointe;

    private int id_reponse;
  
    private int resolu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

   

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getTitre() {
        return titre_qestion;
    }

    public void setTitre(String titre_qestion) {
        this.titre_qestion = titre_qestion;
    }

    public int getNbr_vue() {
        return nbr_vue;
    }

    public void setNbr_vue(int nbr_vue) {
        this.nbr_vue = nbr_vue;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getNbrReponse() {
        return nbrReponse;
    }

    public void setNbrReponse(int nbrReponse) {
        this.nbrReponse = nbrReponse;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getPieceJointe() {
        return pieceJointe;
    }

    public void setPieceJointe(String pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public int getResolu() {
        return resolu;
    }

    public void setResolu(int resolu) {
        this.resolu = resolu;
    }

    public Publication() {
    }

    public Publication(int id_user, int id_categorie, int idcategorie, String titre_qestion, int nbr_vue, int created, int nbrReponse, String location, String contenu) {
        this.iduser=id_user;
        this.id_categorie=id_categorie;
        this.idcategorie=idcategorie;
        this.titre_qestion = titre_qestion;
        this.nbr_vue = nbr_vue;
        this.created = created;
        this.nbrReponse = nbrReponse;
        this.location = location;
        this.contenu = contenu;
    }

    public Publication(String titre_qestion, int nbr_vue, int created, int nbrReponse, String location, String contenu, int resolu) {
        this.titre_qestion = titre_qestion;
        this.nbr_vue = nbr_vue;
        this.created = created;
        this.nbrReponse = nbrReponse;
        this.location = location;
        this.contenu = contenu;
        this.resolu = resolu;
    }

    
    public Publication(int id_categorie, String titre_qestion, int nbr_vue, int created, int nbrReponse, String location, String contenu) {
        this.id_categorie=id_categorie;
        this.titre_qestion = titre_qestion;
        this.nbr_vue = nbr_vue;
        this.created = created;
        this.nbrReponse = nbrReponse;
        this.location = location;
        this.contenu = contenu;
    }
        public Publication(int id,int id_categorie, String titre_qestion, int nbr_vue, int created, int nbrReponse, String location, String contenu) {
        this.id=id;
            this.id_categorie=id_categorie;
        this.titre_qestion = titre_qestion;
        this.nbr_vue = nbr_vue;
        this.created = created;
        this.nbrReponse = nbrReponse;
        this.location = location;
        this.contenu = contenu;
    }
    

    public Publication(String titre_qestion, int nbr_vue, int created, String location, String contenu, String pieceJointe, int resolu,int nbr_reponse) {
        this.titre_qestion = titre_qestion;
        this.nbr_vue = nbr_vue;
        this.created = created;
        this.location = location;
        this.contenu = contenu;
        this.pieceJointe = pieceJointe;
        this.resolu = resolu;
        this.nbrReponse=nbr_reponse;
    }

    public Publication(String titre_qestion, String location, int nbr_vue, int nbrReponse, String contenu) {
        this.titre_qestion = titre_qestion;
        this.nbr_vue = nbr_vue;
        this.nbrReponse = nbrReponse;
        this.location = location;
        this.contenu = contenu;
    }
    
@Override
    public String toString() {
        return "";
    }

   
    
    
}
