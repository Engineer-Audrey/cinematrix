package dev.loslca.cinematrix.model.entity;

import dev.loslca.cinematrix.model.constant.MovieGenre;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "synopsis", columnDefinition = "TEXT")
    private String synopsis;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private MovieGenre genre;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @OneToOne(mappedBy = "movie")
    private Production production;

    @OneToMany(mappedBy = "movie")
    private List<Scene> scenes;

    @OneToMany(mappedBy = "movie")
    private List<Actor> actors;

    public Movie() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSynopsis() { return synopsis; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }

    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }

    public MovieGenre getGenre() { return genre; }
    public void setGenre(MovieGenre genre) { this.genre = genre; }

    public Director getDirector() { return director; }
    public void setDirector(Director director) { this.director = director; }

    public Production getProduction() { return production; }
    public void setProduction(Production production) { this.production = production; }

    public List<Scene> getScenes() { return scenes; }
    public void setScenes(List<Scene> scenes) { this.scenes = scenes; }

    public List<Actor> getActors() { return actors; }
    public void setActors(List<Actor> actors) { this.actors = actors; }
}