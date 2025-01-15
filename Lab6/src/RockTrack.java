class RockTrack extends MusicTrack {
    private String subgenre;

    public RockTrack(String title, String artist, int durationSeconds, String subgenre) {
        super(title, artist, durationSeconds);
        this.subgenre = subgenre;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    @Override
    public String toString() {
        return "RockTrack{" +
                "subgenre='" + subgenre + '\'' +
                "} " + super.toString();
    }
}