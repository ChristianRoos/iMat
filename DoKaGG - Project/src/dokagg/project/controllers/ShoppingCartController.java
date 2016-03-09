package dokagg.project.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.*;

public class ShoppingCartController {
    
    @FXML public GridPane cartPane;
    @FXML public Text cartTotalCost;
    @FXML private VBox cartList;
    @FXML private Button cartButton;
    @FXML private Button cartButtonSave;
    
    private iMatController iMatController;
    public ArrayList<CartItemController> cartsItems = new ArrayList<>();
    private String ShoppingCartName;
    
    public void initShopCart(iMatController iMat, ArrayList<CartItemController> clonedCartList) {
        this.iMatController = iMat;
        
        // input is a clonedCart (for savedCarts & historyCarts)
        if(clonedCartList != null){
            cartsItems = clonedCartList;

//            ArrayList<AnchorPane> newList = new ArrayList<>();
            ArrayList<CartItemController> inputArray = new ArrayList<>(clonedCartList);

            for(CartItemController cartItem : inputArray) {
                cartList.getChildren().add(cartItemFactory(
                        cartItem.getProduct(), 
                        Double.valueOf(cartItem.getQuantity()), 
                        cartItem.getShoppingItem()));
            }
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
        ArrayList<CartItemController> cloneBaby = new ArrayList<>(cartsItems);
        ShoppingCartController newShoppingCart = iMatController.shoppingCartFactory(cloneBaby);
        iMatController.cartCheckoutButton(newShoppingCart);
    }
    
    public void favoriteShoppingCart() {
        ArrayList<CartItemController> cloneBaby = new ArrayList<>(cartsItems);
        ShoppingCartController shoppingCart = iMatController.shoppingCartFactory(cloneBaby);
        
        shoppingCart.cartButton.visibleProperty().set(false);
        shoppingCart.cartButton.disableProperty().set(true);
        
        shoppingCart.cartButtonSave.visibleProperty().set(false);
        shoppingCart.cartButtonSave.disableProperty().set(true);
        
        Button makeCurrentCart = new Button();
        
        shoppingCart.cartPane.add(makeCurrentCart, 0, 2);
        makeCurrentCart.setTranslateY(-100);
        
        iMatController.shoppingCartsSaved.add(shoppingCart);
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
