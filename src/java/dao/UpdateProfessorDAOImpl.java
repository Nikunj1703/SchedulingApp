/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ProfessorBean;
import model.UpdateProfessorBean;

/**
 *
 * @author Nikunj
 */
public class UpdateProfessorDAOImpl implements UpdateProfessorDAO{
    
    public int updateProfessorDataInDB(UpdateProfessorBean theUpdateProfessorModel){
        System.out.println("New Employement Status: "+theUpdateProfessorModel.getEmploymentStatus());
        System.out.println("New Teaching Status: "+theUpdateProfessorModel.getTeachingStatus());
        System.out.println("Emp Ulid: "+theUpdateProfessorModel.getUlid());
        
        int newEmpStatus = theUpdateProfessorModel.getEmploymentStatus();
        int newTeachStatus = theUpdateProfessorModel.getTeachingStatus();
        String ulid = theUpdateProfessorModel.getUlid();
        Connection DBConn = null;
        int rowCount = 0;
        try{
            String updateString;
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://localhost:1527/sfsystem";
            DBConn = DBHelper.connect2DB(myDB, "sfadmin", "sfadmin");
            Statement stmt = DBConn.createStatement();
            
            updateString = "UPDATE SFADMIN.PROFESSOR SET "
                    + "EMPLOYMENT_STATUS = " + newEmpStatus+ ", "
                    + "TEACHING_STATUS = " + newTeachStatus+ ", "
                    + "LAST_UPDT_TS = CURRENT_TIMESTAMP "
                    + " WHERE ULID = '"+ulid+"'";
                    
            rowCount = stmt.executeUpdate(updateString);
            System.out.println("Update String: "+updateString);
            DBConn.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return rowCount;
    }
}
