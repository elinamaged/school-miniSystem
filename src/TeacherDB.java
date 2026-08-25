import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDB {

    // CREATE
    public static void addTeacher(Teacher teacher) {

        String sql = "INSERT INTO teacher (id, name, password) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, teacher.getId());
            statement.setString(2, teacher.getName());
            statement.setString(3, teacher.getPassword());

            statement.executeUpdate();

            System.out.println("Teacher saved to database!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // READ - find one teacher
    public static Teacher findTeacher(int id) {

        String sql = "SELECT * FROM teacher WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                String name = result.getString("name");
                String password = result.getString("password");

                return new Teacher(name, id, password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    // READ - get all teachers
    public static List<Teacher> getAllTeachers() {

        List<Teacher> teachers = new ArrayList<>();

        String sql = "SELECT * FROM teacher";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                int id = result.getInt("id");
                String name = result.getString("name");
                String password = result.getString("password");

                teachers.add(new Teacher(name, id, password));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return teachers;
    }


    // UPDATE
    public static void updateTeacherPassword(int id, String newPassword) {

        String sql = "UPDATE teacher SET password = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newPassword);
            statement.setInt(2, id);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Teacher password updated successfully!");
            } else {
                System.out.println("Teacher not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // DELETE
    public static void deleteTeacher(int id) {

        String sql = "DELETE FROM teacher WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Teacher deleted successfully!");
            } else {
                System.out.println("Teacher not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
