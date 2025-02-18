package task_management_system.solution;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManager {
    private static TaskManager instance;
    private final Map<Integer, Task> tasks;
    private final Map<Integer, List<Task>> userTasks;

    public static TaskManager getInstance() {
        if(instance == null){
            instance = new TaskManager();
        }
        return instance;
    }

    TaskManager(){
        tasks = new ConcurrentHashMap<>();
        userTasks = new ConcurrentHashMap<>();
    }

    public void createTask(Task task){
        tasks.put(task.getId(), task);
        if(task.getAssignedUser()!=null){
            assignTaskToUser(task.getAssignedUser(),task);
        }
    }

    public void updateTask(Task task){
        Task oldTask = tasks.get(task.getId());
        if(oldTask != null){
            synchronized (task){
                oldTask.setStatus(task.getStatus());
                oldTask.setPriority(task.getPriority());
                oldTask.setName(task.getName());
                oldTask.setDueDate(task.getDueDate());
                oldTask.setDescription(task.getDescription());
                User previousUser = oldTask.getAssignedUser();
                User newUser = task.getAssignedUser();
                if (previousUser!=null && !previousUser.equals(newUser)) {
                    unassignTaskFromUser(previousUser, oldTask);
                }
                if(newUser != null) assignTaskToUser(newUser, task);
            }
        }
    }

   public void deleteTask(Integer id){
        Task task = tasks.remove(id);
        if(task != null){
            unassignTaskFromUser(task.getAssignedUser(),task);
        }
   }

   public List<Task> searchTask(String query){
        List<Task> matchingTasks = new ArrayList<>();
        for(Task task : tasks.values()){
            if(task.getName().toLowerCase().contains(query.toLowerCase()) || task.getDescription().toLowerCase().contains(query.toLowerCase())){
                matchingTasks.add(task);
            }
        }

        return matchingTasks;
   }

   public List<Task> filterTasks(Status status, Date startDate, Date endDate, Priority priority){
        List<Task> matchingTasks = new ArrayList<>();
        for(Task task : tasks.values()){
            if(task.getStatus().equals(status) && task.getPriority().equals(priority) &&
                    task.getDueDate().compareTo(startDate) >= 0 && task.getDueDate().compareTo(endDate) <= 0 ){
                matchingTasks.add(task);
            }
        }

        return matchingTasks;
   }

    public void moveTaskToInProgress(Integer id){
        Task task = tasks.get(id);
        if(task != null){
            synchronized (task){
                task.setStatus(Status.IN_PROGRESS);
            }
        }
    }

   public void markTaskAsCompleted(Integer id){
        Task task = tasks.get(id);
        if(task != null){
            synchronized (task) {
                task.setStatus(Status.COMPLETED);
            }
        }
   }

    public List<Task> getUserTasks(User user) {
        return new ArrayList<>(userTasks.getOrDefault(user.getId(), new ArrayList<>()));
    }

   public void assignTaskToUser(User user, Task task){
       userTasks.computeIfAbsent(user.getId(), k -> new CopyOnWriteArrayList<>()).add(task);
   }

   public void unassignTaskFromUser(User user, Task task){
        List<Task> tasks = userTasks.get(user.getId());
        if(tasks != null) {
            tasks.remove(task);
        }
   }
}
