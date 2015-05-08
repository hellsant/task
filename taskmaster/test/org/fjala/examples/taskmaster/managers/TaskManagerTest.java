/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjala.examples.taskmaster.managers;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.fjala.examples.taskmaster.model.Task;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author douglas
 */
public class TaskManagerTest {

    @Mock
    private EntityManager entityManager;
    
    @InjectMocks
    private TaskManager manager;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testAddTask() {
        Task task = new Task();
        task.setTitle("name");
        task.setDescription("description");
        boolean isAdded = manager.addTask(task);
        verify(entityManager).persist(eq(task));
        assertTrue(isAdded);
    }
    
    @Test
    public void testGetAllTask(){
        
        List<Task> tasks = new ArrayList();
        
        Task task1 = new Task();
        task1.setTitle("name");
        task1.setDescription("description");
        Task task2 = new Task();
        task2.setTitle("name");
        task2.setDescription("description");
        Task task3 = new Task();
        task3.setTitle("name");
        task3.setDescription("description");
        manager.addTask(task1);
        manager.addTask(task2);
        manager.addTask(task3);
        
        
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        Query expectedQuery = mock(Query.class);
        when(expectedQuery.getResultList()).thenReturn(tasks);
        when(entityManager.createNamedQuery("AllTasks")).thenReturn(expectedQuery);
        List<Task> result = manager.getAllTasks();
        assertEquals(tasks, result);
        
    }
    
//    @Test
//    public void testDeleteTask() {
//        List<Task> tasks = new ArrayList();
//        Task task = new Task();
//        task.setTitle("name");
//        task.setDescription("description");
//        manager.addTask(task);
//        verify(entityManager).persist(eq(task));
//        
//        boolean isRemoved = manager.deleteTask(task);
//        verify(entityManager).remove(eq(task));
//        assertTrue(isRemoved); 
//        
//    }
//    
//    @Test
//    public void testDeleteTaskFromList(){
//        
//        List<Task> tasks = new ArrayList();
//        
//        Task task1 = new Task();
//        task1.setTitle("name1");
//        task1.setDescription("description1");
//        Task task2 = new Task();
//        task2.setTitle("name2");
//        task2.setDescription("description2");
//        Task task3 = new Task();
//        task3.setTitle("name3");
//        task3.setDescription("description3");
//        manager.addTask(task1);
//        manager.addTask(task2);
//        manager.addTask(task3);
//        
//        manager.deleteTask(task2);
//        
//        tasks.add(task1);
//        tasks.add(task3);
//        
//        
//        Query expectedQuery = mock(Query.class);
//        //when(expectedQuery.getResultList()).thenReturn(tasks);
//        when(entityManager.createNamedQuery("AllTasks")).thenReturn(expectedQuery);
//        List<Task> result = manager.getAllTasks();
//        assertEquals(tasks, result);
//        
//    }
    
}
