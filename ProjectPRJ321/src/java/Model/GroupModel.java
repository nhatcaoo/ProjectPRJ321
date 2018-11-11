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
public class GroupModel extends BaseModel{
    private int GroupID;
    private String GroupNmae;

    public int getGroupID() {
        return GroupID;
    }

    public void setGroupID(int GroupID) {
        this.GroupID = GroupID;
    }

    public String getGroupNmae() {
        return GroupNmae;
    }

    public void setGroupNmae(String GroupNmae) {
        this.GroupNmae = GroupNmae;
    }
    
}
