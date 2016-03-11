package dokagg.project.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import se.chalmers.ait.dat215.project.*;

public class ShoppingCartController {

    @FXML public GridPane cartPane;
    @FXML public StackPane shoppingStackPane;

    @FXML public VBox cartList;
    @FXML public Button cartButton;
    @FXML public Button cartButtonSave;
    @FXML public ScrollPane cartScrollPane;
    @FXML public Pane cartGreyPane;
    @FXML public Pane cartGreyPane2;

    @FXML public Text cartTotalCost;
    @FXML public Text cartTextSum;
    @FXML public Text cartTextUSaved;
    @FXML public Text cartTextUSavedValue;
    @FXML public Line cartTheLine;
    private int numberOfItems = 0;

    private iMatController iMatController;
    public ArrayList<CartItemController> cartsItems = new ArrayList<>();
    private String ShoppingCartName;

    public void initShopCart(iMatController iMat, ArrayList<CartItemController> clonedCartList) {
        this.iMatController = iMat;

        // input is a clonedCart (for savedCarts & historyCarts)
        if (clonedCartList != null) {

            ArrayList<CartItemController> inputArray = new ArrayList<>(clonedCartList);

            for (CartItemController cartItem : inputArray) {
                cartList.getChildren().add(cartItemFactory(
                        cartItem.getProduct(),
                        Double.valueOf(cartItem.getQuantity()),
                        cartItem.getShoppingItem(),
                        true));

                String oldTotal = cartTotalCost.getText();
                double newTotal = Double.valueOf(oldTotal)
                        + cartItem.getProduct().getPrice() * Double.valueOf(cartItem.getQuantity());
                String newTotalString = String.format(Locale.US, "%.2f", newTotal);
                cartTotalCost.setText(newTotalString);
            }
        }
    }

    // CartItemController factory.
    private AnchorPane cartItemFactory(Product prod, double quantity, ShoppingItem prodAsShopItem, boolean showRemoveButton) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dokagg/project/fxml/cartItem.fxml"));
        AnchorPane cartItem = null;

        try {
            cartItem = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CartItemController cartItemController = loader.getController();
        cartItemController.giveData(this, prod, quantity, prodAsShopItem, showRemoveButton);

        cartsItems.add(cartItemController);
        numberOfItems++;
        showgrayLine();
        return cartItem;
    }

    public void addCartItem(Product prod, double quantity, ShoppingItem prodAsShopItem, boolean showRemoveButton) {
        cartList.getChildren().add(cartItemFactory(prod, quantity, prodAsShopItem, showRemoveButton));
    }

    public void removeCartItem(CartItemController cartItemContr, ShoppingItem prodAsShopItem) {
        cartsItems.remove(cartItemContr);
        cartList.getChildren().clear();
        int cartLength = cartsItems.size();

        for (int i = 0; cartLength > i; i++) {
            cartList.getChildren().add(cartItemFactory(
                    cartsItems.get(i).getProduct(),
                    Double.valueOf(cartsItems.get(i).getQuantity()),
                    cartsItems.get(i).getShoppingItem(),
                    true));
        }
        for (int i = 0; cartLength > i; i++) {
            cartsItems.remove(0);
        }
        
        String oldTotal = cartTotalCost.getText();
        double newTotal = Double.valueOf(oldTotal)
                - cartItemContr.getProduct().getPrice() * Double.valueOf(cartItemContr.getQuantity());
        String newTotalString = String.format(Locale.US, "%.2f", newTotal);
        cartTotalCost.setText(newTotalString);
        
        numberOfItems--;
        showgrayLine();
    }

    public void cartCheckoutButton() {
        ArrayList<CartItemController> cloneBaby = new ArrayList<>(cartsItems);
        ShoppingCartController newShoppingCart = iMatController.shoppingCartFactory(cloneBaby);

        newShoppingCart.cartButton.visibleProperty().set(false);
        newShoppingCart.cartButton.disableProperty().set(true);

        newShoppingCart.cartButtonSave.visibleProperty().set(false);
        newShoppingCart.cartButtonSave.disableProperty().set(true);

        newShoppingCart.cartTextSum.setVisible(false);
        newShoppingCart.cartTextUSaved.setVisible(false);
        newShoppingCart.cartTextUSavedValue.setVisible(false);
        newShoppingCart.cartTheLine.setVisible(false);
        newShoppingCart.cartTotalCost.setVisible(false);
        iMatController.cartCheckoutButton(newShoppingCart);
    }

    public void favoriteShoppingCart() {
        iMatController.saveShoppingCart(cartsItems);
    }

    public CartItemController findItem(Product prod) {
        for (CartItemController cartItem : cartsItems) {
            if (cartItem.getProduct().equals(prod)) {
                return cartItem;
            }
        }
        return null;
    }
    
    // Method to make gray-striped cart.
    public void showgrayLine() {
        
        int tempInt = numberOfItems;
        
        for (CartItemController cartItem : cartsItems) {
            if(tempInt % 2 == 0) {
                cartItem.grayPane.setVisible(false);
                tempInt++;
            } else {
                cartItem.grayPane.setVisible(true);
                tempInt++;
            }
        }
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
