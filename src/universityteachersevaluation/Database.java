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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kk
 */

//Database class for handling all the sql 

public class Database {

    /**
     * @param args the command line arguments
     */
    Connection conn = null;
    public static Connection connDB()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/evaluation", "root", "");
            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please start wamp server and restart this application");
            return null;
        }
    }
    
   
    static ResultSet insertTeacher(Connection conn , Teacher t){
        try {
            String sql="INSERT INTO teachers(fullName,phone,email ,gender , levelId , password) VALUES(?,?,? ,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, t.getFullName());
            pst.setString(2, t.getPhone());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getGender());
            pst.setInt(5, t.getLevelId());
            pst.setString(6, "12345678");
            pst.executeUpdate();
           
            ResultSet rs = pst.getGeneratedKeys();
            return rs;
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    
     static ResultSet insertServiceCategory(Connection conn , ServiceCategory s){
        try {
            String sql="INSERT INTO service_categories(name,description) VALUES(?,?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, s.getName());
            pst.setString(2, s.getDescription());
            
            pst.executeUpdate();
           
            ResultSet rs = pst.getGeneratedKeys();
            return rs;
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    static ResultSet insertEvaluation(Connection conn , Evaluation s){
        try {
            String sql="INSERT INTO eval (comment,value , taskId) VALUES(?,? ,?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, s.getComment());
            pst.setDouble(2, s.getValue());
            pst.setInt(3, s.getTaskId());
            pst.executeUpdate();
           
            ResultSet rs = pst.getGeneratedKeys();
            completeTask(conn ,s.getTaskId());
            return rs;
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    } 
     
     static ResultSet insertService(Connection conn , Service s){
        try {
            String sql="INSERT INTO services(name,description , percentile, levelId, service_category_id) VALUES(?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, s.getName());
            pst.setString(2, s.getDescription());
            pst.setDouble(3, s.getPercentile());
            pst.setInt(4, s.getLevelId());
            pst.setInt(5, s.getServiceCategoryId());
            pst.executeUpdate();
           
            ResultSet rs = pst.getGeneratedKeys();
            return rs;
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
      static ResultSet insertTask(Connection conn , Task t){
        try {
            
            String sql="INSERT INTO tasks (serviceId, percentile, name, teacherId , description , complete ) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(3, t.getTitle());
            pst.setString(5, t.getDescription());
            pst.setDouble(2, t.getPercentile());
            pst.setInt(1, t.getServiceId());
            pst.setInt(4, t.getTeacherId());
            pst.setBoolean(6, false);
            pst.executeUpdate();
           
            ResultSet rs = pst.getGeneratedKeys();
            return rs;
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
     
     static void updateService(Connection conn, Service s){
        try {
            System.out.println("abt to update");
            String sql="UPDATE services SET name = ?,  description = ? , percentile = ? , levelId = ? , service_category_id = ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, s.getName());
            pst.setString(2, s.getDescription());
            pst.setDouble(3, s.getPercentile());
            pst.setInt(4, s.getLevelId());
            pst.setInt(5, s.getServiceCategoryId());
            pst.setInt(6, s.getId());
            
            int result = pst.executeUpdate();
            
            if (result > 0)
                System.out.println( "Successfully deleted");
            else
               System.out.println( "somethin went wrong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
     static void completeTask(Connection conn ,int id){
        try {
            
            String sql="UPDATE tasks SET complete = ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setBoolean(1, true);
            pst.setInt(2, id);
            
            pst.executeUpdate();
           
            
           
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
     static void updateTeacher(Connection conn, Teacher t){
        try {
            System.out.println("abt to update");
            
            String sql="UPDATE teachers SET fullName = ? ,phone = ?,email = ? ,gender = ? ,levelId = ?  WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getFullName());
            pst.setString(2, t.getPhone());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getGender());
            pst.setInt(5, t.getLevelId());
            pst.setInt(6, t.getId());
            
            int result = pst.executeUpdate();
            
            if (result > 0)
                System.out.println( "Successfully deleted");
            else
               System.out.println( "somethin went wrong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    static void updateServiceCategory(Connection conn, ServiceCategory sc){
        try {
            System.out.println("abt to update");
            String sql="UPDATE service_categories SET name = ?,  description = ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, sc.getName());
            pst.setString(2, sc.getDescription());            
            pst.setInt(3, sc.getId());
            
            int result = pst.executeUpdate();
            
            if (result > 0)
                System.out.println( "Successfully deleted");
            else
               System.out.println( "somethin went wrong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    static void deleteTeacher(Connection conn, int id){
        try {
            String sql="DELETE FROM teachers WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            
            int result = pst.executeUpdate();
            
            if (result > 0)
                System.out.println( "Successfully deleted");
            else
               System.out.println( "somethin went wrong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     static void deleteService(Connection conn, int id){
        try {
            String sql="DELETE FROM services WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            
            int result = pst.executeUpdate();
            
            if (result > 0)
                System.out.println( "Successfully deleted");
            else
               System.out.println( "somethin went wrong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
      static void deleteServiceCategory(Connection conn, int id){
        try {
            String sql="DELETE FROM service_categories WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            
            int result = pst.executeUpdate();
            
            if (result > 0)
                System.out.println( "Successfully deleted");
            else
               System.out.println( "somethin went wrong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    static List<ServiceCategory> getServiceCategories(Connection conn)
    {
        List<ServiceCategory> serviceCategories =  new ArrayList<ServiceCategory>();
        try{
            String sql = "SELECT * FROM service_categories";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                ServiceCategory servCat = new ServiceCategory(id, name , description);
                serviceCategories.add(servCat);
            }
            conn.close();

            return serviceCategories;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    
    static List<Service> getServices(Connection conn , int selectedId)
    {
        List<Service> services =  new ArrayList<Service>();
        try{
            String sql = "SELECT services.id ,services.name , services.description , services.percentile , services.levelId , services.service_category_id , level_of_ed.name FROM level_of_ed INNER JOIN services ON services.levelId = level_of_ed.id WHERE services.service_category_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, selectedId);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                double percentile = rs.getDouble(4);
                int levelId = rs.getInt(5);
                int servCatId = rs.getInt(6);
                String catName =  rs.getString(7);
                Service servCat = new Service(id, name , description , percentile , levelId, servCatId , catName);
                services.add(servCat);
            }
            conn.close();

            return services;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    
    
    static ResultSet getTeachers(Connection conn)
    {
        System.out.println("sdhkfbs jlskd fksljd fskdh fsldjh fsjldh fsljd fhsd;jfhsjdh");
        try{
            String sql = "SELECT teachers.id, teachers.fullName ,teachers.phone ,teachers.email ,teachers.gender , teachers.levelId,  level_of_ed.name FROM teachers INNER JOIN level_of_ed ON teachers.levelId = level_of_ed.id";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
          
            
            return rs;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    
    static List<Task> getTeacherDoneTask(Connection conn , int selectedId){
        List<Task> tasks =  new ArrayList<Task>();
        try{
            System.out.println(selectedId);
            String sql = "SELECT tasks.id, tasks.name, tasks.teacherId , tasks.description , tasks.percentile ,tasks.complete , tasks.serviceId ,  services.name FROM tasks INNER JOIN services ON tasks.serviceId = services.id WHERE tasks.complete = ? and tasks.teacherId = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, selectedId);
            pst.setBoolean(2, true);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int teacherId = rs.getInt(3);
                String description = rs.getString(4);
                double perc = rs.getDouble(5);
                boolean comp = rs.getBoolean(6); 
                int serviceId = rs.getInt(7);
                String levelName = rs.getString(8);
                Task task = new Task(id, name , description ,comp , serviceId , teacherId, perc , levelName);
                tasks.add(task);
            }
            conn.close();
}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
            return tasks;
    }
    
     static List<Task> getTeacherAssignTask(Connection conn , int selectedId){
         
         List<Task> tasks =  new ArrayList<Task>();
        try{
            String sql = "SELECT tasks.id, tasks.name, tasks.teacherId , tasks.description , tasks.percentile ,tasks.complete , tasks.serviceId ,  services.name FROM tasks INNER JOIN services ON tasks.serviceId = services.id WHERE tasks.complete = ? and tasks.teacherId = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(2, selectedId);
            pst.setBoolean(1, false);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int teacherId = rs.getInt(3);
                String description = rs.getString(4);
                double perc = rs.getDouble(5);
                boolean comp = rs.getBoolean(6); 
                int serviceId = rs.getInt(7);
                String levelName = rs.getString(8);
                Task task = new Task(id, name , description ,comp , serviceId , teacherId, perc , levelName);
                tasks.add(task);
            }
            conn.close();
}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
            return tasks;
         
    }
      static List<Task> getDoneTask(Connection conn){
          List<Task> tasks =  new ArrayList<Task>();
        try{
            String sql = "SELECT tasks.id, tasks.name, tasks.teacherId , tasks.description , tasks.percentile ,tasks.complete , tasks.serviceId ,  services.name FROM tasks INNER JOIN services ON tasks.serviceId = services.id WHERE tasks.complete = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setBoolean(1, true);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int teacherId = rs.getInt(3);
                String description = rs.getString(4);
                double perc = rs.getDouble(5);
                boolean comp = rs.getBoolean(6); 
                int serviceId = rs.getInt(7);
                String levelName = rs.getString(8);
                Task task = new Task(id, name , description ,comp , serviceId , teacherId, perc , levelName);
                tasks.add(task);
            }
            conn.close();
}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
            return tasks;
    }
       static List<Task> getAssignedTask(Connection conn){
           List<Task> tasks =  new ArrayList<Task>();
        try{
            String sql = "SELECT tasks.id, tasks.name, tasks.teacherId , tasks.description , tasks.percentile ,tasks.complete , tasks.serviceId ,  services.name FROM tasks INNER JOIN services ON tasks.serviceId = services.id WHERE tasks.complete = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setBoolean(1, false);
            ResultSet rs = pst.executeQuery();
              
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int teacherId = rs.getInt(3);
                String description = rs.getString(4);
                double perc = rs.getDouble(5);
                boolean comp = rs.getBoolean(6); 
                int serviceId = rs.getInt(7);
                String levelName = rs.getString(8);
                Task task = new Task(id, name , description ,comp , serviceId , teacherId, perc , levelName);
                tasks.add(task);
            }
            conn.close();
}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
            return tasks;
    }
       
        static List<LevelOfEducation> getLevels(Connection conn){
           List<LevelOfEducation> levels =  new ArrayList<LevelOfEducation>();
        try{
            String sql = "SELECT * FROM level_of_ed";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                LevelOfEducation level = new LevelOfEducation(id , name);
                levels.add(level);
            }
            conn.close();
}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
            return levels;
    }
        
        
         static List<Service> searchServices(Connection conn , String searchName , int catId)
    {
        List<Service> services =  new ArrayList<Service>();
        try{
            String sql = "SELECT services.id ,services.name , services.description , services.percentile , services.levelId , services.service_category_id , level_of_ed.name FROM level_of_ed INNER JOIN services ON services.levelId = level_of_ed.id WHERE services.name LIKE ? and  services.service_category_id = ?";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            String s = "%" + searchName + "%";
            pst.setString(1, s);
            pst.setInt(2, catId); 
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                double percentile = rs.getDouble(4);
                int levelId = rs.getInt(5);
                int servCatId = rs.getInt(6);
                String catName = rs.getString(7);
                Service servCat = new Service(id, name , description , percentile , levelId, servCatId , catName);
                services.add(servCat);
            }
            conn.close();

            return services;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
         
         
    
    
    static ResultSet searchTeachers(Connection conn , String teacherName)
    {
        System.out.println("abt to search");
        try{
            String sql = "SELECT teachers.id, teachers.fullName ,teachers.phone ,teachers.email ,teachers.gender , teachers.levelId,  level_of_ed.name FROM teachers INNER JOIN level_of_ed ON teachers.levelId = level_of_ed.id WHERE teachers.fullName LIKE ? ";
            PreparedStatement pst = conn.prepareStatement(sql);
            String s = "%" + teacherName + "%";
            System.out.println("abt to pst");
            pst.setString(1,s );
            System.out.println("abt to search");
            ResultSet rs = pst.executeQuery();
          System.out.println("abt to search");

            return rs;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    
        
    static List<Evaluation> getEvaluations(Connection conn){
           List<Evaluation> evals =  new ArrayList<Evaluation>();
        try{
            String sql = "SELECT * FROM eval";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String comment = rs.getString(2);
                double value = rs.getDouble(3);
                int taskId = rs.getInt(4);
                Evaluation level = new Evaluation(id , comment , value , taskId);
                evals.add(level);
            }
            conn.close();
}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
            return evals;
    }
    
    
     
    static Service getServicesById(Connection conn , int selectedId)
    {
        Service servCat = null;
        try{
            String sql = "SELECT services.id ,services.name , services.description , services.percentile , services.levelId , services.service_category_id , level_of_ed.name FROM level_of_ed INNER JOIN services ON services.levelId = level_of_ed.id WHERE services.id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, selectedId);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                double percentile = rs.getDouble(4);
                int levelId = rs.getInt(5);
                int servCatId = rs.getInt(6);
                String catName = rs.getString(7);
                servCat = new Service(id, name , description , percentile , levelId, servCatId , catName);
            }
            conn.close();

            return servCat;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    static List<ServiceCategory> searchServiceCategories(Connection conn , String st)
    {
        List<ServiceCategory> serviceCategories =  new ArrayList<ServiceCategory>();
        System.out.println("abt to search");
        try{
            String sql = "SELECT * FROM service_categories WHERE name LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            String s = "%" + st + "%";
            System.out.println("abt to pst");
            pst.setString(1,s );
            System.out.println("abt to search");
            ResultSet rs = pst.executeQuery();
          System.out.println("abt to search");

          while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                ServiceCategory servCat = new ServiceCategory(id, name , description);
                serviceCategories.add(servCat);
            }
            return serviceCategories;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
   
    
        static LevelOfEducation getLevelById(Connection conn , int selectedId){
           LevelOfEducation level = null;
        try{
            String sql = "SELECT * FROM level_of_ed WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, selectedId); 
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                level = new LevelOfEducation(id , name);
                
            }
            conn.close();
}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
            return level;
    }
        
         static User getUser(Connection conn , String email){
           User user = null;
        try{
            String sql = "SELECT * FROM users WHERE email = ? ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email); 
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email1 = rs.getString(3);
                boolean admin = rs.getBoolean(4);
                String pass = rs.getString(5);
                int teachId = rs.getInt(6);
                user = new User(id , name , email1 , admin , pass , teachId);
                
            }
            conn.close();
}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
            return user;
    }
         
         void changePassword(Connection conn , String password , int id){
             try {
            System.out.println("abt to update");
            String sql="UPDATE `users` SET `password`= ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, password);
            pst.setInt(2, id);
            
            int result = pst.executeUpdate();
            
            if (result > 0)
                System.out.println( "Successfully deleted");
            else
               System.out.println( "somethin went wrong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         }
         
         
         
           static List<Service> getAllServices(Connection conn)
    {
        List<Service> services =  new ArrayList<Service>();
        try{
            String sql = "SELECT services.id ,services.name , services.description , services.percentile , services.levelId , services.service_category_id , level_of_ed.name FROM level_of_ed INNER JOIN services ON services.levelId = level_of_ed.id  ";
            
            PreparedStatement pst = conn.prepareStatement(sql);
//            String s = "%" + searchName + "%";
//            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                double percentile = rs.getDouble(4);
                int levelId = rs.getInt(5);
                int servCatId = rs.getInt(6);
                String catName = rs.getString(7);
                Service servCat = new Service(id, name , description , percentile , levelId, servCatId , catName);
                services.add(servCat);
            }
            conn.close();

            return services;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}