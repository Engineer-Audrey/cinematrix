package dev.loslca.cinematrix.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "scene")
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scene_id")
    private Integer sceneId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(name = "scene_number", nullable = false)
    private Integer sceneNumber;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "shooting_date")
    private LocalDate shootingDate;

    @OneToMany(mappedBy = "scene")
    private List<SceneActor> sceneActors;

    public Scene() {}

    public Integer getSceneId() { return sceneId; }
    public void setSceneId(Integer sceneId) { this.sceneId = sceneId; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public Integer getSceneNumber() { return sceneNumber; }
    public void setSceneNumber(Integer sceneNumber) { this.sceneNumber = sceneNumber; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public LocalDate getShootingDate() { return shootingDate; }
    public void setShootingDate(LocalDate shootingDate) { this.shootingDate = shootingDate; }

    public List<SceneActor> getSceneActors() { return sceneActors; }
    public void setSceneActors(List<SceneActor> sceneActors) { this.sceneActors = sceneActors; }
}