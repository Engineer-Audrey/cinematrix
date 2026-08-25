package dev.loslca.cinematrix.model.entity;

import dev.loslca.cinematrix.model.constant.MovieStatus;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "genre", nullable = false, length = 100)
    private String genre;

    @Column(name = "synopsis", columnDefinition = "TEXT")
    private String synopsis;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private MovieStatus status = MovieStatus.development;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "production_id", nullable = false)
    private Production production;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private User director;

    @OneToMany(mappedBy = "movie")
    private List<Scene> scenes;

    @OneToMany(mappedBy = "movie")
    private List<Casting> castings;

    public Movie() {}

    public Integer getMovieId() { return movieId; }
    public void setMovieId(Integer movieId) { this.movieId = movieId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getSynopsis() { return synopsis; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public MovieStatus getStatus() { return status; }
    public void setStatus(MovieStatus status) { this.status = status; }

    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }

    public Production getProduction() { return production; }
    public void setProduction(Production production) { this.production = production; }

    public User getDirector() { return director; }
    public void setDirector(User director) { this.director = director; }

    public List<Scene> getScenes() { return scenes; }
    public void setScenes(List<Scene> scenes) { this.scenes = scenes; }

    public List<Casting> getCastings() { return castings; }
    public void setCastings(List<Casting> castings) { this.castings = castings; }
}