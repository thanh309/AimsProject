package hust.soict.dsai.aims.screen.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;
    private Store store;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label totalCost;

    @FXML
    private MenuItem menuViewStore;

    @FXML
    private MenuItem menuViewCart;

    public CartScreenController(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<>("cost"));
        // show the filtered list instead
        tblMedia.setItems(this.cart.getFilteredList());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                });
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia(newValue));

        totalCost.setText(String.format("%.2f", cart.totalCost()) + " $");
        this.cart.getItemsOrdered().addListener((ListChangeListener<? super Media>) change ->
                totalCost.setText(String.format("%.2f", cart.totalCost()) + " $"));
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order");
        alert.setHeaderText(null);
        alert.setContentText("Order has been placed.");
        alert.showAndWait();
        this.cart.getItemsOrdered().clear();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = this.tblMedia.getSelectionModel().getSelectedItem();
        ((Playable) media).play();
    }

    private Runnable windowCloser;

    public void setWindowCloser(Runnable windowCloser) {
        this.windowCloser = windowCloser;
    }

    @FXML
    void menuViewStorePressed(ActionEvent event) {
        new StoreScreen(store, cart);
        windowCloser.run();
    }

    @FXML
    void menuViewCartPressed(ActionEvent event) {
        new CartScreen(store, cart);
        windowCloser.run();
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    void showFilteredMedia(String query) {
        this.cart.getFilteredList().setPredicate(media -> {
            RadioButton selectedFilter = (RadioButton) filterCategory.getSelectedToggle();
            if (selectedFilter == radioBtnFilterTitle) {
                return media.getTitle().toLowerCase().contains(query.toLowerCase());
            }
            try {
                return media.getId() == Integer.parseInt(query);
            } catch (Exception e) {
                return false;
            }
        });
    }
}

