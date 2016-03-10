/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.ProfessorBean;

/**
 *
 * @author Nikunj
 */
public class AddNewProfessorDAOImpl implements AddNewProfessorDAO {
    public int addProfessorInDB(ProfessorBean aProfessor){
        String insertString = "INSERT INTO SFADMIN.PROFESSOR (PROF_NAME, ULID, EMPLOYMENT_STATUS, TEACHING_STATUS,CREATED_TS) VALUES ('"
                    + aProfessor.getProfessorName()
                    + "','" + aProfessor.getUlid()
                    + "'," + aProfessor.getEmploymentStatus()
                    + "," + aProfessor.getTeachingStatus()
                    + ", CURRENT_TIMESTAMP )" ;
        Connection DBConn = null;
        int rowCount = 0;
        
        try{
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://localhost:1527/sfsystem";
            DBConn = DBHelper.connect2DB(myDB, "sfadmin", "sfadmin");
            Statement stmt = DBConn.createStatement();
            
                    
            rowCount = stmt.executeUpdate(insertString);
            System.out.println("Update String: "+insertString);
            DBConn.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return rowCount;
    }
}
