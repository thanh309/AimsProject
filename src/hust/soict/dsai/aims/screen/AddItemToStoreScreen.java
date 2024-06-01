package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class AddItemToStoreScreen extends StoreScreen {

    protected String mediaType;
    protected String[] fields;
    protected JButton btnAddToStore;

    public AddItemToStoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @Override
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Add " + this.mediaType);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());

        return header;
    }

    JPanel createCustomCenter(String... fields) {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 1, 0, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 25, 25, 25));

        List<JTextField> tfs = new ArrayList<>();

        for (String field : fields) {
            JLabel labelField = new JLabel(field.substring(0, 1).toUpperCase() + field.substring(1));
            labelField.setFont(new Font(labelField.getFont().getName(), Font.BOLD, 18));
            inputPanel.add(labelField);

            JTextField tf = new JTextField();
            inputPanel.add(tf);
            tfs.add(tf);
        }

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel tfTitleDisplay = new JLabel("Add " + mediaType + " to store");
        tfTitleDisplay.setFont(new Font(tfTitleDisplay.getFont().getName(), Font.BOLD, 20));
        tfTitleDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.btnAddToStore = new JButton("Add " + mediaType);
        btnAddToStore.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAddToStore.addActionListener(getAddToStoreListener(tfs));

        mainPanel.add(tfTitleDisplay);
        mainPanel.add(inputPanel);
        mainPanel.add(btnAddToStore);

        return mainPanel;
    }

    @Override
    JPanel createCenter() {
        return createCustomCenter(fields);
    }

    protected abstract ActionListener getAddToStoreListener(List<JTextField> tfs);

    protected static List<String> extractStrings(String namesString) {
        String[] stringArray = namesString.split(",");
        List<String> stringList = new ArrayList<>();
        for (String string : stringArray) {
            stringList.add(string.trim());
        }
        return stringList;
    }

    protected static List<Integer> extractNumbers(String numberString) {
        String[] numbersArray = numberString.split(",");
        List<Integer> numbersList = new ArrayList<>();
        for (String number : numbersArray) {
            String trimmedNumber = number.trim();
            numbersList.add(Integer.parseInt(trimmedNumber));
        }
        return numbersList;
    }
}

