/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
 
public class SendEmail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
 
String to = "nivesmailbox@gmail.com";
String from = "bumbleshines24@gmail.com";

 Properties properties = new Properties();
properties.put("mail.smtp.auth","true");
properties.put("mail.smtp.starttls.enable","true");
properties.put("mail.smtp.host","smtp.gmail.com");
properties.put("mail.smtp.port","587");


Session session;
        session = Session.getDefaultInstance(properties,new javax.mail.Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("bumbleshines24@gmail.com","BUMBLE123");
            }
        });
try
{
MimeMessage message=new MimeMessage(session);
message.setFrom(new InternetAddress(from));
message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
message.setSubject("WELCOME TO BUMBLE LIBRARY");
message.setText("Read anytime ! anywhere !");
Transport.send(message);
System.out.println("sent message successfully...");
}
catch(MessagingException mex)
{
	mex.printStackTrace();
} 
        // TODO code application logic here
    }
    
}
