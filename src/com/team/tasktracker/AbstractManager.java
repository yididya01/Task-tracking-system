package com.team.tasktracker;

public abstract class AbstractManager extends AbstractUser {
    
    protected String department;

    public AbstractManager(String firstName, String username, String email, String department) {
        super(firstName, username, email);      
        setDepartment(department);              
    }


    protected void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Invalid department name.");
        }
    }

    
    public String getDepartment() {
        return department;
    }

    
    public abstract void manageTeam();


    @Override
    public abstract String UserInformation();
}
