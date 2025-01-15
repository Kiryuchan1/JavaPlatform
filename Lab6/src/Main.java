import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            CustomLinkedList<MusicTrack> list1 = new CustomLinkedList<>();
            System.out.println("List 1 (empty): " + list1);

            MusicTrack track1 = new RockTrack("Highway to Hell", "AC/DC", 200, "Hard Rock");
            CustomLinkedList<MusicTrack> list2 = new CustomLinkedList<>(track1);
            System.out.println("List 2 (one element): " + list2);

            List<MusicTrack> trackList = new ArrayList<>(Arrays.asList(
                    new PopTrack("Shape of You", "Ed Sheeran", 230, true),
                    new ClassicalTrack("Moonlight Sonata", "Beethoven", 360, "Beethoven"),
                    new RockTrack("Bohemian Rhapsody", "Queen", 354, "Progressive Rock")
            ));
            CustomLinkedList<MusicTrack> list3 = new CustomLinkedList<>(trackList);
            System.out.println("List 3 (from collection): " + list3);

            System.out.println("List 3 size: " + list3.size());
            System.out.println("List 3 is empty: " + list3.isEmpty());
            System.out.println("List 3 contains Shape of You: " + list3.contains(new PopTrack("Shape of You", "Ed Sheeran", 230, true)));
            System.out.println("List 3 contains Bohemian Rhapsody: " + list3.contains(new RockTrack("Bohemian Rhapsody", "Queen", 354, "Progressive Rock")));

            list3.add(new PopTrack("Blinding Lights", "The Weeknd", 200, true));
            System.out.println("List 3 after adding: " + list3);

            list3.remove(new PopTrack("Shape of You", "Ed Sheeran", 230, true));
            System.out.println("List 3 after removing: " + list3);

            System.out.println("toString test " + list3.toString());

            List<MusicTrack> listAdd = new ArrayList<>(Arrays.asList(
                    new ClassicalTrack("The Four Seasons", "Vivaldi", 700, "Vivaldi"),
                    new PopTrack("Starboy", "The Weeknd", 250, false)));

            list3.addAll(1,listAdd);
            System.out.println("List 3 after adding with index and collection " + list3);

            List<MusicTrack> listAdd2 = new ArrayList<>(Arrays.asList(
                    new ClassicalTrack("Symphony No. 5", "Beethoven", 300, "Beethoven"),
                    new RockTrack("Back In Black", "AC/DC", 210, "Hard Rock")));
            list3.addAll(listAdd2);
            System.out.println("List 3 after adding with collection " + list3);

            List<MusicTrack> listRemove = new ArrayList<>(Arrays.asList(
                    new ClassicalTrack("The Four Seasons", "Vivaldi", 700, "Vivaldi"),
                    new PopTrack("Starboy", "The Weeknd", 250, false)
            ));
            list3.removeAll(listRemove);
            System.out.println("List 3 after removeAll with collection " + list3);

            List<MusicTrack> listRetain = new ArrayList<>(Arrays.asList(
                    new ClassicalTrack("Symphony No. 5", "Beethoven", 300, "Beethoven"),
                    new RockTrack("Back In Black", "AC/DC", 210, "Hard Rock"),
                    new RockTrack("Bohemian Rhapsody", "Queen", 354, "Progressive Rock"),
                    new PopTrack("Blinding Lights", "The Weeknd", 200, true)
            ));
            list3.retainAll(listRetain);
            System.out.println("List 3 after retainAll with collection " + list3);

            System.out.println("Element at index 1: " + list3.get(1));

            MusicTrack oldTrack = list3.set(0,new RockTrack("TNT","AC/DC",180,"Hard Rock"));
            System.out.println("List 3 after set: " + list3);
            System.out.println("Old track at index 0:" + oldTrack);


            list3.add(1, new ClassicalTrack("Für Elise", "Beethoven", 240, "Beethoven"));
            System.out.println("List 3 after add with index " + list3);

            MusicTrack removedTrack = list3.remove(2);
            System.out.println("List 3 after remove by index " + list3);
            System.out.println("Removed track from index 2:" + removedTrack);


            System.out.println("Index of track Back In Black: " + list3.indexOf(new RockTrack("Back In Black", "AC/DC", 210, "Hard Rock")));
            System.out.println("Index of track Für Elise: " + list3.indexOf(new ClassicalTrack("Für Elise", "Beethoven", 240, "Beethoven")));
            System.out.println("Index of track Shape of You: " + list3.indexOf(new PopTrack("Shape of You", "Ed Sheeran", 230, true)));

            System.out.println("Last index of track Back In Black: " + list3.lastIndexOf(new RockTrack("Back In Black", "AC/DC", 210, "Hard Rock")));
            System.out.println("Last index of track Für Elise: " + list3.lastIndexOf(new ClassicalTrack("Für Elise", "Beethoven", 240, "Beethoven")));
            System.out.println("Last index of track Shape of You: " + list3.lastIndexOf(new PopTrack("Shape of You", "Ed Sheeran", 230, true)));


            Object[] array1 = list3.toArray();
            System.out.println("Array: " + Arrays.toString(array1));

            MusicTrack[] array2 = list3.toArray(new MusicTrack[0]);
            System.out.println("Array: " + Arrays.toString(array2));

            MusicTrack[] array3 = new MusicTrack[list3.size() + 3];
            list3.toArray(array3);
            System.out.println("Array: " + Arrays.toString(array3));

            list3.clear();
            System.out.println("List 3 after clear: " + list3);

            list3.add(new RockTrack("Highway to Hell", "AC/DC", 200, "Hard Rock"));
            list3.add(new PopTrack("Blinding Lights", "The Weeknd", 200, true));
            System.out.print("Iteration: ");
            for(MusicTrack track : list3){
                System.out.print(track + ", ");
            }

        }
        catch (IllegalArgumentException | NullPointerException | IllegalStateException | IndexOutOfBoundsException | ArrayStoreException e){
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}