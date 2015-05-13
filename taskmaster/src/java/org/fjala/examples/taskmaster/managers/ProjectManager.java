/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjala.examples.taskmaster.managers;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.fjala.examples.taskmaster.model.Project;
import org.fjala.examples.taskmaster.model.UserAccount;

/**
 *
 * @author erika
 */
@Stateless
public class ProjectManager {
    
    private UserAccountManager userManager;

    public List<UserAccount> getUserNotAssignedToProject(Project project) {
        List<UserAccount> allUsers = userManager.getAllUsers();
        List<UserAccount> result = new ArrayList<>();
        
        for (UserAccount user : allUsers) {
            if(!user.getProjects().contains(project)) {
                result.add(user);
            }
        }
        return result;
    }

    public void setUserManager(UserAccountManager userManager) {
        this.userManager = userManager;
    }
}
