/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjala.examples.taskmaster.managers;

import java.util.List;
import javax.ejb.Stateless;
import org.fjala.examples.taskmaster.model.UserAccount;

/**
 *
 * @author rockfer
 */
@Stateless
public class UserAccountManager {
    
    public UserAccount registerAccount(UserAccount account) {
        return account;
    }
    public List<UserAccount> getAllUsers(){
        return null;
    }
}
