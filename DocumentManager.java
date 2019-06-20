package exercise2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DocumentManager {

    private static final String split_value = " ";


    public Map<Document, Integer>  findWords(Map<String, Set> docsDictionary, List<String> words) {
        Map<Document, Integer> mapOfWordsFounds = new HashMap<>();

        for (String word : words) {
            if (docsDictionary.get(word) != null) {
                Set<Document> docFound = docsDictionary.get(word);
                for (Document doc : docFound) {
                    Integer key = mapOfWordsFounds.get(doc);
                    if (key == null) {
                        mapOfWordsFounds.put(doc, 1);
                    } else {
                        Integer value = mapOfWordsFounds.get(doc) + 1;
                        mapOfWordsFounds.put(doc, value);
                    }
                }
            }
        }

        return mapOfWordsFounds;
    }

    public List<Document> findDocument(Map<Document, Integer> mapOfWordsFounds, Integer numberOfWordToFind){
        List<Document> docs = new ArrayList<>();
        for (Map.Entry<Document, Integer> entry : mapOfWordsFounds.entrySet()) {
            if (entry.getValue()==numberOfWordToFind){
                docs.add(entry.getKey());
            }
        }
        return docs;
    }


    public Map<String, Set> convertDocumentInDictionary(List<Document> docs) {
        Map<String, Set> mapOfWords = new HashMap<>();
        for (Document doc : docs) {
            for (String page : doc.getSheets()) {
                String[] words = cutPage(page);
                for (int index = 0; index < words.length; index++) {
                    String key = words[index];
                    if (mapOfWords.get(key) == null) {
                        Set setDoc = new HashSet<>();
                        setDoc.add(doc);
                        mapOfWords.put(key, setDoc);
                    } else {
                        mapOfWords.get(key).add(doc);
                    }
                }
            }
        }
        return mapOfWords;
    }

    private String[] cutPage(String page) {
        return page.trim().split(split_value);
    }


}
