/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ProfessorBean;

/**
 *
 * @author Nikunj
 */
public class SearchProfessorDAOImpl implements SearchProfessorDAO{
    
    @Override
    public ArrayList<ProfessorBean> fetchProfessorFromDb(){
        String query = "SELECT * FROM SFADMIN.PROFESSOR";
        ProfessorBean professorBean;
        
        ArrayList<ProfessorBean> aProfessorCollection = new ArrayList<ProfessorBean>();
        Connection DBConn = null;
        
        try{
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://localhost:1527/sfsystem";
            DBConn = DBHelper.connect2DB(myDB, "sfadmin", "sfadmin");
            
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
//                boolean empStat = false;
//                boolean teachingStat = false;
//                if(Integer.parseInt(rs.getString("EMPLOYMENT_STATUS")) == 1)
//                    empStat = true;
//                if(Integer.parseInt(rs.getString("TEACHING_STATUS")) == 1){
//                    teachingStat = true;
//                }
                professorBean = new ProfessorBean(Integer.parseInt(rs.getString("PROF_ID").toString()),
                                                   rs.getString("PROF_NAME"),
                                                    rs.getString("ULID"),
                                                     Integer.parseInt(rs.getString("EMPLOYMENT_STATUS")),
                                                      Integer.parseInt(rs.getString("TEACHING_STATUS")),
                                                       rs.getString("CREATED_TS"),
                                                        rs.getString("LAST_UPDT_TS"));
                
                //System.out.println("Name of Prof: "+professorBean.getProfessorName());
                aProfessorCollection.add(professorBean);
            }
        }catch(Exception ex){
            
        }
        return aProfessorCollection;
    }
    
    
}
