/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import entities.CustomUser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * @author Radhi
 */
public class FB {
    
    public static void publish(String s) throws FileNotFoundException  {
        
        String MY_APP_ID = "339743583185311";
        String MY_APP_SECRET = "c4678b604004fd378b4d838993de2dbf";
        String MyAccessToken = "EAAE0ZCreXKZA8BAE0LCNlLOZBq8EyxMim2Jr3zAM2eBTGh9iOzODyzWuBJQLiZCQ0wnraTwA85PfpOFMoMrteZA7eVlHmIZBbapqFruM6kPBQp4gMYD2DYH61qjyYaBHKlD0ZCQrp33DUC36phOmDnEGemPHREORYbKBXrcnFRcwv6DaKTmjrqtAZBTGRwV0ZAJgZD";

        //AccessToken accessToken = new DefaultFacebookClient().obtainAppAccessToken(MY_APP_ID, MY_APP_SECRET);
        DefaultFacebookClient facebookClient = new DefaultFacebookClient(MyAccessToken);
        String fbMessage = "Hello from java!";
        FileInputStream fb = new FileInputStream("C:\\xampp\\htdocs\\datatable_21\\web\\"+s);
        //facebookClient.publish("me/feed", FacebookType.class, Parameter.with("message", fbMessage));
        facebookClient.publish("me/photos", FacebookType.class,
               BinaryAttachment.with("jpg",fb ),
                Parameter.with("message",  "\n#PI_DEV\n#ESPRIT"));
        
         CustomUser user = facebookClient.fetchObject("me", CustomUser.class,
               Parameter.with("fields",
                       "id, name, email, first_name, last_name"));
 
        System.out.println("First Name= " + user.getFirstName());
        System.out.println("Last Name= " + user.getLastName());
        System.out.println("Full Name= " + user.getFullName());
        System.out.println("Email= " + user.getEmail());

        
        
    }
    
    
    
   
    
}