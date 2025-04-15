import java.sql.*;
import java.util.Scanner;

public class ToDoList {
    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Соединение с H2 установлено!");

            createTable(connection);

            String command;
            do {
                System.out.print("> ");
                command = scanner.nextLine();

                switch (command) {
                    case "add":
                        add(connection);
                        break;
                    case "show":
                        show(connection);
                        break;
                    case "done":
                        done(connection);
                        break;
                    case "delete":
                        delete(connection);
                        break;
                    case "exit":
                        System.out.println("Выход...");
                        break;
                    default:
                        System.out.println("Ошибка: неизвестная команда");
                }
            } while (!command.equals("exit"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS tasks " +
                "(uid INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100), status VARCHAR(10))";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Таблица создана");
        }
    }

    private static void add(Connection connection) throws SQLException {
        System.out.print("Введите название: ");
        String name = scanner.nextLine();
        String sql = "INSERT INTO tasks (name, status) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, "в процессе");
            statement.executeUpdate();
        }
    }

    private static void show(Connection connection) throws SQLException {
        String sql = "SELECT * FROM tasks";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int uid = resultSet.getInt("uid");
                String name = resultSet.getString("name");
                String status = resultSet.getString("status");

                System.out.printf("UID: %d, Название: %s, Статус: %s%n", uid, name, status);
            }
        }
    }

    private static void done(Connection connection) throws SQLException {
        System.out.print("Введите UID: ");
        int uid = Integer.parseInt(scanner.nextLine());

        String sql = "UPDATE tasks SET status = ? WHERE uid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "завершено");
            statement.setInt(2, uid);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("задача завершена");
            } else {
                System.out.println("задача не найдена");
            }
        }
    }

    private static void delete(Connection connection) throws SQLException {
        System.out.print("Введите UID: ");
        int uid = Integer.parseInt(scanner.nextLine());

        String sql = "DELETE FROM tasks WHERE uid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, uid);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("задача удалена");
            } else {
                System.out.println("задача не найдена");
            }
        }
    }
}
