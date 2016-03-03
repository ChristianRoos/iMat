/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokagg.project;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Kim
 */
public class ProductThumbnailController implements Initializable{

    @FXML private ImageView prodThumbImageView;
    @FXML private ImageView favoritedImageView;
    @FXML private Label productThumbnailName;
    @FXML private Button thumbBuyButton;
    @FXML private Text productThumbnailPrice;
    @FXML private TextField thumbQuantity;
    
    private ShoppingItem prodAsShopItem;
    private Product prod;
    private iMatController iMat;
    private Image favoriteImage;
    private Image notFavoriteImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    @FXML 
    public void giveData(Product prod, iMatController iMat) {
        this.iMat = iMat;
        this.prod = prod;
        
        Image fxImage = IMatDataHandler.getInstance().getFXImage(prod);
        prodThumbImageView.setImage(fxImage);

        favoriteImage  = new Image(getClass()
        .getResourceAsStream("resources/images/favoriteButton.png"));
        notFavoriteImage  = new Image(getClass()
        .getResourceAsStream("resources/images/favoriteButtonNotAdded.png"));
        
        if(IMatDataHandler.getInstance().isFavorite(prod)) {
            favoritedImageView.setImage(favoriteImage);
        } else {
            favoritedImageView.setImage(notFavoriteImage);
        }
        
        favoritedImageView.toFront();
        
        productThumbnailName.setText(prod.getName());
        productThumbnailPrice.setText(String.valueOf(prod.getPrice()));
        
        // Needed to check if cart already contains this prod(shopping-item)
        prodAsShopItem = new ShoppingItem(prod);
    }
    
    @FXML
    protected void thumbBuyButtonClicked() {
        
        // Check if the shoppingcart is empty
        if(IMatDataHandler.getInstance().getShoppingCart().getItems().size() > 0){
            
            // see if product we want to add already exist in shoppingcart,
            // in that case, increase the amount of same type you just bought.
            for(ShoppingItem shopItem : IMatDataHandler.getInstance().getShoppingCart().getItems()) {
                if(shopItem.getProduct().getName().equals(prod.getName())) {
                    shopItem.setAmount(shopItem.getAmount() + Double.parseDouble(thumbQuantity.getText()));
                    
                    iMat.updateShoppingCart(prod, Double.parseDouble(thumbQuantity.getText()));
                    return;
                }
            }
            // the item didn't exist in the shoppingcart, so just add it
            IMatDataHandler.getInstance().getShoppingCart().addProduct(prod, Double.parseDouble(thumbQuantity.getText()));
        
        // shoppingCart was empty
        } else {
            IMatDataHandler.getInstance().getShoppingCart().addProduct(prod, Double.parseDouble(thumbQuantity.getText()));
            iMat.initializeShoppingCart();
        }

        iMat.updateShoppingCart(prod, Double.parseDouble(thumbQuantity.getText()));
    }
    
    @FXML
    protected void thumbFavButtonClicked() {
        if(IMatDataHandler.getInstance().isFavorite(prod)) {
            IMatDataHandler.getInstance().removeFavorite(prod);
            favoritedImageView.setImage(notFavoriteImage);
        } else {
            IMatDataHandler.getInstance().addFavorite(prod);
            favoritedImageView.setImage(favoriteImage);
        }
    }
}