package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.swing_component.MediaStore;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StoreScreen extends JFrame {

    protected Store store;
    protected Cart cart;
    private int currentPage = 0;
    private final int itemsPerPage = 9;
    private JPanel centerPanel;
    private JButton btnPrevious, btnNext;

    public StoreScreen() {
    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createSouth(), BorderLayout.SOUTH);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public Store getStore() {
        return store;
    }

    public Cart getCart() {
        return cart;
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem menuAddBook = new JMenuItem("Add Book");
        menuAddBook.addActionListener(new addBookListener());
        smUpdateStore.add(menuAddBook);

        JMenuItem menuAddCD = new JMenuItem("Add CD");
        smUpdateStore.add(menuAddCD);
        menuAddCD.addActionListener(new addCDListener());

        JMenuItem menuAddDVD = new JMenuItem("Add DVD");
        menuAddDVD.addActionListener(new addDVDListener());
        smUpdateStore.add(menuAddDVD);

        menu.add(smUpdateStore);
        JMenuItem menuViewStore = new JMenuItem("View store");
        menuViewStore.addActionListener(new viewStoreListener());
        menu.add(menuViewStore);

        JMenuItem menuViewCart = new JMenuItem("View cart");
        menuViewCart.addActionListener(new viewCartListener());
        menu.add(menuViewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.addActionListener(new viewCartListener());
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3, 2, 2));
        updateCenterPanel();
        return centerPanel;
    }

    JPanel createSouth() {
        JPanel south = new JPanel();
        south.setLayout(new FlowLayout(FlowLayout.CENTER));

        btnPrevious = new JButton("Previous");
        btnPrevious.addActionListener(e -> {
            if (currentPage > 0) {
                currentPage--;
                updateCenterPanel();
            }
        });

        btnNext = new JButton("Next");
        btnNext.addActionListener(e -> {
            if ((currentPage + 1) * itemsPerPage < store.getItemsInStore().size()) {
                currentPage++;
                updateCenterPanel();
            }
        });

        south.add(btnPrevious);
        south.add(btnNext);

        updateNavigationButtons();

        return south;
    }

    void updateCenterPanel() {
        centerPanel.removeAll();
        List<Media> mediaInStore = store.getItemsInStore();
        int start = currentPage * itemsPerPage;
        int end = Math.min(start + itemsPerPage, mediaInStore.size());
        for (int i = start; i < end; i++) {
            centerPanel.add(new MediaStore(mediaInStore.get(i), this));
        }
        for (int i = end; i < start + itemsPerPage; i++) {
            centerPanel.add(new JPanel());
        }
        centerPanel.revalidate();
        centerPanel.repaint();
        updateNavigationButtons();
    }

    void updateNavigationButtons() {
        if (btnPrevious != null) {
            btnPrevious.setEnabled(currentPage > 0);
        }
        if (btnNext != null) {
            btnNext.setEnabled((currentPage + 1) * itemsPerPage < store.getItemsInStore().size());
        }
    }

    protected class viewCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new CartScreen(store, cart);
        }
    }

    protected class viewStoreListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new StoreScreen(store, cart);
        }
    }

    protected class addBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddBookToStoreScreen(store, cart);
        }
    }

    protected class addCDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddCompactDiscToStoreScreen(store, cart);
        }
    }

    protected class addDVDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store, cart);
        }
    }

    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd1vip = new DigitalVideoDisc("The Lion King", "Animation - VIP", "Roger Allers", 90, 29.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars: Episode IV", "Sci-Fi", "George Lucas", 121, 14.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 17.50f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 22.95f);
        DigitalVideoDisc dvd4vip = new DigitalVideoDisc("The Godfather", "Crime - VIP", "Francis Ford Coppola", 250, 30.0f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 19.99f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.50f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Lord of the Rings", "Fantasy", "Peter Jackson", 201, 29.95f);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 18.99f);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Amélie", "Comedy", "Jean-Pierre Jeunet", 120, 16.50f);
        DigitalVideoDisc dvd10 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "The Wachowski Brothers", 136, 21.95f);

        CompactDisc cd = new CompactDisc("Queen Best Songs", "Music", "None", 60, "Queen");

        cd.addTrack(new Track("Bohemian Rhapsody", 540));
        cd.addTrack(new Track("Another One Bites the Dust", 330));
        cd.addTrack(new Track("Killer Queen", 300));
        cd.addTrack(new Track("We Will Rock You", 200));
        cd.addTrack(new Track("Don't Stop Me Now", 350));

        Book book = new Book("Good Omens", "Novel", 15.99f);
        book.addAuthor("Terry Pratchett");
        book.addAuthor("Neil Gaiman");

        store.addMedia(dvd1, dvd1vip, dvd2, dvd3, dvd4, dvd4vip, dvd5, dvd6, dvd7, dvd8, dvd9, dvd10, cd, book);

        StoreScreen storeScreen = new StoreScreen(store, new Cart());
    }
}
