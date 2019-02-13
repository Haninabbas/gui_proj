package gui_classes;

import java.util.ArrayList;

public class admin implements Person {
    public ArrayList<Person>p=new ArrayList<>();
    private static admin Admin = null;
    private String UserName;
    private String Password;

    private admin(String U,String P) {
        setUserName(U);
        setPassword(P);

    }
    private static admin getAdmin(String username,String password)
    {
        if (Admin == null){
            Admin = new admin(username,password);}
        else
            System.out.println("already taken");

        return Admin   ;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String username) {
        UserName = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


}
