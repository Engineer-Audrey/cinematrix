package dev.loslca.cinematrix.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Integer actorId;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "nationality", length = 100)
    private String nationality;

    @OneToMany(mappedBy = "actor")
    private List<Casting> castings;

    @OneToMany(mappedBy = "actor")
    private List<SceneActor> sceneAssignments;

    public Actor() {}

    public Integer getActorId() { return actorId; }
    public void setActorId(Integer actorId) { this.actorId = actorId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public List<Casting> getCastings() { return castings; }
    public void setCastings(List<Casting> castings) { this.castings = castings; }

    public List<SceneActor> getSceneAssignments() { return sceneAssignments; }
    public void setSceneAssignments(List<SceneActor> sceneAssignments) { this.sceneAssignments = sceneAssignments; }
}