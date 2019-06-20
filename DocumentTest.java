package exercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DocumentTest {

    public static void main(String[] args) {

        DocumentManager documentManager = new DocumentManager();
        List<Document> docs = getDocuments();
        List<String> words = getWordsToFind();

        Map<String, Set> dicc = documentManager.convertDocumentInDictionary(docs);
        Map<Document, Integer> diccCount = documentManager.findWords(dicc, words);
        List<Document> docsMetCriteria = documentManager.findDocument(diccCount, words.size());



    }


    public static List<String> getWordsToFind() {
        return Arrays.asList("jocesito", "bueno","maracaibo");
    }

    public static List<Document> getDocuments() {
        List<Document> docs = new ArrayList<>();
        Document doc1 = new Document(1, "title 1", Arrays.asList("jocesito malo pal pin", " pin pon es un", " munieco bueno", " maracaibo top high girls"));
        Document doc2 = new Document(2, "title 2", Arrays.asList(" asi po jocesito ", "un nino bueno", " que ya no va a maracaibo"));
        Document doc3 = new Document(3, "title 3", Arrays.asList(" maracaibo paradise place for algunos", " como", " jocesito"));
        docs.add(doc1);
        docs.add(doc2);
        docs.add(doc3);
        return docs;
    }
}
