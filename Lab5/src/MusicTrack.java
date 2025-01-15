import java.util.Objects;

class MusicTrack {
    private String title;
    private String artist;
    private int durationSeconds;

    public MusicTrack(String title, String artist, int durationSeconds) {
        if (durationSeconds <= 0) {
            throw new IllegalArgumentException("Duration must be positive.");
        }
        this.title = title;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        if (durationSeconds <= 0) {
            throw new IllegalArgumentException("Duration must be positive.");
        }
        this.durationSeconds = durationSeconds;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MusicTrack that = (MusicTrack) obj;
        return durationSeconds == that.durationSeconds &&
                Objects.equals(title, that.title) &&
                Objects.equals(artist, that.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, durationSeconds);
    }

    @Override
    public String toString() {
        return "MusicTrack{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", durationSeconds=" + durationSeconds +
                '}';
    }
}