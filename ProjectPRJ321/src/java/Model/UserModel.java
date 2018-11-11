/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Quoc Anh
 */
public class UserModel extends BaseModel {

   

    public UserModel() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    private int userID;
    private String useName;
    private String passWd;
    private String url;

    public UserModel(int userID, String useName, String passWd, String url) {
        this.userID = userID;
        this.useName = useName;
        this.passWd = passWd;
        this.url = url;
    }

    

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    
}
