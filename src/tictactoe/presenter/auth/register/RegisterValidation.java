/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.auth.register;

/**
 *
 * @author Heba
 */
public class RegisterValidation {
    RegisterViewBase registerViewBase = new RegisterViewBase();
    
    //validate username isn't empty
    //validate password isn't empty
    //validate confirmpassword isn't empty
    //validate username doesn't exist in db
    //validate that password is identical to confirmPassword
    public static final int MINMUM_PASSWORD = 3;
    public static final int MAXIMUM_PASSWORD = 20;
    public static final int MINMUM_USER_NAME = 3;
    public static final int MAXIMUM_USER_NAME = 20;
    
    boolean validateUserNameNotEmpty(){
        boolean flag= false;
        if (registerViewBase.userNameTF.getLength()>= MINMUM_USER_NAME){
            if (registerViewBase.userNameTF.getLength()<= MAXIMUM_USER_NAME){
                flag = true;}
        }
        return flag;
    }
    
    boolean validatePasswordNotEmpty(){
        boolean flag= false;
        if (registerViewBase.passwordPF.getLength()>= MINMUM_PASSWORD){
            if (registerViewBase.userNameTF.getLength()<= MAXIMUM_PASSWORD){
                flag = true;}
        }
        return flag;
    }
    
    boolean validateConfirmPasswordNotEmpty(){
        boolean flag= false;
        if (registerViewBase.confirmPasswordPF.getLength()>= MINMUM_PASSWORD){
            if (registerViewBase.userNameTF.getLength()<= MAXIMUM_PASSWORD){
                flag = true;}
            }
        return flag;
        }
        
    
    
     boolean validatePasswordEquality(){
        boolean flag= false;
        String pass = registerViewBase.passwordPF.getText();
        String confirmPass = registerViewBase.confirmPasswordPF.getText();
        if(pass.equals(confirmPass)){
            flag = true;
        }
        return flag;
    }
    
    //check uniqueness in DB
    boolean isUniqueUserName(){
        boolean flag= false;
        //call query in DB to check the uniqueness
        //if(result +ve){alert your name is not unique re enter a unique one}else flage=true;
        return flag;
    }
    
    
    
    
    
 }
