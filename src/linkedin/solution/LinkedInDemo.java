package linkedin.solution;

import linkedin.solution.notifications.Notification;
import linkedin.solution.notifications.NotificationService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedInDemo {
    public static void main(String[] args) {
        LinkedinService linkedInService = LinkedinService.getInstance();
        NotificationService notificationService = new NotificationService();

        linkedInService.addObserver(notificationService);

        // User registration
        User user1 = new User("1", "John Doe", "john@example.com", "password");
        User user2 = new User("2", "Jane Smith", "jane@example.com", "password");
        linkedInService.registerUser(user1);
        linkedInService.registerUser(user2);

        // User login
        User loggedInUser = linkedInService.login("john@example.com", "password");
        if (loggedInUser != null) {
            System.out.println("User logged in: " + loggedInUser.getName());
        } else {
            System.out.println("Invalid email or password.");
        }

        // Update user profile
        Profile profile = new Profile();
        profile.setHeadline("Software Engineer");
        profile.setSummary("Passionate about coding and problem-solving.");
        linkedInService.updateUserProfile(loggedInUser.getId(),profile);

        // Send connection request
        linkedInService.sendConnectionRequest(user1, user2);

        // Accept connection request
        linkedInService.acceptConnectionRequest(user2, user1);

        // Post a job listing
        JobPosting jobPosting = new JobPosting("1", "Software Developer", "We are hiring!",  new Timestamp(System.currentTimeMillis()), "San Francisco","Meta",Arrays.asList("Java", "Python"));
        linkedInService.postJobListing(jobPosting);

        // Search for users
        List<User> searchResults = linkedInService.searchUsers("John");
        System.out.println("Search Results:");
        for (User user : searchResults) {
            System.out.println("Name: " + user.getName());
            System.out.println("Headline: " + user.getProfile().getHeadline());
            System.out.println();
        }

        // Search for job postings
        List<JobPosting> jobPostingResults = linkedInService.searchJobPostings("Software");
        System.out.println("Job Posting Results:");
        for (JobPosting posting : jobPostingResults) {
            System.out.println("Title: " + posting.getTitle());
            System.out.println("Description: " + posting.getDescription());
            System.out.println();
        }

        // Send a message
        linkedInService.sendMessage(user1, user2, "Hi Jane, hope you're doing well!");

        // Get notifications
        List<Notification> notifications = notificationService.getUserNotifications(loggedInUser.getId());
        System.out.println("Notifications:");
        for (Notification notification : notifications) {
            System.out.println("Type: " + notification.getType());
            System.out.println("Content: " + notification.getContent());
            System.out.println();
        }
    }
}