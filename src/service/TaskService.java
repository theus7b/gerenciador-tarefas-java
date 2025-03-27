package service;

import model.Task;
import repository.TaskRepository;
import java.util.List;

public class TaskService {
    private List<Task> tasks;
    private final TaskRepository repository;

    public TaskService() {
        this.repository = new TaskRepository();
        this.tasks = repository.loadTasks();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("✅ Tarefa adicionada!");
        repository.saveTasks(tasks);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📭 Nenhuma tarefa encontrada.");
        } else {
            System.out.println("\n📃 Lista de Tarefas:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
            System.out.println("🎉 Tarefa concluída!");
            repository.saveTasks(tasks);
        } else {
            System.out.println("❌ Número inválido!");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("🗑️ Tarefa removida!");
            repository.saveTasks(tasks);
        } else {
            System.out.println("❌ Número inválido!");
        }
    }
}
