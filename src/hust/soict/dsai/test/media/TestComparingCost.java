package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class TestComparingCost {
    public static void main(String[] args) {
        List<Media> dvds = new ArrayList<>();

        dvds.add(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        dvds.add(new DigitalVideoDisc("The Lion King", "Animation - VIP", "Roger Allers", 90, 25.50f));
        dvds.add(new DigitalVideoDisc("The Jungle Book", "Animation", "Wolfgang Reitherman", 80, 18.99f));
        dvds.add(new DigitalVideoDisc("The Jungle Book", "Animation - VIP", "Wolfgang Reitherman", 100, 25.50f));
        dvds.add(new DigitalVideoDisc("The Godfather", "Crime - VIP", "Francis Ford Coppola", 150, 30.0f));
        dvds.add(new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 110, 20.99f));

        // Testing comparators
        System.out.println("Sorted by title then cost:");
        dvds.sort(Media.COMPARE_BY_TITLE_COST);
        for (Media dvd : dvds) {
            System.out.println(dvd);
        }

        System.out.println("\nSorted by cost then title:");
        dvds.sort(Media.COMPARE_BY_COST_TITLE);
        for (Media dvd : dvds) {
            System.out.println(dvd);
        }
    }
}

