import java.sql.*;
import java.util.Scanner;

public class Add {
    public static void execute(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Введите название: ");
        String name = scanner.nextLine();
        String sql = "INSERT INTO tasks (name, status) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, "в процессе");
            statement.executeUpdate();
            System.out.println("Задача добавлена");
        }
    }
}