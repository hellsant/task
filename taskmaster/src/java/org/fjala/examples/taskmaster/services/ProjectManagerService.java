/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjala.examples.taskmaster.services;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.fjala.examples.taskmaster.managers.ProjectManager;

/**
 *
 * @author douglas
 */
@ManagedBean
@RequestScoped
public class ProjectManagerService {

    @EJB
    private ProjectManager manager;
    @ManagedProperty(value = "#{facesContex}")
    private FacesContext context;

}
