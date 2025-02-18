package task_management_system.solution;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer id;
    private String name;
    private String email;

    User(Integer id,String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }
}
