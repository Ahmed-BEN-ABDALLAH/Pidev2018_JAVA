/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;


import java.sql.Date;

/**
 *
 * @author walid
 */
public class User {
      private static int id_courant_user ;

    public static int getId_courant_user() {
        return id_courant_user;
    }

    public static void setId_courant_user(int id_courant) {
        User.id_courant_user = id_courant;
    }
    public static User connectedUser;
    
    private int id;

    
    private String username;
    private String username_canonical ;
    private String email;
    
    private int  enabled;
private String email_canonical;
private String salt;
private String password;
private Date last_login;
private String confirmation_token;
private Date password_requested_at;

    private String roles;
    private String nom;
    private String prenom;
    private String image;
    private String adrese;
    private String facebook_id;
    private String google_id;
    private int numtel;
    private int prix;

    private String description;

    public User() {
    }

    public User(int id, String username, String username_canonical, String email, int enabled, String email_canonical, String salt, String password, Date last_login, String confirmation_token, Date password_requested_at, String roles, String nom, String prenom, String image, String adrese, String facebook_id, String google_id, int numtel, int prix, String description) {
        this.id = id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.enabled = enabled;
        this.email_canonical = email_canonical;
        this.salt = salt;
        this.password = password;
        this.last_login = last_login;
        this.confirmation_token = confirmation_token;
        this.password_requested_at = password_requested_at;
        this.roles = roles;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
        this.adrese = adrese;
        this.facebook_id = facebook_id;
        this.google_id = google_id;
        this.numtel = numtel;
        this.prix = prix;
        this.description = description;
    }

    
    
    
    public static User getConnectedUser() {
        return connectedUser;
    }

    public static void setConnectedUser(User connectedUser) {
        User.connectedUser = connectedUser;
    }

    public User(int id, String username, String email, String password, String nom, String prenom ,String roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.roles=roles;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public Date getPassword_requested_at() {
        return password_requested_at;
    }

    public void setPassword_requested_at(Date password_requested_at) {
        this.password_requested_at = password_requested_at;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAdrese() {
        return adrese;
    }

    public void setAdrese(String adrese) {
        this.adrese = adrese;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getGoogle_id() {
        return google_id;
    }

    public void setGoogle_id(String google_id) {
        this.google_id = google_id;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "fos_user{" + "id=" + id + ", username=" + username + ", email=" + email + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", roles=" + roles + ", nom=" + nom + ", prenom=" + prenom + ", image=" + image + ", adrese=" + adrese + ", numtel=" + numtel + '}';
    }
  
  

    
}
