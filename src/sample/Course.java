package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {

    private String courseName;
    private String teacherName;
    private String startDate;
    private String finishDate;
    private String grade;


    public Course(String courseName, String teacherName, String startDate, String finishDate, String grade) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.grade = grade;

    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
