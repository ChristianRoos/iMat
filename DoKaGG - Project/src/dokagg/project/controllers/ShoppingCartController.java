package dokagg.project.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.*;

public class ShoppingCartController {
    
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
        
        try {
            cartItem = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        CartItemController cartItemController = loader.getController();
        cartItemController.giveData(this, prod, quantity, prodAsShopItem);
        
        cartsItems.add(cartItemController);
        
        return cartItem;
   }
    
    public void addCartItem(Product prod, double quantity, ShoppingItem prodAsShopItem) {
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
    }
}
