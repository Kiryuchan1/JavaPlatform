import java.util.ArrayList;
import java.util.List;

class Text {
    private final List<Sentence> sentences;

    public Text(List<Sentence> sentences) {
        if (sentences == null || sentences.isEmpty()) {
            throw new IllegalArgumentException("Текст не може бути пустим або null.");
        }
        this.sentences = new ArrayList<>(sentences);
    }

    public Text(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст не може бути пустим або null.");
        }
        this.sentences = new ArrayList<>();
        String[] sentenceStrings = text.trim().split("(?<=[.?!])\\s*");

        for (String sentenceString : sentenceStrings) {
            this.sentences.add(new Sentence(sentenceString));
        }
    }

    public List<Sentence> getSentences() {
        return new ArrayList<>(sentences);
    }

    public void processText() {
        for (Sentence sentence : sentences) {
            sentence.swapFirstAndLastWords();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence).append(" ");
        }
        return sb.toString().trim();
    }
}