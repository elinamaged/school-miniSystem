import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EnrollmentDB {

    public static void enrollStudent(int studentId, String courseCode) {

        String sql = "INSERT INTO enrollment (studentId, courseCode) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, studentId);
            statement.setString(2, courseCode);

            statement.executeUpdate();

            System.out.println("Course enrolled successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setGrade(int studentId, String courseCode, double grade) {

        String sql = "UPDATE enrollment SET grade = ? " +
                "WHERE studentId = ? AND courseCode = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, grade);
            statement.setInt(2, studentId);
            statement.setString(3, courseCode);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Grade saved successfully!");
            } else {
                System.out.println("Student is not enrolled in this course!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayGrades(int studentId) {

        String sql = """
            SELECT c.courseName, c.code, e.grade
            FROM enrollment e
            JOIN course c ON e.courseCode = c.code
            WHERE e.studentId = ?
            """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, studentId);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                String courseName = result.getString("courseName");
                String courseCode = result.getString("code");
                double grade = result.getDouble("grade");

                System.out.println(
                        courseName + "   " +
                                courseCode + "   " +
                                grade
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isEnrolled(int studentId, String courseCode) {

        String sql = "SELECT * FROM enrollment WHERE studentId = ? AND courseCode = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, studentId);
            statement.setString(2, courseCode);

            ResultSet result = statement.executeQuery();

            return result.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
