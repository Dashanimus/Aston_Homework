import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final Map<String, List<String>> book;

    public PhoneBook() {
        book = new HashMap<>();
    }

    public void add(String family, String number) {
        if (!book.containsKey(family)) {
            book.put(family, new ArrayList<>());
        }
        book.get(family).add(number);
    }

    public List<String> get(String family) {
        if (book.containsKey(family)) {
            return book.get(family);
        }
        return null;
    }
}
