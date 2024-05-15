package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
        } else {
            itemsOrdered.add(media);
            System.out.println("The item has been added");
        }
    }

    public void addMedia(Media... mediaList) {
        if (itemsOrdered.size() + mediaList.length > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
        } else {
            itemsOrdered.addAll(Arrays.asList(mediaList));
        }
    }


    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Item removed");
            return;
        }
        System.out.println("Item is not in cart");
    }

    public float totalCost() {
        float result = 0;
        for (Media media : itemsOrdered) {
            result += media.getCost();
        }
        return result;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println(i + ". " + media);
            i++;
        }
        System.out.println("Total cost: $" + totalCost());
        System.out.println("**************************************************");
    }

    public void searchByID(int id) {
        for (Media media : itemsOrdered) {
            if (id == media.getId()) {
                System.out.println(media);
                return;
            }
        }
        System.out.printf("No item with id %d found.\n", id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                found = true;
                System.out.println(media);
            }
        }
        if (!found) System.out.printf("No item with title %s found.\n", title);
    }

}


