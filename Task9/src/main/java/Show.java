import java.sql.*;

public class Show {
    public static void execute(Connection connection) throws SQLException {
        String sql = "SELECT * FROM tasks";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            boolean hasTasks = false;
            while (resultSet.next()) {
                hasTasks = true;
                int uid = resultSet.getInt("uid");
                String name = resultSet.getString("name");
                String status = resultSet.getString("status");
                System.out.printf("UID: %d, Название: %s, Статус: %s%n", uid, name, status);
            }

            if (!hasTasks) {
                System.out.println("Нет задач для отображения");
            }
        }
    }
}