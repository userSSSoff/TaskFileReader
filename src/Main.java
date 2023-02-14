import java.util.Arrays;

/**
   УДАЧИ ТЕБЕ
 */
public class Main {
    public static void main(String[] args) {

        String text = "Hello my name is Meder";

        System.out.println(text);

        String[] textMassive = text.split(" ");

        System.out.println(Arrays.toString(Arrays.stream(textMassive).toArray()));
    }
}