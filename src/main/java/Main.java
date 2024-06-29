public class Main {

    public static void main(String[] args) {

        String text =
                "You take the blue pill – the story ends, you wake up in your bed and believe whatever you want to believe."
                + "Why, oh why didn't I take the blue pill?"
               + "What do all men with power want? More power."
               + "Have you ever had a dream that you were sure was real."
                + "Unfortunately, no one can be told what The Matrix is. You have to see it for yourself.";

        ArrayWords handler = new ArrayWords(text);

        handler.listOfUniqueWordsWithMap().forEach(System.out::println);

        PhoneBook pb = new PhoneBook();

        pb.add("Лапкина", "777-77-77");
        pb.add("Зубенко", "8-800");
        pb.add("Кошкин", "666-66-66");
        pb.add("Зубенко", "555");
        pb.add("Кошкин", "999-99-99");
        pb.add("Крабов", "333-33-33");
        pb.add("Зубенко", "35-35");

        System.out.println("Лапкина: " + pb.get("Лапкина"));
        System.out.println("Зубенко: " + pb.get("Зубенко"));
        System.out.println("Кошкин: " + pb.get("Кошкин"));
        System.out.println("Крабов: " + pb.get("Крабов"));
        System.out.println("Махровый: " + pb.get("Махровый"));

    }
}