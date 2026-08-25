import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDB {

    // CREATE
    public static void addStudent(Student student) {

        String sql = "INSERT INTO student (id, name, password) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getPassword());

            statement.executeUpdate();

            System.out.println("Student saved to database!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // READ
    public static Student findStudent(int id) {

        String sql = "SELECT * FROM student WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                String name = result.getString("name");
                String password = result.getString("password");

                return new Student(name, id, password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void updateStudentPassword(int id, String newPassword) {

        String sql = "UPDATE student SET password = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newPassword);
            statement.setInt(2, id);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Password updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(int id) {

        String sql = "DELETE FROM student WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Student getStudent(int id) {

        String sql = "SELECT * FROM student WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                String name = result.getString("name");
                String password = result.getString("password");

                return new Student(name, id, password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
