import java.sql.*;
import java.util.Scanner;

public class Done {
    public static void execute(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Введите UID: ");
        int uid = Integer.parseInt(scanner.nextLine());

        String sql = "UPDATE tasks SET status = ? WHERE uid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "завершено");
            statement.setInt(2, uid);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Задача завершена");
            } else {
                System.out.println("Задача не найдена");
            }
        }
    }
}