package repository;

import domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private String url;
    public Repository() { this.url = ""; }
    public Repository(String url) { this.url = url; }

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            PreparedStatement statement =
                    conn.prepareStatement("SELECT * from bachelorTheses");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String graduation_year = resultSet.getString(3);
                String title = resultSet.getString(4);
                String progress_percentage = resultSet.getString(5);
                String coordinator = resultSet.getString(6);

                Student student = new Student(id, name, graduation_year, title, progress_percentage, coordinator);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }


    public void update(String title,String progressPercentage, Student student) {
        try (Connection conn = DriverManager.getConnection(url)) {
            PreparedStatement modifyStatement =
                    conn.prepareStatement("UPDATE bachelorTheses SET title = ?, progressPercentage = ? WHERE title = ? AND progressPercentage = ?");
            modifyStatement.setString(1, title);
            modifyStatement.setString(2, progressPercentage);
            modifyStatement.setString(3, student.getTitle());
            modifyStatement.setString(4, student.getProgress_percentage());
            modifyStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
