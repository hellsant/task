/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjala.examples.taskmaster.managers;

import org.fjala.examples.taskmaster.model.UserAccount;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rockfer
 */
public class UserAccountManagerTest {
    
    @Test
    public void testRegisterAccount() {
        UserAccountManager userAccountManager = new UserAccountManager();
        UserAccount account = new UserAccount();
        account.setName("pepe");
        account.setLastName("perez");
        account.setEmail("pepe@gmail.com");
        account.setPassword("111");
        
        UserAccount registeredAccount = userAccountManager.registerAccount(account);
        
        assertTrue(registeredAccount.getId() > 0);
    }
    
}
