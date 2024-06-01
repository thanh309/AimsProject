package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        this.mediaType = "CD";
        this.fields = new String[]{"title, category, director, cost, artist, tracks list, length list"};

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
                        "CD " + tfs.getFirst().getText() +  "added",
                        "Add CD",
                        JOptionPane.INFORMATION_MESSAGE
                );

                List<String> nameList = extractStrings(tfs.get(5).getText());
                List<Integer> lengthList = extractNumbers(tfs.get(6).getText());
                List<Track> trackList = new ArrayList<>();
                for (int i = 0; i < nameList.size(); i++) {
                    trackList.add(new Track(nameList.get(i), lengthList.get(i)));
                }

                store.addMedia(new CompactDisc(
                        tfs.getFirst().getText(),
                        tfs.get(1).getText(),
                        tfs.get(2).getText(),
                        Float.parseFloat(tfs.get(3).getText()),
                        tfs.get(4).getText(),
                        trackList
                ));
            }
        }
        return new addToStoreListener();
    }
}