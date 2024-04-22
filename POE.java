/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;

import javax.swing.JOptionPane;

/**
 *
 * @author Mdhluli
 */
public class POE 
{        
    public static void main(String[] args) 
    {     
       part1 mv = new part1();
       //mv.UsernameRegister();
       mv.registerUser();
    }
}   
    
class part1 extends POE
{    
    //username variables
    public String usernameMessageTrue = "Username successfully captured";
    public String usernameMessageFalse = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length";    
    public String username1;
    public String password1;
    
    //password variables
    public String passwordMessageTrue = "Password successfully captured";
    public String passwordMessageFalse = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character";
    public String SpecialChara = "! @ # $ % ^ & * ( ) ? < > { } [ ] + - / ";
    
    //Names variables
    public String name;
    public String lastName;
    
    //login variables
    public String trueMessage = "Welcome "+ name + "," + lastName + "it is great to see you again";
    public String falseMessage = "Username or password incorrect, please try again";
    
    //register username here    
    public String registerUser()
    {
      name = JOptionPane.showInputDialog("Please enter your name"); 
      lastName = JOptionPane.showInputDialog("Please enter your last name");
      
      while(true)
      {
        username1 = JOptionPane.showInputDialog("Please create username(username must have an underscore and be 5 characters long)");
           
        boolean user = checkUserName(username1);
      
        if(user)
        {
         JOptionPane.showMessageDialog(null, usernameMessageTrue);
         break;
        }
        else
        {
         JOptionPane.showMessageDialog(null, usernameMessageFalse);      
        } 
                 
      }
      PasswordMaker();
        return null;
    }
    
    public boolean checkUserName(String username1)
    {       
       return username1.contains("_") && username1.length() <= 5;   
    }
    
    public void PasswordMaker()
    {
       while(true)
        {
        //password input
         password1 = JOptionPane.showInputDialog("Please create password(password must have a capital letter, a special character [ "+ SpecialChara +" ], a number and be atleast 8 characters long)");
            
         boolean pass = checkPasswordComplexity(password1);
         
         //return statements for password
         if(pass)
         {
           JOptionPane.showMessageDialog(null, passwordMessageTrue);
           break;
         }
         else
         {
          JOptionPane.showMessageDialog(null, passwordMessageFalse);         
         }
         
        }
       returnLoginStatus();
    }
    
    //password is checked here
    public boolean checkPasswordComplexity(String password1)
    {        
       boolean numCheck = false;
       boolean CapsCheck = false;
       boolean Specials = false;
             
       //for loop will check the password to see if all conditions are met then will return results
       for (char I : password1.toCharArray())
       {        
        //Capital lettter check
        if(Character.isUpperCase(I))        
        {                       
           CapsCheck = true;
        }  
        //password number check
        if(Character.isDigit(I))
        {
          numCheck  = true;              
        }
        //Special characters check
        if(SpecialChara.contains(Character.toString(I)))
        {
          Specials = true;        
        }
        
       }
       
       return CapsCheck && numCheck && Specials && password1.length() >= 8;
       
    }   
    
    public String returnLoginStatus()
    {
       while(true)
        {      
         //user must re-enter username and password
         String Username2 = JOptionPane.showInputDialog("Please re-enter Username");
         String password2 = JOptionPane.showInputDialog("Please re-enter password");
      
         
          //return statements here
          boolean Login = LoginUser(Username2, password2);  
          if(Login)
          {
            //declaring message here otherwise names will not show
            trueMessage = "Welcome "+ name + lastName + ", it is great to see you again!";  
            JOptionPane.showMessageDialog(null, trueMessage);
            break;
          }
          else
          {
           JOptionPane.showMessageDialog(null, falseMessage);
           returnLoginStatus();
          }               
        }
       
        return null; 
        
    }
    
    //username and password are checked here
    public boolean LoginUser(String Username2,String password2)
    {
       return Username2.equals(username1) && password2.equals(password1);
    }    
}





