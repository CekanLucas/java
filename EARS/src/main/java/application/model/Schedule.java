package application.model;

public class Schedule {
    private String course;
    private String time;

    public Schedule(String course, String time) {
        this.course = course;
        this.time = time;
    }

    // Getter for course
    public String getCourse() {
        return course;
    }

    // Setter for course
    public void setCourse(String course) {
        this.course = course;
    }

    // Getter for time
    public String getTime() {
        return time;
    }

    // Setter for time
    public void setTime(String time) {
        this.time = time;
    }
}

