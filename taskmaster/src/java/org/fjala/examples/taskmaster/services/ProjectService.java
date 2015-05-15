/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjala.examples.taskmaster.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.fjala.examples.taskmaster.managers.ProjectManager;
import org.fjala.examples.taskmaster.model.Project;
import org.fjala.examples.taskmaster.model.UserAccount;

/**
 *
 * @author douglas
 */
@ManagedBean(name = "projectService", eager = true)
@ViewScoped
public class ProjectService implements Serializable {

    @EJB
    private ProjectManager manager;
    @ManagedProperty(value = "#{facesContex}")
    private FacesContext context;

    private Project currentProject;

    private UserAccount memberToAdd;

    private List<UserAccount> availableMembers;

    public UserAccount getMemberToAdd() {
        return memberToAdd;
    }

    public void setMemberToAdd(UserAccount memberToAdd) {
        this.memberToAdd = memberToAdd;
    }

    @PostConstruct
    public void init() {
        currentProject = new Project();
        currentProject.setId(1);
        currentProject.setName("Test");
        availableMembers = listOfMembers();
    }

    public ProjectManager getManager() {
        return manager;
    }

    public void setManager(ProjectManager manager) {
        this.manager = manager;
    }

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

    public void addMemberToProject(ActionEvent event) {
        if(!currentProject.getMembers().contains(memberToAdd)){
            currentProject.getMembers().add(memberToAdd);
        }
    }

    public List<UserAccount> getAvailableMembers(String token) {
        List<UserAccount> acounts = new ArrayList<>();
        for (UserAccount availableMember : availableMembers) {
            if (availableMember.getName().toLowerCase().contains(token)) {
                acounts.add(availableMember);
            }
        }
        return acounts;
    }

    public UserAccount findUserByName(String value) {
        String nameTemplate = "%s %s";
        for (UserAccount member : availableMembers) {
            String name = String.format(nameTemplate, member.getName(), member.getLastName());
            if (name.equals(value)) {
                return member;
            }
        }
        return null;
    }

    private List<UserAccount> listOfMembers() {
        List<UserAccount> membersList = new ArrayList<>();
        UserAccount newUser = new UserAccount();
        newUser.setName("Erika");
        newUser.setLastName("Vargas");
        newUser.setId(1);
        membersList.add(newUser);
        newUser = new UserAccount();
        newUser.setName("Douglas");
        newUser.setLastName("Suarez");
        newUser.setId(2);
        membersList.add(newUser);
        newUser = new UserAccount();
        newUser.setName("Denis");
        newUser.setLastName("Vasquez");
        newUser.setId(3);
        membersList.add(newUser);
        return membersList;
    }
}
