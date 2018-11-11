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

    public CafeProductModel(int productID, String productName, String productPrice, String productShortDescription,String productFullDescription, String productImage, int catalogueID) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productShortDescription = productShortDescription;
        this.productFullDescription = productFullDescription;
        this.productImage = productImage;
        this.catalogueID = catalogueID;
    }

    public CafeProductModel() {
    }
    private int productID;
    private String productName;
    private String productPrice;
    private String productShortDescription;
    private String productFullDescription;
    private  String productCatalogue;

    public String getProductCatalogue() {
        return productCatalogue;
    }

    public CafeProductModel(int productID, String productName, String productPrice, String productShortDescription, String productFullDescription, String productCatalogue, String productImage) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productShortDescription = productShortDescription;
        this.productFullDescription = productFullDescription;
        this.productCatalogue = productCatalogue;
        this.productImage = productImage;
    }

    public void setProductCatalogue(String productCatalogue) {
        this.productCatalogue = productCatalogue;
    }

    public CafeProductModel(int productID, String productName, String productPrice, String productShortDescription, String productFullDescription, String productImage) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productShortDescription = productShortDescription;
        this.productFullDescription = productFullDescription;
        this.productImage = productImage;
    }
    private String productImage;
    private int catalogueID;

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

    public int getCatalogueID() {
        return catalogueID;
    }

    public void setCatalogueID(int catalogueID) {
        this.catalogueID = catalogueID;
    }
    
    
    
}
