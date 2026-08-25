import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDB {

    // CREATE
    public static void addCourse(Course course, int teacherId) {

        String sql = "INSERT INTO course (code, courseName, maxGrade, teacherId) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, course.getCode());
            statement.setString(2, course.getName());
            statement.setInt(3, course.getMaxGrade());
            statement.setInt(4, teacherId);

            statement.executeUpdate();

            System.out.println("Course saved to database!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    public static Course findCourse(String code) {

        String sql = "SELECT * FROM course WHERE code = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, code);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                String courseCode = result.getString("code");
                String name = result.getString("courseName");
                int maxGrade = result.getInt("maxGrade");

                return new Course(name, courseCode, maxGrade);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // READ ALL
    public static List<Course> getAllCourses() {

        List<Course> courses = new ArrayList<>();

        String sql = "SELECT * FROM course";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                String code = result.getString("code");
                String name = result.getString("courseName");
                int maxGrade = result.getInt("maxGrade");

                courses.add(new Course(name, code, maxGrade));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }

    // UPDATE
    public static void updateCourse(String code, String newName, int newMaxGrade) {

        String sql = "UPDATE course SET courseName = ?, maxGrade = ? WHERE code = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newName);
            statement.setInt(2, newMaxGrade);
            statement.setString(3, code);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Course updated successfully!");
            } else {
                System.out.println("Course not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteCourse(String code) {

        String sql = "DELETE FROM course WHERE code = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, code);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Course deleted successfully!");
            } else {
                System.out.println("Course not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
