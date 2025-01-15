public class Main {
    public static void main(String[] args) {
        Album album = new Album();
        try {
            album.addTrack(new RockTrack("Highway to Hell", "AC/DC", 200, "Hard Rock"));
            album.addTrack(new PopTrack("Shape of You", "Ed Sheeran", 230, true));
            album.addTrack(new ClassicalTrack("Moonlight Sonata", "Beethoven", 360, "Beethoven"));
            album.addTrack(new PopTrack("Blinding Lights", "The Weeknd", 200, true));
            album.addTrack(new RockTrack("Bohemian Rhapsody", "Queen", 354, "Progressive Rock"));
            album.addTrack(new ClassicalTrack("The Four Seasons", "Vivaldi", 700, "Vivaldi"));

            System.out.println("Original Album:\n" + album);
            System.out.println("Total Album Duration: " + album.getTotalDuration() + " seconds\n");

            album.sortByStyle();
            System.out.println("Album Sorted by Style:\n" + album);

            int minDuration = 200;
            int maxDuration = 300;
            System.out.println("Tracks with duration between " + minDuration + " and " + maxDuration + " seconds: \n" + album.findTracksByDuration(minDuration, maxDuration));
        }
        catch (IllegalArgumentException | NullPointerException | IllegalStateException e){
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}