package com.example.happylearning.models;

public class UserInfo {

    /*
     * Description:
     * Used to save user's information.
     * UserInfo will be saved in cloud database - firebase.
     * The data must be matched if users want to register or log in.
     */

    private String _username;
    private String _email;
    private String _password;

    public UserInfo() {
        _username = " ";
        _email = " ";
        _password = " ";
    }

    public UserInfo(String nameIn, String emailIn, String passwordIn){
        this._username = nameIn;
        this._email = emailIn;
        this._password = passwordIn;
    }


    public String getUsername(){
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

}
