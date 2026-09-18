// Author: Alvin Dong
// AI disclosure: AI was used to generate the majority of the documentation and
// the getter methods for the Building class and its subclasses. I have read the
// comments that Claude outputted to verify the accuracy of the function/constructor
// descriptions.

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Building> townBuildings = new ArrayList<>();
        Random rng = new Random();

        // 2 stores, 2 hotels with random addresses
        townBuildings.add(new Store("Walmart", generateStreetAddress(rng), 2000, "General"));
        townBuildings.add(new Store("Home Depot", generateStreetAddress(rng), 1000, "Hardware"));
        townBuildings.add(new Hotel("Marriott", generateStreetAddress(rng), 850, 16));
        townBuildings.add(new Hotel("Hilton", generateStreetAddress(rng), 600, 10));
        // 10 houses with random capacity and square footage
        for (int i = 0; i < 10; i++) {
            townBuildings.add(new House(generateStreetAddress(rng), rng.nextInt(6, 9), rng.nextInt(1100, 2000)));
        }
        // Print each building out
        // Each individual Building subclass has a custom toString method that overrides the base Building implementation
        // of the toString method.
        for (Building building : townBuildings) {
            System.out.println(building);
        }
    }
    
    /**
     * Generates a random street address with an ordinal street number (e.g. "123 45th Avenue").
     *
     * @param rng random source used to pick the house number, street number, and street type
     * @return a randomly generated street address
     */
    public static String generateStreetAddress(Random rng) {
        int streetNumber = rng.nextInt(1, 100);
        String finalText = "";
        if (streetNumber % 10 == 1) {
            finalText += streetNumber + "st";
        } else if (streetNumber % 10 == 2) {
            finalText += streetNumber + "nd";
        } else if (streetNumber % 10 == 3) {
            finalText += streetNumber + "rd";
        } else {
            finalText += streetNumber + "th";
        }
        if (rng.nextBoolean()) {
            finalText += " Avenue";
        } else {
            finalText += " Street";
        }
        finalText = "%d %s".formatted(rng.nextInt(1, 10000), finalText);
        return finalText;
    }
}
