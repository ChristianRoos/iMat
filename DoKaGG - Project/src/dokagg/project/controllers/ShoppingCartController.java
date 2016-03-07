package dokagg.project.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import se.chalmers.ait.dat215.project.*;

public class ShoppingCartController {
    
    private iMatController iMatController;
    private ArrayList<CartItemController> cartItemsList;
    private String name;
    
    public void initShopCart(iMatController iMat) {
        this.iMatController = iMat;
        
        // TODO
//        Image fxImage = IMatDataHandler.getInstance().getFXImage(prod);
//        prodThumbImageView.setImage(fxImage);
//
//        favoriteImage  = new Image(getClass()
//        .getResourceAsStream("/dokagg/project/resources/images/favoriteButton.png"));
//        notFavoriteImage  = new Image(getClass()
//        .getResourceAsStream("/dokagg/project/resources/images/favoriteButtonNotAdded.png"));
//        
//        if(IMatDataHandler.getInstance().isFavorite(prod)) {
//            favoritedImageView.setImage(favoriteImage);
//        } else {
//            favoritedImageView.setImage(notFavoriteImage);
//        }
//        
//        favoritedImageView.toFront();
//        
//        productThumbnailName.setText(prod.getName());
//        productThumbnailPrice.setText(String.valueOf(prod.getPrice()));
//        
//        // Needed to check if cart already contains this prod(shopping-item)
//        prodAsShopItem = new ShoppingItem(prod);
    }

    // CartItemController factory.
    private Pane cartItemFactory(Product prod, double quantity, ShoppingItem prodAsShopItem) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dokagg/project/fxml/cartItemController.fxml"));
        Pane cartItem = null;
        
        try {
            cartItem = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        CartItemController cartItemController = loader.getController();
        cartItemController.giveData(this, prod, quantity, prodAsShopItem);
        
        cartItemsList.add(cartItemController);
        
        return cartItem;
   }
    
    public void addCartItem(Product prod, double quantity, ShoppingItem prodAsShopItem) {
        cartItemFactory(prod, quantity, prodAsShopItem);
    }
        
    public void removeCartItem(CartItemController cartItemContr, ShoppingItem prodAsShopItem){
        cartItemsList.remove(cartItemContr);
        IMatDataHandler.getInstance().getShoppingCart().removeItem(prodAsShopItem);
    }
    
    public void favoriteShoppingCart() {
        
    }
    
    public ArrayList<CartItemController> getList() {
        return cartItemsList;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
