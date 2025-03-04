package linkedin.solution;

import java.util.List;

public class Profile {
    private String profilePicture;
    private String headline;
    private String about;
    private List<Education> educationList;
    private List<Experience> experienceList;
    private List<String> skills;

    public void setSummary(String summary) {
        this.about = summary;
    }

    public String getSummary() {
        return about;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAbout() {
        return about;
    }



}
