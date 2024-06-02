package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Aims {

    private static final Store store = new Store();
    private static final Cart cart = new Cart();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Store availableMedia = new Store();
    private static final String line = "--------------------------------";
    private static int choice;
    private static List<Integer> acceptedChoices;

    private static void initializeStore() throws LimitExceededException {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd1vip = new DigitalVideoDisc("The Lion King", "Animation - VIP", "Roger Allers", 90, 29.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars: Episode IV", "Sci-Fi", "George Lucas", 121, 14.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 17.50f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 22.95f);
        DigitalVideoDisc dvd4vip = new DigitalVideoDisc("The Godfather", "Crime - VIP", "Francis Ford Coppola", 250, 30.0f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", -2, 19.99f);
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

        store.addMedia(dvd1, dvd1vip, dvd2, dvd3, dvd4, dvd4vip, dvd5, dvd6, dvd7, cd, book);
        availableMedia.addMedia(dvd1, dvd1vip, dvd2, dvd3, dvd4, dvd4vip, dvd5, dvd6, dvd7, dvd8, dvd9, dvd10, cd, book);
    }

    public static void main(String[] args) throws LimitExceededException, PlayerException {
        initializeStore();
        clearScreen();
        showMenu();
    }

    public static void showMenu() throws LimitExceededException, PlayerException {
        clearScreen();
        System.out.println("AIMS: ");
        System.out.println(line);
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println(line);

        acceptedChoices = new ArrayList<>(Arrays.asList(0, 1, 2, 3));

        do {
            System.out.println("Please choose a number: 0-1-2-3");
            choice = scanner.nextInt();
            scanner.nextLine();
        } while (!acceptedChoices.contains(choice));

        switch (choice) {
            case 0:
                exit();
                break;
            case 1:
                storeMenu();
                break;
            case 2:
                updateStoreMenu();
                break;
            case 3:
                cartMenu();
                break;
        }
    }

    private static void cartMenu() throws LimitExceededException, PlayerException {
        clearScreen();
        cart.print();
        System.out.println();

        System.out.println("Options: ");
        System.out.println(line);
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println(line);

        acceptedChoices = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));

        do {
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            choice = scanner.nextInt();
            scanner.nextLine();
        } while (!acceptedChoices.contains(choice));

        switch (choice) {
            case 0:
                showMenu();
                break;
            case 1:
                filterCartApp();
                break;
            case 2:
                sortCartMenu();
                break;
            case 3:
                removeFromCartApp();
                break;
            case 4:
                playMediaApp();
                break;
            case 5:
                placeOrderMenu();
                break;
        }
    }

    private static void placeOrderMenu() throws LimitExceededException, PlayerException {
        clearScreen();
        System.out.println("Your order has been created successfully.");
        System.out.println();
        System.out.println("Options: ");
        System.out.println(line);
        System.out.println("1. Back to menu");
        System.out.println("0. Exit");
        System.out.println(line);

        acceptedChoices = new ArrayList<>(Arrays.asList(0, 1));

        do {
            System.out.println("Please choose a number: 0-1");
            choice = scanner.nextInt();
            scanner.nextLine();
        } while (!acceptedChoices.contains(choice));

        switch (choice) {
            case 0:
                exit();
                break;
            case 1:
                showMenu();
                break;
        }
    }

    private static void removeFromCartApp() throws LimitExceededException, PlayerException {
        clearScreen();
        cart.print();
        String input;


        System.out.println();
        System.out.println("Enter the title to remove, or 0 to go back to cart");
        input = scanner.nextLine().trim();

        if (input.equals("0")) {
            cartMenu();
            return;
        }

        System.out.println("Searching...");
        Media toRemove = cart.searchByTitle(input);
        System.out.println();
        if (toRemove != null) {
            cart.removeMedia(toRemove);
        }
        removeFromCartApp();

    }

    private static void sortCartMenu() throws LimitExceededException, PlayerException {
        clearScreen();
        System.out.println("Options: ");
        System.out.println(line);
        System.out.println("1. Sort by title-cost");
        System.out.println("2. Sort by cost-title");
        System.out.println("0. Back");
        System.out.println(line);

        acceptedChoices = new ArrayList<>(Arrays.asList(0, 1, 2));

        do {
            System.out.println("Please choose a number: 0-1-2");
            choice = scanner.nextInt();
            scanner.nextLine();
        } while (!acceptedChoices.contains(choice));

        switch (choice) {
            case 0:
                cartMenu();
                return;
            case 1:
                cart.sort(false);
                System.out.println("Cart sorted");
                cart.print();
                break;
            case 2:
                cart.sort(true);
                System.out.println("Cart sorted");
                cart.print();
                break;
        }

        System.out.println();
        System.out.println("Press any key to return to cart");
        scanner.nextLine();
        cartMenu();
    }

    private static void filterCartApp() throws LimitExceededException, PlayerException {
        clearScreen();
        String input;

        acceptedChoices = new ArrayList<>(Arrays.asList(1, 2));

        do {
            System.out.println("Choose 1 to filter by ID, 2 to filter by title");
            choice = scanner.nextInt();
            scanner.nextLine();
        } while (!acceptedChoices.contains(choice));

        System.out.println("Enter query:");

        if (choice == 2) {
            input = scanner.nextLine().trim();
            cart.filter(input);
        } else {
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println(cart.searchByID(choice));
        }

        System.out.println();
        System.out.println("Choose 0 to go back to cart, or any other keys to continue");
        input = scanner.nextLine().trim();
        if (input.equals("0")) {
            cartMenu();
            return;
        }
        filterCartApp();

    }

    private static void updateStoreMenu() throws LimitExceededException, PlayerException {
        clearScreen();
        store.print();
        System.out.println();

        System.out.println("Options: ");
        System.out.println(line);
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println(line);

        acceptedChoices = new ArrayList<>(Arrays.asList(0, 1, 2));

        do {
            System.out.println("Please choose a number: 0-1-2");
            choice = scanner.nextInt();
            scanner.nextLine();
        } while (!acceptedChoices.contains(choice));

        switch (choice) {
            case 0:
                showMenu();
                break;
            case 1:
                addToStoreApp();
                break;
            case 2:
                removeFromStoreApp();
                break;
        }
    }

    private static void removeFromStoreApp() throws LimitExceededException, PlayerException {
        clearScreen();
        store.print();
        String input;

        while (true) {
            System.out.println();
            System.out.println("Enter the title to remove, or 0 to go back");
            input = scanner.nextLine().trim();

            if (input.equals("0")) {
                updateStoreMenu();
                return;
            }

            System.out.println("Searching...");
            Media toRemove = store.searchByTitle(input);
            System.out.println();
            if (toRemove != null) {
                store.removeMedia(toRemove);
            }
        }

    }

    private static void addToStoreApp() throws LimitExceededException, PlayerException {
        clearScreen();
        System.out.println("All available media:");
        availableMedia.print();

        System.out.println();
        System.out.println("Enter the title to add, or 0 to go back:");
        String query = scanner.nextLine().trim();

        if (query.equals("0")) {
            updateStoreMenu();
            return;
        }

        System.out.println("Searching...");
        Media toAdd = availableMedia.searchByTitle(query);
        System.out.println();
        if (toAdd != null) {
            store.addMedia(toAdd);
        }

    }

    private static void storeMenu() throws LimitExceededException, PlayerException {
        clearScreen();
        store.print();
        System.out.println();

        System.out.println("Options: ");
        System.out.println(line);
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println(line);

        acceptedChoices = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));

        do {
            System.out.println("Please choose a number: 0-1-2-3-4");
            choice = scanner.nextInt();
            scanner.nextLine();
        } while (!acceptedChoices.contains(choice));

        switch (choice) {
            case 0:
                showMenu();
                break;
            case 1:
                mediaDetailsMenu();
                break;
            case 2:
                addToCartApp();
                break;
            case 3:
                playMediaApp();
                break;
            case 4:
                cartMenu();
                break;
        }
    }

    private static void playMediaApp() throws LimitExceededException, PlayerException {
        clearScreen();
        System.out.println("All available media:");
        availableMedia.print();
        while (true) {
            System.out.println();
            System.out.println("Enter the title of media to play, or 0 to go back to store menu:");
            String query = scanner.nextLine().trim();

            if (query.equals("0")) {
                storeMenu();
                return;
            }

            System.out.println("Searching...");
            Media toPlay = store.searchByTitle(query);
            if (toPlay != null) {
                ((Playable) toPlay).play();
            }
        }
    }

    private static void addToCartApp() throws LimitExceededException, PlayerException {
        clearScreen();
        System.out.println("All available media in store:");
        store.print();

        System.out.println();
        System.out.println("Enter the title to add, or 0 to go back:");
        String query = scanner.nextLine().trim();

        if (query.equals("0")) {
            storeMenu();
            return;
        }

        System.out.println("Searching...");
        Media toAdd = availableMedia.searchByTitle(query);
        System.out.println();
        if (toAdd != null) {
            store.addMedia(toAdd);
        }
    }

    private static void mediaDetailsMenu() throws LimitExceededException, PlayerException {
        clearScreen();
        while (true) {
            System.out.println();
            System.out.println("Enter the title of media to see details, or 0 to go back to store menu:");
            String query = scanner.nextLine().trim();

            if (query.equals("0")) {
                storeMenu();
                return;
            }

            System.out.println("Searching...");
            store.searchByTitle(query);
        }
    }

    public static void clearScreen() {
        System.out.println(new String(new char[100]).replace("\0", "\r\n"));
        System.out.flush();
    }

    public static void exit() {
        System.out.println("Exiting...");
        scanner.close();
        System.exit(0);
    }

}

