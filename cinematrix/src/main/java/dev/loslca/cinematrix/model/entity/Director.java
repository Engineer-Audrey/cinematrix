package dev.loslca.cinematrix.model.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "trajectory", columnDefinition = "TEXT")
    private String trajectory;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;

    public Director() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTrajectory() { return trajectory; }
    public void setTrajectory(String trajectory) { this.trajectory = trajectory; }

    public List<Movie> getMovies() { return movies; }
    public void setMovies(List<Movie> movies) { this.movies = movies; }
}