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
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kk
 */


//implementation of the database service interface 
//contains methods to be invocated remotely from client program
class DatabaseService extends UnicastRemoteObject implements DatabaseServiceInterface {

    public DatabaseService() throws RemoteException {
    }

    @Override
    public void addTeacher(Teacher teacher) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        db.insertTeacher(con, teacher);
    }
    
    @Override
    public void addServiceCategory(ServiceCategory serviceCategory) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        db.insertServiceCategory(con, serviceCategory);
    }
    
    @Override
    public void addService(Service service) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        db.insertService(con, service);
    }

    @Override
    public List<Teacher> getTeachers() throws RemoteException {
        System.out.println("get teachers reached");
        List<Teacher> teachers =  new ArrayList<Teacher>();
        
        Database db = new Database();
        Connection con = db.connDB();
        
        ResultSet rs = db.getTeachers(con);
        
        try {
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                String email = rs.getString(4);
                String gender = rs.getString(5);
                int levelId = rs.getInt(6);
                String lev = rs.getString(7);
                Teacher t = new Teacher(id, name, phone, email, gender, levelId , lev);
                teachers.add(t);
                System.out.println("lev");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return teachers;
    }

    @Override
    public ResultSet getTeachersRs() throws RemoteException {
         Database db = new Database();
        Connection con = db.connDB();
        ResultSet rs = db.getTeachers(con);
        
        return rs;
    }

    @Override
    public List<ServiceCategory> getServiceCategories() throws RemoteException {
        List<ServiceCategory> serviceCategories =  new ArrayList<ServiceCategory>();
        Database db = new Database();
        Connection con = db.connDB();
        serviceCategories = db.getServiceCategories(con);
        return serviceCategories;
    }

    @Override
    public void editServiceCategory(ServiceCategory serviceCategory) throws RemoteException {
        System.out.println("bind success");
        Database db = new Database();
        Connection con = db.connDB();
        db.updateServiceCategory(con, serviceCategory);    }

    @Override
    public List<Service> getServices(int id) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        return db.getServices(con, id );
    }

    @Override
    public void editService(Service service) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        db.updateService(con, service); 
    }

    @Override
    public void deleteService(int id) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        db.deleteService(con, id); 
    }

    @Override
    public void editTeacher(Teacher teacher) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        db.updateTeacher(con, teacher);
         } 

    @Override
    public void deleteServiceCategory(int id) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        db.deleteServiceCategory(con, id);      }

    @Override
    public void deleteTeacher(int id) throws RemoteException { 
        Database db = new Database();
        Connection con = db.connDB();
        db.deleteTeacher(con, id);
    }

    @Override
    public void deleteTask(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editTask(Task task) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Task> getDoneTasks() throws RemoteException {
        List<Task> tasks =  new ArrayList<Task>();
        Database db = new Database();
        Connection con = db.connDB();
        tasks = db.getDoneTask(con);
        return tasks;    
    }

    @Override
    public List<Task> getAssignedTasks() throws RemoteException {
         List<Task> tasks =  new ArrayList<Task>();
        Database db = new Database();
        Connection con = db.connDB();
        tasks = db.getAssignedTask(con);
        return tasks; 
    }

    @Override
    public List<Task> getDoneTeacherTasks(int id) throws RemoteException {
        List<Task> tasks =  new ArrayList<Task>();
        Database db = new Database();
        Connection con = db.connDB();
        tasks = db.getTeacherDoneTask(con , id);
        return tasks; 
    }

    @Override
    public List<Task> getAssignedTeacherTasks(int id) throws RemoteException {
        List<Task> tasks =  new ArrayList<Task>();
        Database db = new Database();
        Connection con = db.connDB();
        tasks = db.getTeacherAssignTask(con , id);
        return tasks; 
    }

    @Override
    public void addTask(Task task) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        db.insertTask(con, task);
    }

    @Override
    public List<LevelOfEducation> getLevelOfEds() throws RemoteException {
        List<LevelOfEducation> levels =  new ArrayList<LevelOfEducation>();
        Database db = new Database();
        Connection con = db.connDB();
        levels = db.getLevels(con);
        return levels;     }

    @Override
    public List<Evaluation> getEvaluations() throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        return db.getEvaluations(con);
    }

    @Override
    public void addEvaluation(Evaluation evaluation) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        db.insertEvaluation(con, evaluation);  
    }

    @Override
    public List<Service> searchService(String searchName , int id) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        return db.searchServices(con,searchName , id ); 
    }

    @Override
    public Service getServiceByTaskId(int id) throws RemoteException {
      Database db = new Database();
      Connection con = db.connDB();
      return db.getServicesById(con , id );    
        
    }

    @Override
    public List<Teacher> searchTeachers(String searchString) throws RemoteException {
        System.out.println("get teachers reached");
        Database db = new Database();
        Connection con = db.connDB();
        List<Teacher> teachers =  new ArrayList<Teacher>();
        ResultSet rs = db.searchTeachers(con, searchString);
        
        try {
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                String email = rs.getString(4);
                String gender = rs.getString(5);
                int levelId = rs.getInt(6);
                String level = rs.getString(7);
                System.out.println(level);
                Teacher t = new Teacher(id, name, phone, email, gender, levelId , level);
                teachers.add(t);
                System.out.println(t.getFullName());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teachers;
    
    }

    @Override
    public List<ServiceCategory> searchServiceCategoriies(String searchString) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        return db.searchServiceCategories(con, searchString); 
        
    }

    @Override
    public LevelOfEducation getLevelById(int id) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        return db.getLevelById(con ,id);
    }

    @Override
    public User getUserByEmail(String email) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        return db.getUser(con ,email);
    }

    @Override
    public void changePassword(String password , int id) throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        db.changePassword(con ,password, id);
    
    }

    @Override
    public List<Service> getAllServices() throws RemoteException {
        Database db = new Database();
        Connection con = db.connDB();
        return db.getAllServices(con);
    }

    

    
    
    
    
    
    
    
}
