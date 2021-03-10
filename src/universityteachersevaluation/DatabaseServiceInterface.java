/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.Evaluation;
import Models.LevelOfEducation;
import Models.Service;
import Models.ServiceCategory;
import Models.Task;
import Models.Teacher;
import Models.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author kk
 */

//Database service interface for handling all the requests
//contains the functions to override when implemented
public interface DatabaseServiceInterface extends Remote {

    //create an interface
    public void addTeacher(Teacher teacher) throws RemoteException;
    public void addServiceCategory(ServiceCategory serviceCategory) throws RemoteException;
    public void addService(Service service) throws RemoteException;
    public void addTask(Task task) throws RemoteException;
    public List<Teacher> getTeachers() throws RemoteException;
    public ResultSet getTeachersRs() throws RemoteException;
    public List<ServiceCategory> getServiceCategories() throws RemoteException;
    public void editServiceCategory(ServiceCategory serviceCategory) throws RemoteException;
    public List<Service> getServices(int id) throws RemoteException;
    public void editService(Service service) throws RemoteException;
    public void deleteService(int id) throws RemoteException;
    public void editTeacher(Teacher teacher) throws RemoteException;
    public void deleteServiceCategory(int id) throws RemoteException;
    public void deleteTeacher(int id) throws RemoteException;
    public void deleteTask(int id) throws RemoteException;
    public void editTask(Task task) throws RemoteException;
    public List<Task> getDoneTasks() throws RemoteException;
    public List<Task> getAssignedTasks() throws RemoteException;
    public List<Task> getDoneTeacherTasks(int id) throws RemoteException;
    public List<Task> getAssignedTeacherTasks(int id) throws RemoteException;
    public List<LevelOfEducation> getLevelOfEds() throws RemoteException;
    public List<Evaluation> getEvaluations() throws RemoteException;
    public void addEvaluation(Evaluation evaluation) throws RemoteException;
    public List<Service> searchService(String searchName , int id) throws RemoteException;
    public Service getServiceByTaskId( int id) throws RemoteException;
    public List<Teacher> searchTeachers(String searchString) throws RemoteException;
    public List<ServiceCategory> searchServiceCategoriies(String searchString) throws RemoteException;
    public LevelOfEducation getLevelById(int id) throws RemoteException;
    public User getUserByEmail(String email) throws RemoteException;
    public void changePassword(String password , int id) throws RemoteException;
    public List<Service> getAllServices() throws RemoteException;
}
