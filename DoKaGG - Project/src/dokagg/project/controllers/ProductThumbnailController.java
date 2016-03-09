package dokagg.project.controllers;

import javafx.fxml.FXML;
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
        iMatController.addProdToShoppingCart(prod, quantity, prodAsShopItem);
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