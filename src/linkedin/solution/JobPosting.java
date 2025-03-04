package linkedin.solution;

import java.sql.Timestamp;
import java.util.List;

public class JobPosting {
    private final String id;
    private final String title;
    private final String description;
    private final Timestamp postDate;
    private final String location;
    private final String company;
    private final List<String> requirements;

    public JobPosting(String id, String title, String description, Timestamp postDate, String location, String company, List<String> requirements) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.postDate = postDate;
        this.location = location;
        this.company = company;
        this.requirements = requirements;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public String getCompany() {
        return company;
    }
}

