package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {

    private static final Store store = new Store();
    private static final Cart cart = new Cart();
    private static Scanner scanner;

    private void initializeStore() {

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
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        scanner.close();
    }
}
