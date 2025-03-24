package view;

import service.TaskService;
import java.util.Scanner;

public class TaskView {
    private final TaskService taskService;
    private final Scanner scanner;

    public TaskView() {
        this.taskService = new TaskService();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n📌 Gerenciador de Tarefas");
            System.out.println("1️⃣ Adicionar Tarefa");
            System.out.println("2️⃣ Listar Tarefas");
            System.out.println("3️⃣ Marcar Tarefa como Concluída");
            System.out.println("4️⃣ Remover Tarefa");
            System.out.println("5️⃣ Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    taskService.listTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("📁 Saindo... Até logo!");
                    return;
                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }
        }
    }

    private void addTask() {
        System.out.print("Digite a nova tarefa: ");
        String description = scanner.nextLine();
        taskService.addTask(description);
    }

    private void completeTask() {
        taskService.listTasks();
        System.out.print("Digite o número da tarefa concluída: ");
        int index = scanner.nextInt() - 1;
        taskService.completeTask(index);
    }

    private void removeTask() {
        taskService.listTasks();
        System.out.print("Digite o número da tarefa a ser removida: ");
        int index = scanner.nextInt() - 1;
        taskService.removeTask(index);
    }
}
