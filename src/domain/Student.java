package domain;


public class Student {
    private String id;
    private String name;
    private String graduation_year;
    private String title;
    private String progress_percentage;
    private String coordinator;



    public Student(String id, String name, String graduation_year, String title, String progress_percentage, String coordinator) {
        this.id = id;
        this.name = name;
        this.graduation_year = graduation_year;
        this.title = title;
        this.progress_percentage = progress_percentage;
        this.coordinator = coordinator;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(String graduation_year) {
        this.graduation_year = graduation_year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProgress_percentage() {return progress_percentage;}

    public void setProgress_percentage(String progress_percentage) {this.progress_percentage = progress_percentage;}

    public String getCoordinator() {return coordinator;}

    public void setCoordinator(String coordinator) {this.coordinator = coordinator;}

    public String toString() {
        return  id + " | " + name + " | " + graduation_year + " | " + title + " | " + progress_percentage + " | " + coordinator;
    }
}
