package dokagg.project.controllers;

import java.io.IOException;
import java.util.ArrayList;
<<<<<<< HEAD
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
=======
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
>>>>>>> 8b491138718ad3444935d1e9ad76f98fe90d192c
import se.chalmers.ait.dat215.project.*;

public class ShoppingCartController {
    
<<<<<<< HEAD
    @FXML public GridPane cartPane;
    @FXML public Text cartTotalCost;
    @FXML private VBox cartList;
    
    private iMatController iMatController;
    public ArrayList<CartItemController> cartsItems = new ArrayList<>();
    private String ShoppingCartName;
    
    public void initShopCart(iMatController iMat, ArrayList<CartItemController> clonedCartList) {
        this.iMatController = iMat;
        if(clonedCartList != null){
            System.out.println("2");
            cartsItems = clonedCartList;
        }
    }

    // CartItemController factory.
    private AnchorPane cartItemFactory(Product prod, double quantity, ShoppingItem prodAsShopItem) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dokagg/project/fxml/cartItem.fxml"));
        AnchorPane cartItem = null;
=======
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
>>>>>>> 8b491138718ad3444935d1e9ad76f98fe90d192c
        
        try {
            cartItem = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        CartItemController cartItemController = loader.getController();
        cartItemController.giveData(this, prod, quantity, prodAsShopItem);
        
<<<<<<< HEAD
        cartsItems.add(cartItemController);
=======
        cartItemsList.add(cartItemController);
>>>>>>> 8b491138718ad3444935d1e9ad76f98fe90d192c
        
        return cartItem;
   }
    
    public void addCartItem(Product prod, double quantity, ShoppingItem prodAsShopItem) {
<<<<<<< HEAD
        cartList.getChildren().add(cartItemFactory(prod, quantity, prodAsShopItem));
    }
        
    public void removeCartItem(CartItemController cartItemContr, ShoppingItem prodAsShopItem){
        cartsItems.remove(cartItemContr);
        IMatDataHandler.getInstance().getShoppingCart().removeItem(prodAsShopItem);
    }
    
    public void cartCheckoutButton() {
        IMatDataHandler.getInstance().getShoppingCart().clear();
        iMatController.cartCheckoutButton();
    }
    public void favoriteShoppingCart() {
        ArrayList<CartItemController> cloneBaby = new ArrayList<>(cartsItems);
        iMatController.shoppingCartsSaved.add(iMatController.shoppingCartFactory(cloneBaby));
    }
    
    public CartItemController findItem(Product prod) {
        for(CartItemController cartItem : cartsItems) {
            if(cartItem.getProduct().equals(prod)) {
                return cartItem;
            }
        }
        return null;
    }
    
    public ArrayList<CartItemController> getList() {
        return cartsItems;
    }
    
    public String getName() {
        return ShoppingCartName;
    }
    
    public void setName(String name) {
        this.ShoppingCartName = name;
=======
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
>>>>>>> 8b491138718ad3444935d1e9ad76f98fe90d192c
    }
}
