/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjala.examples.taskmaster.managers;

import java.util.ArrayList;
import java.util.List;
import org.fjala.examples.taskmaster.model.Project;

import org.fjala.examples.taskmaster.model.UserAccount;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author erika
 */
public class ProjectManagerTest {

    @Mock
    private UserAccountManager userManager;

    @InjectMocks
    private ProjectManager projectManager;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserNotAssignedToProject() {
        Project project = new Project();
        project.setId(1);
        project.setName("test");

        List<UserAccount> userList = new ArrayList<>();
        UserAccount user = null;
        user = new UserAccount();
        user.setId(1);
        user.setEmail("user@hotmail.com");
        user.setName("user");
        userList.add(user);
        user = new UserAccount();
        user.setId(2);
        user.setEmail("user2@hotmail.com");
        user.setName("user2");
        userList.add(user);

        user = new UserAccount();
        user.setId(3);
        user.setEmail("user3@hotmail.com");
        user.setName("user3");
        user.getProjects().add(project);
        userList.add(user);

        user = new UserAccount();
        user.setId(4);
        user.setEmail("user4@hotmail.com");
        user.setName("user4");
        user.getProjects().add(project);
        userList.add(user);

        when(userManager.getAllUsers()).thenReturn(userList);

        List<UserAccount> userNotAssigned = projectManager.getUserNotAssignedToProject(project);

        List<UserAccount> expectedList = userList.subList(0, 2);

        assertEquals(expectedList, userNotAssigned);
    }
}
