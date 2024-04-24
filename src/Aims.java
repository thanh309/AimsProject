public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        // Try to remove dvd from an empty cart
        anOrder.removeDigitalVideoDisc(dvd1);

        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // Print total cost of the items in the cart
        System.out.println("Total Cost is: " + anOrder.totalCost());

        DigitalVideoDisc randomDvd = new DigitalVideoDisc("random");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("untitled4", "dvd", 10f);

        // Try to remove a random dvd
        anOrder.removeDigitalVideoDisc(randomDvd);

        // Remove dvd2 and recalculate the total cost
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total Cost after removing dvd2 is: " + anOrder.totalCost());

        // Add 5 copy of dvd4 to make sure the removal is done properly
        for (int i = 0; i < 5; i++) {
            anOrder.addDigitalVideoDisc(dvd4);
        }
        System.out.println("Total Cost after adding 5 dvd4 is: " + anOrder.totalCost());
    }
}
