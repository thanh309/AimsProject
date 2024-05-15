package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
            this.itemsOrdered[this.qtyOrdered] = disc;
            System.out.println("The disc has been added");
            this.qtyOrdered++;
        } else {
            System.out.println("The cart is full");
        }
    }

//    public void addDigitalVideoDisc(hust.soict.dsai.aims.media.DigitalVideoDisc[] dvdList) {
//        if (qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED) {
//            System.out.println("The cart is full");
//        } else {
//            for (hust.soict.dsai.aims.media.DigitalVideoDisc disc : dvdList) {
//                itemsOrdered[qtyOrdered] = disc;
//                qtyOrdered++;
//            }
//            System.out.println("The discs has been added");
//        }
//    }

    public void addDigitalVideoDisc(DigitalVideoDisc... discs) {
        if (qtyOrdered + discs.length > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
        } else {
            for (DigitalVideoDisc disc : discs) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
            }
            System.out.println("The discs has been added");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
        } else {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The discs has been added");
        }
    }

    private int findDiscIndex(DigitalVideoDisc disc) {
        for (int i = 0; i < this.qtyOrdered; i++) {
            if (this.itemsOrdered[i] == disc) return i;
        }
        return -1;
    }

    private void swapDisc(int i, int j) {
        DigitalVideoDisc tempDisc = this.itemsOrdered[i];
        this.itemsOrdered[i] = this.itemsOrdered[j];
        this.itemsOrdered[j] = tempDisc;
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int index = findDiscIndex(disc);
        if (index == -1) {
            System.out.println("Disc is not in cart");
        } else {
            System.out.println("Disc removed");
            this.qtyOrdered--;
            swapDisc(index, this.qtyOrdered);
            this.itemsOrdered[this.qtyOrdered] = null;
        }
    }

    public float totalCost() {
        float result = 0;
        for (int i = 0; i < this.qtyOrdered; i++) {
            result += this.itemsOrdered[i].getCost();
        }
        return result;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 1; i <= qtyOrdered; i++) {
            System.out.println(i + ". " + itemsOrdered[i - 1]);
        }
        System.out.println("Total cost: $" + totalCost());
        System.out.println("**************************************************");
    }

    public void searchByID(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (id == itemsOrdered[i].getId()) {
                System.out.println(itemsOrdered[i]);
                return;
            }
        }
        System.out.printf("No DVD with id %d found.\n", id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                found = true;
                System.out.println(itemsOrdered[i]);
            }
        }
        if (!found) System.out.printf("No DVD with title %s found.\n", title);
    }

}

