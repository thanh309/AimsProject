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

    public int numberOfDiscs() {
        return itemsInStore.size();
    }
}
