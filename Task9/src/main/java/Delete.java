import java.sql.*;
import java.util.Scanner;

public class Delete {
    public static void execute(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Введите UID: ");
        int uid = Integer.parseInt(scanner.nextLine());

        String sql = "DELETE FROM tasks WHERE uid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, uid);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Задача удалена");
            } else {
                System.out.println("Задача не найдена");
            }
        }
    }
}