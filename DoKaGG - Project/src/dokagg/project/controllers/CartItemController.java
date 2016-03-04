package dokagg.project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class CartItemController {
    
    @FXML private ImageView removeButton;
    @FXML private Text name;
    @FXML private TextField quantity;
    @FXML private ImageView quantityImage;
    @FXML private Text price;
    @FXML private Text totalCost;
}
