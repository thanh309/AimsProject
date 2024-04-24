public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private int qtyOrdered = 0;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
            this.itemsOrdered[this.qtyOrdered] = disc;
            System.out.println("The disc has been added");
            this.qtyOrdered++;
        } else {
            System.out.println("The cart is full");
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

}


