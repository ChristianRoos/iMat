package dokagg.project.controllers;

import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

public class CartItemController {
    
    @FXML public ImageView cartItemDelete;
    @FXML private Image removeImage;
    @FXML private Label cartItemName;
    @FXML private Label cartItemAmountField;
    @FXML private ImageView quantityImageView;
    @FXML private Image quantityImage;
    @FXML private Label cartItemPricePer;
    @FXML private Label cartItemTotal;
    
    @FXML public Pane whitePane;
    @FXML public Pane grayPane;
    
    @FXML private ShoppingCartController shoppingCart;
    @FXML private Product prod;
    private ShoppingItem prodAsShopItem;
    
    @FXML 
    public void giveData(ShoppingCartController shoppingCart, Product prod, 
            double quantity, ShoppingItem prodAsShopItem, boolean showRemoveButton) {
        this.shoppingCart = shoppingCart;
        this.prodAsShopItem = prodAsShopItem;
        this.prod = prod;

        // if added to history, remove the remove-button
        if(!showRemoveButton) {
            cartItemDelete.setVisible(false);
            cartItemDelete.setDisable(true);
        }
        
        cartItemName.setText(prod.getName());
        cartItemAmountField.setText(String.valueOf((int)quantity));
        cartItemPricePer.setText(String.valueOf(prod.getPrice()));
        double total = prod.getPrice()*quantity;
        cartItemTotal.setText(String.format(Locale.US, "%.2f", total));
    }
    
    public void removeItem(){
        shoppingCart.removeCartItem(this, prodAsShopItem);
    }
    
    public Product getProduct() {
        return prod;
    }
    
    public String getQuantity(){
        return cartItemAmountField.getText();
    }
    
    public ShoppingItem getShoppingItem(){
        return prodAsShopItem;
    }
    
    public void setQuantity(double quantity){
        cartItemAmountField.setText(String.valueOf((int)quantity));
        updateTotalCost();
    }
    
    public void updateTotalCost(){;
        
        double newTotalCost = prod.getPrice()*Double.valueOf(getQuantity());
//        cartItemTotal.setText(String.valueOf(newTotalCost));
        cartItemTotal.setText(String.format(Locale.US, "%.2f", newTotalCost));
    }
    
    public double getTotalCost() {
        return Double.valueOf(cartItemTotal.getText());
    }
}