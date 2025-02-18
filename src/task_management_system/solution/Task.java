package task_management_system.solution;

import java.util.Date;

public class Task {
    private final Integer id;
    private String name;
    private String description;
    private Status status;
    private Priority priority;
    private Date DueDate;
    private User assignedUser;

    Task(Integer id,String name, String description, Priority priority, Date dueDate){
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        DueDate = dueDate;
        this.status = Status.PENDING;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date dueDate) {
        DueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public User getAssignedUser() {
        return assignedUser;
    }
}
