/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SearchProfessorDAO;
import dao.SearchProfessorDAOImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import model.ProfessorBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Nikunj
 */
@ManagedBean 
@SessionScoped
public class ProfessorController implements Serializable{
    private ProfessorBean theModel;

    public ProfessorController() {
        theModel = new ProfessorBean();
    }

    public ProfessorBean getTheModel() {
        return theModel;
    }

    public void setTheModel(ProfessorBean theModel) {
        this.theModel = theModel;
    }
    
    public ArrayList<ProfessorBean> fetchProfessors(){
        SearchProfessorDAO aProfessorDAO = new SearchProfessorDAOImpl();
        ArrayList<ProfessorBean> aProfessorBean = aProfessorDAO.fetchProfessorFromDb();
        return aProfessorBean;
    }
    
    public boolean checkStatus(int status){
        if(status == 0)
            return false;
        return true;
    }
    
}
