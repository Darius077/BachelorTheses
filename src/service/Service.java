package service;

import domain.Student;
import repository.Repository;

import java.util.Comparator;
import java.util.List;
import java.time.Year;

public class Service {
    private final Repository repository;
    public Service(Repository repository) {
        this.repository = repository;
    }



    public List<Student> viewAll() {
        List<Student> students = repository.getStudents();

        int currentYear = Year.now().getValue();

        return students.stream()
                .sorted(Comparator.comparing((Student s) -> {
                    boolean mustDefendThisYear = String.valueOf(currentYear).equals(s.getGraduation_year());
                    return mustDefendThisYear ? 0 : 1;
                }).thenComparing(Student::getGraduation_year, Comparator.reverseOrder()))
                .toList();
    }

    //2
    public List<Student> searchStudents() {
        List<Student> students = repository.getStudents();

        return students.stream()
                .filter(r -> r.getTitle().equals("No title"))
                .toList();
    }


    //3 Update the title and the progress percentage

    public void updateRecipe(String title, String percentage, Student student) {
        repository.update(title, percentage, student);
    }




}


