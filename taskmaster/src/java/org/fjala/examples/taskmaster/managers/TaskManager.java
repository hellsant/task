/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjala.examples.taskmaster.managers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.fjala.examples.taskmaster.model.Task;

/**
 *
 * @author douglas
 */
@Stateless

public class TaskManager {

    private EntityManager entityManager;

    public void setEntityManager(EntityManager manager) {
        entityManager = manager;
    }

    public boolean addTask(Task task) {
        entityManager.persist(task);
        return true;
    }

    public List<Task> getAllTasks() {
        return entityManager.createNamedQuery("AllTasks").getResultList();
    }

//    public boolean deleteTask(Task task) {
//        entityManager.remove(task);
//        return true;
//    }

}
