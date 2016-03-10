/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.ProfessorBean;
import model.UpdateProfessorBean;

/**
 *
 * @author Nikunj
 */
public interface UpdateProfessorDAO {
    public int updateProfessorDataInDB(UpdateProfessorBean theUpdateProfessorModel);
}
