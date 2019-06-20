package exercise2;

import java.util.List;
import java.util.Objects;

public class Document {

    private int id;
    private String title;
    private List<String> sheets;

    public Document(int id, String title, List<String> sheets) {
        this.id = id;
        this.title = title;
        this.sheets = sheets;
    }

    public List<String> getSheets() {
        return sheets;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return id == document.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
