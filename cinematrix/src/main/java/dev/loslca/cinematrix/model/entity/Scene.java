package dev.loslca.cinematrix.model.entity;

import dev.loslca.cinematrix.model.constant.TimeOfDay;
import jakarta.persistence.*;

@Entity
@Table(name = "scene")
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scene_id")
    private Long id;

    @Column(name = "scene_number", nullable = false)
    private Integer sceneNumber;

    @Column(name = "description", length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "time_of_day", nullable = false)
    private TimeOfDay timeOfDay;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Scene() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getSceneNumber() { return sceneNumber; }
    public void setSceneNumber(Integer sceneNumber) { this.sceneNumber = sceneNumber; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public TimeOfDay getTimeOfDay() { return timeOfDay; }
    public void setTimeOfDay(TimeOfDay timeOfDay) { this.timeOfDay = timeOfDay; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
}