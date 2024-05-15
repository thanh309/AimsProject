package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars: Episode IV", "Sci-Fi", "George Lucas", 121, 14.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 17.50f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 22.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 19.99f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.50f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Lord of the Rings", "Fantasy", "Peter Jackson", 201, 29.95f);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 18.99f);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Amélie", "Comedy", "Jean-Pierre Jeunet", 120, 16.50f);
        DigitalVideoDisc dvd10 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "The Wachowski Brothers", 136, 21.95f);

        Store store = new Store();
        store.addMedia(dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7, dvd8);

        System.out.println("Number of discs in store: " + store.numberOfDiscs());

        store.removeMedia(dvd2);
        store.removeMedia(dvd4);
        store.removeMedia(dvd9);
        System.out.println("Number of discs in store now: " + store.numberOfDiscs());
    }
}
