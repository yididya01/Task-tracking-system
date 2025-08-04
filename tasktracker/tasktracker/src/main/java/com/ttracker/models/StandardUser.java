package com.ttracker.models;
import java.util.HashMap;
import java.util.Map;

import com.ttracker.abstracts.AbstractUser;

public class StandardUser extends AbstractUser{
    private float taskPoints=0;
    UserType standardUser = UserType.STANDARD; 
    

    void setTaskPoints(float taskPoints){
        this.taskPoints = taskPoints;
    }

    float getTaskPoints(){
        return taskPoints;
    }

    StandardUser(String firstName, String password, String email){
        super(firstName, password, email);
        setTaskPoints(taskPoints);
        standardUser = UserType.STANDARD;    
    }

    @Override
    public Map<String,String> UserInformation(){
        Map<String,String> UserInfo = new HashMap<>();
        UserInfo.put("UserType",String.valueOf(standardUser));
        UserInfo.put("First Name", getFirstName());
        UserInfo.put("Username", getPassword());
        UserInfo.put("Email", getEmail());
        UserInfo.put("Points",String.valueOf(getTaskPoints()));

        return UserInfo;

    }

    @Override
    public String toString(){
        return getEmail();   
    }
    
}
