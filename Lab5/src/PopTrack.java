class PopTrack extends MusicTrack {
    private boolean hasDanceRhythm;

    public PopTrack(String title, String artist, int durationSeconds, boolean hasDanceRhythm) {
        super(title, artist, durationSeconds);
        this.hasDanceRhythm = hasDanceRhythm;
    }

    public boolean hasDanceRhythm() {
        return hasDanceRhythm;
    }

    public void setHasDanceRhythm(boolean hasDanceRhythm) {
        this.hasDanceRhythm = hasDanceRhythm;
    }

    @Override
    public String toString() {
        return "PopTrack{" +
                "hasDanceRhythm=" + hasDanceRhythm +
                "} " + super.toString();
    }
}
