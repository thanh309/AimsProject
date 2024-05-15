package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
    private static final int MAX_CAPACITY = 1000;
    private final DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_CAPACITY];
    private int quantity = 0;

    public void addDVD(DigitalVideoDisc... discs) {
        if (quantity + discs.length > MAX_CAPACITY) {
            System.out.println("The store is full");
        } else {
            for (DigitalVideoDisc disc : discs) {
                itemsInStore[quantity] = disc;
                quantity++;
            }
            System.out.println("The disc(s) has been added");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        int index = findDiscIndex(disc);
        if (index == -1) {
            System.out.println("Disc is not in store");
        } else {
            System.out.println("Disc removed");
            quantity--;
            swapDisc(index, quantity);
            itemsInStore[quantity] = null;
        }
    }

    private int findDiscIndex(DigitalVideoDisc disc) {
        for (int i = 0; i < quantity; i++) {
            if (itemsInStore[i] == disc) return i;
        }
        return -1;
    }

    private void swapDisc(int i, int j) {
        DigitalVideoDisc tempDisc = itemsInStore[i];
        itemsInStore[i] = itemsInStore[j];
        itemsInStore[j] = tempDisc;
    }

    public int numberOfDiscs() {
        return quantity;
    }
}
