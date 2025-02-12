package stackoverflow.solution;

public class Tag {
    private int tagId;
    private String tagName;

    public Tag(String tagName) {
        this.tagName = tagName;
        this.tagId = generateId();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public String getName() {
        return tagName;
    }
}
