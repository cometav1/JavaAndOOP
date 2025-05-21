import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Character> characters = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать!");
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            showMenu();
            command = scanner.nextLine();
            switch (command) {
                case "1":
                    GameEntity.displayCharacters(characters);
                    break;
                case "2":
                    GameEntity.addCharacter(characters, scanner);
                    break;
                case "3":
                    GameEntity.saveToFile("characters.txt", characters); // Сохранение в файл
                    break;
                case "4":
                    GameEntity.loadFromFile("characters.txt", characters); // Загрузка из файла
                    break;
                case "5":
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверная команда. Пожалуйста, попробуйте снова.");
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("Введите команду:");
        System.out.println("1) Вывести список персонажей");
        System.out.println("2) Добавить персонажа");
        System.out.println("3) Сохранить персонажей в файл");
        System.out.println("4) Загрузить персонажей из файла");
        System.out.println("5) Выйти");
    }
}