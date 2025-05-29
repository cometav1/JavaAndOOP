import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static ArrayList<Character> characters = new ArrayList<>();
    private static ArrayList<Enemy> enemies = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру!");
        Scanner scanner = new Scanner(System.in);
        String command;

        // Добавление соперников
        initializeEnemies();

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
                    GameEntity.saveToFile("characters.txt", characters);
                    break;
                case "4":
                    GameEntity.loadFromFile("characters.txt", characters);
                    break;
                case "5":
                    startBattle(scanner);
                    break;
                case "6":
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
        System.out.println("5) Начать бой");
        System.out.println("6) Выйти");
    }

    private static void initializeEnemies() {
        enemies.add(new Enemy("Гоблин", 30, 5));
        enemies.add(new Enemy("Тролль", 50, 10));
        enemies.add(new Enemy("Скелет", 20, 7));
    }

    private static void startBattle(Scanner scanner) {
        if (characters.isEmpty()) {
            System.out.println("Сначала добавьте персонажей для боя!");
            return;
        }

        System.out.println("Выберите персонажа для боя:");
        for (int i = 0; i < characters.size(); i++) {
            System.out.println((i + 1) + ") " + characters.get(i).getName());
        }

        int selectedCharacterIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Character playerCharacter = characters.get(selectedCharacterIndex);

        // Начало боя
        for (Enemy enemy : enemies) {
            while (enemy.isAlive() && playerCharacter.getHealth() > 0) {
                System.out.println("Вы сражаетесь с " + enemy.getName() + "!");
                // Бой
                int playerAttack = playerCharacter.getAttackPower();
                enemy.takeDamage(playerAttack);
                System.out.println("Вы нанесли " + playerAttack + " урона " + enemy.getName());
                if (!enemy.isAlive()) {
                    System.out.println(enemy.getName() + " повержен!");
                    break;
                }

                int enemyAttack = enemy.getAttackPower();
                playerCharacter.takeDamage(enemyAttack);
                System.out.println(enemy.getName() + " нанес вам " + enemyAttack + " урона.");

                // Восстановление здоровья и маны
                System.out.println("Хотите восстановиться? (да/нет)");
                String healDecision = scanner.nextLine();
                if (healDecision.equalsIgnoreCase("да")) {
                    playerCharacter.heal(10); // Восстановление 10 здоровья, можно настроить
                    System.out.println("Вы восстановили 10 здоровья.");
                }

                // Регенерация здоровья
                playerCharacter.regenerateHealth();
            }

            if (playerCharacter.getHealth() <= 0) {
                System.out.println("Вы погибли! Конец игры.");
                return;
            }
        }
        System.out.println("Все враги повержены! Поздравляем!");
    }
}