import java.util.ArrayList;
import java.util.List;

class Sentence {
    private final List<Object> parts;

    public Sentence(List<Object> parts) {
        if (parts == null || parts.isEmpty()) {
            throw new IllegalArgumentException("Речення не може бути пустим або null.");
        }
        this.parts = new ArrayList<>(parts);
    }

    public Sentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("Речення не може бути пустим або null.");
        }
        this.parts = new ArrayList<>();
        String[] elements = sentence.trim().split("(?<=[\\s.,;?!])|(?=[\\s.,;?!])");
        for (String element : elements) {
            String trimmedElement = element.trim();
            if (trimmedElement.isEmpty()) continue;
            if (trimmedElement.matches("[\\s.,;?!]+")) {
                this.parts.add(new PunctuationMark(trimmedElement));
            } else {
                this.parts.add(new Word(trimmedElement));
            }
        }
    }

    public List<Object> getParts() {
        return new ArrayList<>(parts);
    }

    public void swapFirstAndLastWords() {
        if (parts.size() < 2) {
            return;
        }

        int firstWordIndex = -1;
        int lastWordIndex = -1;

        for (int i = 0; i < parts.size(); i++) {
            if (parts.get(i) instanceof Word) {
                firstWordIndex = i;
                break;
            }
        }

        for (int i = parts.size() - 1; i >= 0; i--) {
            if (parts.get(i) instanceof Word) {
                lastWordIndex = i;
                break;
            }
        }
        if (firstWordIndex != -1 && lastWordIndex != -1 && firstWordIndex != lastWordIndex) {
            Object temp = parts.get(firstWordIndex);
            parts.set(firstWordIndex, parts.get(lastWordIndex));
            parts.set(lastWordIndex, temp);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object part : parts) {
            sb.append(part).append(" ");
        }
        return sb.toString().trim();
    }
}