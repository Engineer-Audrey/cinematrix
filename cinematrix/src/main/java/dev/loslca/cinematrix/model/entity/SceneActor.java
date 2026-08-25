package dev.loslca.cinematrix.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "scene_actor")
public class SceneActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scene_actor_id")
    private Integer sceneActorId;

    @ManyToOne
    @JoinColumn(name = "scene_id", nullable = false)
    private Scene scene;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private User director;

    public SceneActor() {}

    public Integer getSceneActorId() { return sceneActorId; }
    public void setSceneActorId(Integer sceneActorId) { this.sceneActorId = sceneActorId; }

    public Scene getScene() { return scene; }
    public void setScene(Scene scene) { this.scene = scene; }

    public Actor getActor() { return actor; }
    public void setActor(Actor actor) { this.actor = actor; }

    public User getDirector() { return director; }
    public void setDirector(User director) { this.director = director; }
}