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
public class FeatureModel extends BaseModel{
    private int FeatureID;
    private String URL;

    public int getFeatureID() {
        return FeatureID;
    }

    public void setFeatureID(int FeatureID) {
        this.FeatureID = FeatureID;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
}
