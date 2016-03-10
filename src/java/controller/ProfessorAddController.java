package controller;

import dao.AddNewProfessorDAO;
import dao.AddNewProfessorDAOImpl;
import dao.SearchProfessorDAO;
import dao.SearchProfessorDAOImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import model.ProfessorBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Nikunj
 */
@ManagedBean 
@SessionScoped
public class ProfessorAddController {
    private ProfessorBean theModel;

    public ProfessorAddController() {
        theModel = new ProfessorBean();
    }

    public ProfessorBean getTheModel() {
        return theModel;
    }

    public void setTheModel(ProfessorBean theModel) {
        this.theModel = theModel;
    }
    
    public boolean checkStatus(int status){
        if(status == 0)
            return false;
        return true;
    }
    
    public String addNewProfessor(){
        AddNewProfessorDAO aProfessorDAO = new AddNewProfessorDAOImpl();
        int numOfRow = aProfessorDAO.addProfessorInDB(theModel);
        if(numOfRow == 1)
            return "professor.xhtml";
        else
            return "error.xhtml";
    }
    
    public void empValueChanged(ValueChangeEvent e){
        String status = e.getNewValue().toString();
        if(status == "true")
            theModel.setEmploymentStatus(1);
        else
            theModel.setEmploymentStatus(0);
    }
    
    public void teachValueChanged(ValueChangeEvent e){
        String status = e.getNewValue().toString();
        if(status == "true")
            theModel.setTeachingStatus(1);
        else
            theModel.setTeachingStatus(0);
    }
}
