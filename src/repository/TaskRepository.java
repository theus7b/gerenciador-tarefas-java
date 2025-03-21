package repository;

import model.Task;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static final String FILE_NAME = "tasks.txt";

    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = new Task(line.replace("[✔] ", "").replace("[ ] ", ""));
                if (line.startsWith("[✔]")) {
                    task.markAsCompleted();
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("🔍 Nenhum arquivo encontrado, iniciando uma nova lista.");
        }
        return tasks;
    }

    public void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar tarefas.");
        }
    }
}
