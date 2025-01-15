public class Main {
    public static void main(String[] args) {
        try {
            Text text = new Text(
                    "Hello world.   May the chaos take the world. The ring must be destroyed.");

            System.out.println("Оригінальний текст:");
            System.out.println(text);

            text.processText();

            System.out.println("Текст після обробки:");
            System.out.println(text);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка вхідних даних: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Неочікувана помилка: " + e.getMessage());
        }
    }
}