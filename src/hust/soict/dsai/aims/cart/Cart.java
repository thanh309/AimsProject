package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final List<Media> itemsOrdered = new ArrayList<>();

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
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }
        System.out.println("Total cost: $" + totalCost());
        System.out.println("**************************************************");
    }

    public Media searchByID(int id) {
        for (Media media : itemsOrdered) {
            if (id == media.getId()) {
                System.out.println(media);
                return media;
            }
        }
        System.out.printf("No item with id %d found.\n", id);
        return null;
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println(media);
                return media;
            }
        }
        System.out.printf("No item with title %s found.\n", title);
        return null;
    }

    public void sort(boolean byCostTitle) {
        if (byCostTitle) {
            itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
            return;
        }
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void filter(String query) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(media);
            }
        }
    }
}


