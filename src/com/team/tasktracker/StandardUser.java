package com.team.tasktracker;
import java.util.HashMap;
import java.util.Map;

public class StandardUser extends AbstractUser{
    private float taskPoints=0;
    UserType standardUser = UserType.STANDARD; 
    

    void setTaskPoints(float taskPoints){
        this.taskPoints = taskPoints;
    }

    float getTaskPoints(){
        return taskPoints;
    }

    StandardUser(String firstName, String username, String email){
        super(firstName, username, email);
        setTaskPoints(taskPoints);
        standardUser = UserType.STANDARD;    
    }

    @Override
    public Map<String,String> UserInformation(){
        Map<String,String> UserInfo = new HashMap<>();
        UserInfo.put("UserType",String.valueOf(standardUser));
        UserInfo.put("First Name", getFirstName());
        UserInfo.put("Username", getUsername());
        UserInfo.put("Email", getEmail());
        UserInfo.put("Points",String.valueOf(getTaskPoints()));

        return UserInfo;

    }

    @Override
    public String toString(){
        return getEmail();   
    }
    
}
