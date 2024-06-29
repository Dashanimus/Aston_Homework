import java.util.*;

public class ArrayWords {

    private final String text;
    private final String[] words;

    public ArrayWords(String text) {
        this.text = text;
        words = text.toLowerCase().split("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+");
    }

    public List<String> listOfUniqueWords() {

        ArrayList<String> uniqueWordsList = new ArrayList<>();
        ArrayList<Integer> uniqueWordsCountList = new ArrayList<>();

        for(String word: words) {
            boolean isContained = uniqueWordsList.contains(word);
            if (isContained) {
                int index = uniqueWordsList.indexOf(word);
                uniqueWordsCountList.set(index, uniqueWordsCountList.get(index) + 1);
            } else {
                uniqueWordsList.add(word);
                uniqueWordsCountList.add(1);
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < uniqueWordsList.size(); i++) {
            res.add(uniqueWordsList.get(i) + "=" + uniqueWordsCountList.get(i));
        }
        return res;
    }

    public List<String> listOfUniqueWordsWithMap() {

        Map<String, Integer> map = new HashMap<>();
        for(String word: words) {
            if (map.containsKey(word)) {
                map.replace(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<String> res = new ArrayList<>();
        list.forEach(elem -> {
            res.add(elem.getKey() + "=" + elem.getValue());
        });

        return res;
    }

}