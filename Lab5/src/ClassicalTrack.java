class ClassicalTrack extends MusicTrack {
    private String composer;

    public ClassicalTrack(String title, String artist, int durationSeconds, String composer) {
        super(title, artist, durationSeconds);
        this.composer = composer;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    @Override
    public String toString() {
        return "ClassicalTrack{" +
                "composer='" + composer + '\'' +
                "} " + super.toString();
    }
}