class PunctuationMark {
    private final String value;

    public PunctuationMark(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Розділовий знак не може бути пустим або null.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}