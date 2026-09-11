package dev.loslca.cinematrix.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "production")
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_id")
    private Long id;

    @Column(name = "budget", nullable = false)
    private Double budget;

    @Column(name = "actual_cost")
    private Double actualCost;

    @OneToOne
    @JoinColumn(name = "movie_id", unique = true)
    private Movie movie;

    public Production() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }

    public Double getActualCost() { return actualCost; }
    public void setActualCost(Double actualCost) { this.actualCost = actualCost; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
}