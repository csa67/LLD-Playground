package task_management_system.solution;

import java.util.Date;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        TaskManager taskManager = TaskManager.getInstance();

        User user1 = new User(1,"John", "john@gmail.com");
        User user2 = new User(2,"Jane", "jane@gmail.com");

        Task task1 = new Task(1,"Task 1","Desc 1",Priority.LOW,new Date());
        Task task2 = new Task(2,"Task 2","Desc 2",Priority.LOW,new Date());
        Task task3 = new Task(3, "Task 3","Desc 3",Priority.HIGH,new Date());

        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);

        task2.setDescription("Updated Description");
        taskManager.updateTask(task2);

        // Search tasks
        List<Task> searchResults = taskManager.searchTask("Task");
        System.out.println("Search Results:");
        for (Task task : searchResults) {
            System.out.println(task.getName());
        }

        // Filter tasks
        List<Task> filteredTasks = taskManager.filterTasks(Status.PENDING, new Date(0), new Date(), Priority.HIGH);
        System.out.println("Filtered Tasks:");
        for (Task task : filteredTasks) {
            System.out.println(task.getName());
        }

        taskManager.markTaskAsCompleted(1);
        System.out.println("Marked Task as Completed :"+ task1.getStatus());
    }
}
