/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import Models.Service;
import Models.ServiceCategory;
import Models.Teacher;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author kk
 */
public class EvaluationServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Registry registry;
        try {
            DatabaseService dbService = new DatabaseService();
            registry = LocateRegistry.createRegistry(5050);
             try {
                 registry.bind("addTeacher", dbService);
                 registry.bind("addServiceCategory", dbService);
                 registry.bind("addService", dbService);
                 registry.bind("getTeachers", dbService);
                 registry.bind("getServiceCategories", dbService);
                 registry.bind("editServiceCategory", dbService);
                 registry.bind("editService", dbService);
                 registry.bind("getServices", dbService);
                 registry.bind("deleteService", dbService);
                 registry.bind("deleteTeacher", dbService);
                 registry.bind("deleteServiceCategory", dbService);
                 registry.bind("editTeacher", dbService);
                 registry.bind("addTask", dbService);
                 registry.bind("getAssignedTasks", dbService);
                 registry.bind("getDoneTasks", dbService);
                 registry.bind("getDoneTeacherTasks", dbService);
                 registry.bind("getAsssignTeacherTasks", dbService);
                 registry.bind("getLevelOfEducation", dbService);
                 registry.bind("addEvaluation", dbService);
                 registry.bind("searchService", dbService);
                 registry.bind("searchTeachers", dbService);
                 registry.bind("searchCategories", dbService);
                 registry.bind("getServicesById", dbService);
                 registry.bind("getEvaluations", dbService); 
                 registry.bind("getLevelById", dbService);
                 registry.bind("getUserByEmail", dbService);
                 registry.bind("changePassword", dbService);
             } catch (AlreadyBoundException ex) {
                 Logger.getLogger(EvaluationServer.class.getName()).log(Level.SEVERE, null, ex);
             } catch (AccessException ex) {
                 Logger.getLogger(EvaluationServer.class.getName()).log(Level.SEVERE, null, ex);
             }

        } catch (RemoteException ex) {
            Logger.getLogger(EvaluationServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        //bind the route to your services class or whatever class you store you functions. this is going to be like localhost/bindNameYouGive
    }

  
}
