/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SearchProfessorDAO;
import dao.SearchProfessorDAOImpl;
import dao.UpdateProfessorDAO;
import dao.UpdateProfessorDAOImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import model.ProfessorBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;
import model.UpdateProfessorBean;


/**
 *
 * @author Nikunj
 */
@ManagedBean 
@SessionScoped
public class ProfessorUpdateController implements Serializable{
    private UpdateProfessorBean theUpdateProfessorModel;

    public ProfessorUpdateController() {
        theUpdateProfessorModel = new UpdateProfessorBean();
    }
    

    public UpdateProfessorBean getTheUpdateProfessorModel() {
        return theUpdateProfessorModel;
    }

    public void setTheUpdateProfessorUpdateModel(UpdateProfessorBean theUpdateProfessorModel) {
        this.theUpdateProfessorModel = theUpdateProfessorModel;
    }
  
    public String editProfessorDetails(ProfessorBean professor){
        theUpdateProfessorModel.setProfessorName(professor.getProfessorName());
        theUpdateProfessorModel.setUlid(professor.getUlid());
        theUpdateProfessorModel.setEmploymentStatus(professor.getEmploymentStatus());
        theUpdateProfessorModel.setTeachingStatus(professor.getTeachingStatus());
        theUpdateProfessorModel.setCreatedTS(professor.getCreatedTS());
        theUpdateProfessorModel.setLastUpdatedTS(professor.getLastUpdatedTS());
        
        return "updateProfessor.xhtml";
    }
    
    public String updateProfessorData(){
        UpdateProfessorDAO aProfessorDAO = new UpdateProfessorDAOImpl();
        int employmentStatus = theUpdateProfessorModel.getEmploymentStatus();
        aProfessorDAO.updateProfessorDataInDB(theUpdateProfessorModel);
        return "professor.xhtml";
    }
    
    public boolean checkStatus(int status){
        if(status == 0)
            return false;
        return true;
    }
    
    public int checkStatus(boolean status){
        if(status == true)
            return 1;
        else 
            return 0;
    }
    
    public void empValueChangeFT(boolean status){
        status = true;
        theUpdateProfessorModel.setEmploymentStatus(checkStatus(status));
        System.out.println(status);
    }
    
    public void empValueChangeTF(boolean status){
        status = false;
        theUpdateProfessorModel.setEmploymentStatus(checkStatus(status));
        System.out.println(status);
    }
    
    public void teachValueChangeFT(boolean status){
        status = true;
        theUpdateProfessorModel.setTeachingStatus(checkStatus(status));
        System.out.println(status);
    }
    
    public void teachValueChangeTF(boolean status){
        status = false;
        theUpdateProfessorModel.setTeachingStatus(checkStatus(status));
        System.out.println(status);
    }
}
