package com.company.connect;

public class CourseModel {

    private final String course_name;
    private final String course_rating;
    private final int course_image;

    // Constructor
    public CourseModel(String course_name, String course_rating, int course_image) {
        this.course_name = course_name;
        this.course_rating = course_rating;
        this.course_image = course_image;
    }

    // Getter and Setter


    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_rating() {
        return course_rating;
    }

    public int getCourse_image() {
        return course_image;
    }
}

