package com.example.final_project_ped_dk;

public class Todo {
    private int id;
    private String todoDesc;

    public Todo(int id, String todoDesc) {
        this.id = id;
        this.todoDesc = todoDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodoDesc() {
        return todoDesc;
    }

    public void setTodoDesc(String todoDesc) {
        this.todoDesc = todoDesc;
    }
}
