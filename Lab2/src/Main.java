public class Main {

    public static void main(String[] args) {
        try {
            StringBuilder text = new StringBuilder("Hello world. May the chaos take the world. The ring must be destroyed.");

            System.out.println("Оригінальний текст:");
            System.out.println(text);

            processText(text);

            System.out.println("Текст після обробки:");
            System.out.println(text);

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    public static void processText(StringBuilder text) {
        validateText(text);

        String[] sentences = text.toString().split("(?<=\\.)");
        text.setLength(0);

        for (String sentence : sentences) {
            String processedSentence = swapFirstAndLastWords(sentence);
            text.append(processedSentence).append(" ");
        }

        if (text.length() > 0) {
            text.setLength(text.length() - 1);
        }
    }

    private static void validateText(StringBuilder text) {
        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Текст не може бути порожнім або null.");
        }
    }

    private static String swapFirstAndLastWords(String sentence) {
        String trimmedSentence = sentence.trim();

        boolean endsWithDot = trimmedSentence.endsWith(".");
        if(endsWithDot){
            trimmedSentence = trimmedSentence.substring(0, trimmedSentence.length() - 1);
        }

        String[] words = trimmedSentence.split("\\s+");

        if (words.length < 2) {
            return endsWithDot ? trimmedSentence + "." : trimmedSentence;
        }

        String temp = words[0];
        words[0] = words[words.length - 1];
        words[words.length - 1] = temp;

        return String.join(" ", words) + (endsWithDot ? "." : "");
    }
}
