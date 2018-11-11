/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author admin
 */
public class CafeProductModel extends BaseModel{

   

    public CafeProductModel() {
    }
    private int productID;
    private String productName;
    private String productPrice;
    private String productShortDescription;
    private String productFullDescription;  
 private String productImage;

    public CafeProductModel(int productID, String productName, String productPrice, String productShortDescription, String productFullDescription, String productImage) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productShortDescription = productShortDescription;
        this.productFullDescription = productFullDescription;
        this.productImage = productImage;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductShortDescription() {
        return productShortDescription;
    }

    public void setProductShortDescription(String productShortDescription) {
        this.productShortDescription = productShortDescription;
    }

    public String getProductFullDescription() {
        return productFullDescription;
    }

    public void setProductFullDescription(String productFullDescription) {
        this.productFullDescription = productFullDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

   
}
