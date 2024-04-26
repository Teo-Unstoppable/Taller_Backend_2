package culturemedia.model;

import java.time.LocalDateTime;

public class View {
    private String userFullName;
    private LocalDateTime startPlayingTime;
    private int age;
    private Video video; // Relación de agregación

    // Constructor
    public View(String userFullName, LocalDateTime startPlayingTime, int age, Video video) {
        this.userFullName = userFullName;
        this.startPlayingTime = startPlayingTime;
        this.age = age;
        this.video = video;
    }

    // Getters y setters
    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public LocalDateTime getStartPlayingTime() {
        return startPlayingTime;
    }

    public void setStartPlayingTime(LocalDateTime startPlayingTime) {
        this.startPlayingTime = startPlayingTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}

