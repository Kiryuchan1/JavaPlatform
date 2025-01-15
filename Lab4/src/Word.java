import java.util.ArrayList;
import java.util.List;

class Word {
    private final List<Letter> letters;

    public Word(List<Letter> letters) {
        if (letters == null || letters.isEmpty()) {
            throw new IllegalArgumentException("Слово не може бути пустим або null.");
        }
        this.letters = new ArrayList<>(letters);
    }

    public Word(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Слово не може бути пустим або null.");
        }
        this.letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            this.letters.add(new Letter(c));
        }
    }

    public List<Letter> getLetters() {
        return new ArrayList<>(letters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter);
        }
        return sb.toString();
    }
}