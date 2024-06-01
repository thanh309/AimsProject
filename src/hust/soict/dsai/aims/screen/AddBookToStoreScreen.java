package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        this.mediaType = "book";
        this.fields = new String[]{"title", "category", "cost", "author list"};

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Add " + mediaType);
        setSize(1024, 768);
    }

    @Override
    protected ActionListener getAddToStoreListener(List<JTextField> tfs) {
        class addToStoreListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Book " + tfs.getFirst().getText() +  " added",
                        "Add book",
                        JOptionPane.INFORMATION_MESSAGE
                );
                store.addMedia(new Book(
                        tfs.getFirst().getText(),
                        tfs.get(1).getText(),
                        Integer.parseInt(tfs.get(2).getText()),
                        extractStrings(tfs.get(3).getText())
                ));
            }
        }
        return new addToStoreListener();
    }
}
