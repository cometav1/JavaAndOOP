import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class GameEntity {
    public static void displayCharacters(ArrayList<Character> characters) {
        System.out.println("\nСписок персонажей:");
        if (characters.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            for (Character character : characters) {
                System.out.println(character.getInfo());
            }
        }
    }

    public static void addCharacter(ArrayList<Character> characters, Scanner scanner) {
        System.out.println("Добавьте персонажа:");
        System.out.print("Введите имя персонажа: ");
        String name = scanner.nextLine();

        System.out.print("Введите здоровье: ");
        int health = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите урон: ");
        int attackPower = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите ману: ");
        int mana = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите регенерацию маны: ");
        int manaRegeneration = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите регенерацию здоровья: ");
        int healthRegeneration = Integer.parseInt(scanner.nextLine());

        Character newCharacter = new Character(name, health, attackPower, mana, manaRegeneration, healthRegeneration);
        characters.add(newCharacter);

        System.out.println("Персонаж добавлен!");
    }

    public static void saveToFile(String fileName, ArrayList<Character> characters) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Character character : characters) {
                writer.write(character.getName() + "," + character.getHealth() + "," +
                        character.getAttackPower() + "," + character.getMana() + "," +
                        character.getManaRegeneration() + "," + character.getHealthRegeneration());
                writer.newLine();
            }
            System.out.println("Персонажи успешно сохранены в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    public static void loadFromFile(String fileName, ArrayList<Character> characters) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int health = Integer.parseInt(data[1]);
                int attackPower = Integer.parseInt(data[2]);
                int mana = Integer.parseInt(data[3]);
                int manaRegeneration = Integer.parseInt(data[4]);
                int healthRegeneration = Integer.parseInt(data[5]);

                Character character = new Character(name, health, attackPower, mana, manaRegeneration, healthRegeneration);
                characters.add(character);
            }
            System.out.println("Персонажи успешно загружены из файла: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата данных: " + e.getMessage());
        }
    }
}