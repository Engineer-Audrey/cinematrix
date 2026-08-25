package dev.loslca.cinematrix.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "casting")
public class Casting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "casting_id")
    private Integer castingId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @Column(name = "character_name", length = 150)
    private String characterName;

    @Column(name = "lead_role")
    private Boolean leadRole = false;

    public Casting() {}

    public Integer getCastingId() { return castingId; }
    public void setCastingId(Integer castingId) { this.castingId = castingId; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public Actor getActor() { return actor; }
    public void setActor(Actor actor) { this.actor = actor; }

    public String getCharacterName() { return characterName; }
    public void setCharacterName(String characterName) { this.characterName = characterName; }

    public Boolean getLeadRole() { return leadRole; }
    public void setLeadRole(Boolean leadRole) { this.leadRole = leadRole; }
}