import java.util.*;

public class ClothingManager {
    public static void main(String[] args) {
        List<Clothing> clothingList = new ArrayList<>();
        clothingList.add(new Clothing("T-Shirt", "Top", "M", "Red", 200));
        clothingList.add(new Clothing("Jeans", "Bottom", "L", "Blue", 300));
        clothingList.add(new Clothing("Jacket", "Outerwear", "X", "Black", 500));
        clothingList.add(new Clothing("Sweater", "Top", "S", "Green", 400));
        clothingList.add(new Clothing("Shorts", "Bottom", "M", "Yellow", 350));

        clothingList.sort(Comparator.comparing(Clothing::getType)
                .thenComparing(Comparator.comparing(Clothing::getPrice).reversed()));

        System.out.println("Sorted clothing list:");
        for (Clothing clothing : clothingList) {
            System.out.println(clothing);
        }

        Clothing targetClothing = new Clothing("Jeans", "Bottom", "L", "Blue", 300);

        boolean found = clothingList.contains(targetClothing);
        if (found) {
            System.out.println("\nTarget clothing found: " + targetClothing);
        } else {
            System.out.println("\nTarget clothing not found.");
        }
    }
}