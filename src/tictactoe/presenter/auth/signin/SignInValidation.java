/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.auth.signin;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 *
 * @author Heba
 */
public class SignInValidation {
    public static final int MINMUM_PASSWORD = 3;
    public static final int MINMUM_USER_NAME = 3;
    
    
    SignInViewBase signInViewBase = new SignInViewBase();
    //user name isn't empty
    //password isn't empty
    //user name exists in db
    //this specific user name password equal the password entered
    
    boolean validateUserNameNotEmpty(){
        boolean flag = false;
        if(signInViewBase.userNameTF.getLength()>=MINMUM_USER_NAME){
            flag= true;
        }
        return flag;
    } 
    
    boolean validatePasswordNotEmpty(){
        boolean flag = false;
        if(signInViewBase.passwordPF.getLength()>=MINMUM_PASSWORD){
            flag= true;
        }
        return flag;
    }
    
    boolean validateUserNameExist(){
        boolean flag = false;
        String user= signInViewBase.userNameTF.getText();
        //query db for string and get result
        //if (result +ve){flag=true}
        return flag;
    }
    
    void signInValidation(){
        if (!validateUserNameNotEmpty()||! validatePasswordNotEmpty()){
            Alert notEmpty= new Alert(AlertType.WARNING);
            notEmpty.setContentText("UserName and password can't be less than 3 letters");
            notEmpty.show();
        }
    
    }
     
    
    
}
