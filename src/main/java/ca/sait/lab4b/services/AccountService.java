
package ca.sait.lab4b.services;

import ca.sait.lab4b.models.User;

/**
 *
 * @author Administrater
 */
public class AccountService {
    
    // to do login check/username and password check
    public User login(String username, String password){
        if(username.equals("abe") && password.equals("password")){
            return new User(username, null);
        }else if(username.equals("barb") && password.equals("password")){
            return new User(username, null); 
        }else{
            return null;
        }
        
        
    }
    
}
