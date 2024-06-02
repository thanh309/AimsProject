package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        this.mediaType = "DVD";
        this.fields = new String[]{"title", "category", "director", "length", "cost"};

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
                        "DVD " + tfs.getFirst().getText() +  " added",
                        "Add DVD",
                        JOptionPane.INFORMATION_MESSAGE
                );
                try {
                    store.addMedia(new DigitalVideoDisc(
                            tfs.getFirst().getText(),
                            tfs.get(1).getText(),
                            tfs.get(2).getText(),
                            Integer.parseInt(tfs.get(3).getText()),
                            Float.parseFloat(tfs.get(4).getText())
                    ));
                } catch (LimitExceededException ignored) {}
            }
        }
        return new addToStoreListener();
    }
}
