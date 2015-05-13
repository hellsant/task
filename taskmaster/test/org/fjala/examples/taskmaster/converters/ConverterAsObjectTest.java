/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjala.examples.taskmaster.converters;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.fjala.examples.taskmaster.model.UserAccount;
import org.fjala.examples.taskmaster.services.ProjectService;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author douglas
 */
public class ConverterAsObjectTest {
    
    
    @Mock
    private FacesContext facesContex;
    @Mock
    private Application application;
    @Mock
    private UIComponent component;

    @Before
    public  void setUp(){
        MockitoAnnotations.initMocks(this);
        ProjectService projectService = new ProjectService();
        when(facesContex.getApplication()).thenReturn(application);
        when(application.evaluateExpressionGet(facesContex, "#{projectService}", ProjectService.class)).thenReturn(projectService);
        projectService.init();
    }
    @Test
    public void testGetAsObject() {
        String userName = "Denis Vasquez";
        UserAccountConverterByName converter = new UserAccountConverterByName();
                
        UserAccount user = (UserAccount) converter.getAsObject(facesContex, component, userName);
        UserAccount expectedUser = new UserAccount();
        expectedUser.setId(3);
        expectedUser.setName("Denis");
        expectedUser.setLastName("Vasquez");
        Assert.assertEquals(expectedUser, user);
        
    }

    @Test
    public void testGetAsString() {
        UserAccount user = new UserAccount();
        user.setId(3);
        user.setName("Denis");
        user.setLastName("Vasquez");
        
        UserAccountConverterByName converter = new UserAccountConverterByName();
        
        String userAsString = converter.getAsString(facesContex, component, user);
        String expected = "Denis Vasquez";
        assertEquals(expected, userAsString);
    }
    
}
