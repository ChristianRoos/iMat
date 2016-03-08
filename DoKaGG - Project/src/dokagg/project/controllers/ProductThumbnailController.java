package dokagg.project.controllers;

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
public class ProductThumbnailController {

    @FXML private ImageView prodThumbImageView;
    @FXML private ImageView favoritedImageView;
    @FXML private Label productThumbnailName;
    @FXML private Button thumbBuyButton;
    @FXML private Text productThumbnailPrice;
    @FXML private TextField thumbQuantity;
    
    private ShoppingItem prodAsShopItem;
    private Product prod;
    private iMatController iMatController;
    
    private Image favoriteImage;
    private Image notFavoriteImage;
    
    @FXML 
    public void initProdThumb(Product prod, iMatController iMat) {
        this.iMatController = iMat;
        this.prod = prod;
        
        Image fxImage = IMatDataHandler.getInstance().getFXImage(prod);
        prodThumbImageView.setImage(fxImage);

        favoriteImage  = new Image(getClass()
        .getResourceAsStream("/dokagg/project/resources/images/favoriteButton.png"));
        notFavoriteImage  = new Image(getClass()
        .getResourceAsStream("/dokagg/project/resources/images/favoriteButtonNotAdded.png"));
        
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
        
        double quantity = Double.parseDouble(thumbQuantity.getText());
        
        // Check if the shoppingcart is empty
        if(IMatDataHandler.getInstance().getShoppingCart().getItems().size() > 0){
            
            // see if product we want to add already exist in shoppingcart,
            // in that case, increase the amount of same type you just bought.
            for(ShoppingItem shopItem : IMatDataHandler.getInstance().getShoppingCart().getItems()) {
                
                if(shopItem.getProduct().getName().equals(prod.getName())) {
                    shopItem.setAmount(shopItem.getAmount() + quantity);
                    return;
                }
            }
            // the item didn't exist in the shoppingcart, so just add it
            IMatDataHandler.getInstance().getShoppingCart().addProduct(prod, quantity);
        
        // shoppingCart was empty
        } else {
            IMatDataHandler.getInstance().getShoppingCart().addProduct(prod, quantity);
        }

        iMatController.AddProdToShoppingCart(prod, quantity, prodAsShopItem);
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