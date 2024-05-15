package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        // Try to remove dvd from an empty cart
        anOrder.removeMedia(dvd1);

        anOrder.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addMedia(dvd3);

        // Print total cost of the items in the cart
        System.out.println("Total Cost is: " + anOrder.totalCost());

        DigitalVideoDisc randomDvd = new DigitalVideoDisc("random");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("untitled4", "dvd", 10f);

        // Try to remove a random dvd
        anOrder.removeMedia(randomDvd);

        // Remove dvd2 and recalculate the total cost
        anOrder.removeMedia(dvd2);
        System.out.println("Total Cost after removing dvd2 is: " + anOrder.totalCost());

        // Add 5 copy of dvd4 to make sure the removal is done properly
        for (int i = 0; i < 5; i++) {
            anOrder.addMedia(dvd4);
        }
        System.out.println("Total Cost after adding 5 dvd4 is: " + anOrder.totalCost());
    }
}
