/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.Account;

/**
 *
 * @author Sap-lap
 */
public class AccountDAO {
    public Account getAccount(String username, String password)
    {
        if(username.equals("sonnt") && password.equals("123"))
        {
            Account account = new Account();
            account.setPassword(password);
            account.setUsername(username);
            return account;
        }
        return null;
    }
    //test commit
    //test commit
    
    //test commit
}
