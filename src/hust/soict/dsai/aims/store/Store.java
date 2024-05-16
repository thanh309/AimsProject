package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    private static final int MAX_CAPACITY = 1000;
    private final List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media... mediaList) {
        if (itemsInStore.size() + mediaList.length > MAX_CAPACITY) {
            System.out.println("The store is full");
        } else {
            itemsInStore.addAll(Arrays.asList(mediaList));
            System.out.println("The item(s) has been added");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Item removed");
            return;
        }
        System.out.println("Item is not in store");
    }

    public int numberOfMedia() {
        return itemsInStore.size();
    }

    public void print() {
        System.out.println("-----------------------Store-----------------------");
        System.out.println("Number of item: " + numberOfMedia());
        System.out.println();
        for (Media media : itemsInStore) {
            System.out.println(media);
        }
        System.out.println("---------------------------------------------------");
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println(media);
                return media;
            }
        }
        System.out.printf("No item with title %s found.\n", title);
        return null;
    }
}
