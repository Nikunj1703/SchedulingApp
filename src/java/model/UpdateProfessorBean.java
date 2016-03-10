/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nikunj
 */
public class UpdateProfessorBean {
    private String professorName;
    private String ulid;
    private int employmentStatus;
    private int teachingStatus;
    private String createdTS;
    private String lastUpdatedTS;

    public UpdateProfessorBean() {
    }
    
    
    public UpdateProfessorBean(String professorName, String ulid, int employmentStatus, int teachingStatus, String createdTS, String lastUpdatedTS) {
        this.professorName = professorName;
        this.ulid = ulid;
        this.employmentStatus = employmentStatus;
        this.teachingStatus = teachingStatus;
        this.createdTS = createdTS;
        this.lastUpdatedTS = lastUpdatedTS;
    }


    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getUlid() {
        return ulid;
    }

    public void setUlid(String ulid) {
        this.ulid = ulid;
    }

    public int getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(int employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public int getTeachingStatus() {
        return teachingStatus;
    }

    public void setTeachingStatus(int teachingStatus) {
        this.teachingStatus = teachingStatus;
    }

    public String getCreatedTS() {
        return createdTS;
    }

    public void setCreatedTS(String createdTS) {
        this.createdTS = createdTS;
    }

    public String getLastUpdatedTS() {
        return lastUpdatedTS;
    }

    public void setLastUpdatedTS(String lastUpdatedTS) {
        this.lastUpdatedTS = lastUpdatedTS;
    }
    
    
}
