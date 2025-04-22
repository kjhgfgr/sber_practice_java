import java.sql.*;
import java.util.Scanner;

public class App {
    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static Connection connection;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Соединение с H2 установлено!");
            createTable();

            String command;
            do {
                System.out.print("> ");
                command = scanner.nextLine();

                switch (command) {
                    case "add":
                        Add.execute(connection, scanner);
                        break;
                    case "show":
                        Show.execute(connection);
                        break;
                    case "done":
                        Done.execute(connection, scanner);
                        break;
                    case "delete":
                        Delete.execute(connection, scanner);
                        break;
                    case "exit":
                        Exit.execute();
                        break;
                    default:
                        System.out.println("Ошибка: неизвестная команда");
                }
            } while (!command.equals("exit"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS tasks " +
                "(uid INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100), status VARCHAR(10))";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Таблица создана");
        }
    }

    private static void closeResources() {
        try {
            if (connection != null) connection.close();
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}