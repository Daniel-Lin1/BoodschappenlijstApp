package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "procedure")
    private String procedure;


   /* @OneToMany
    @JoinColumn(name = "post_id")
    private List<Necessity> necessities; */

    public Recipe() {

    }

    public Recipe(String name, String procedure) {
        this.procedure = procedure;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

   /* public List<Necessity> getNecessities() {
        return necessities;
    }

    public void setNecessities(List<Necessity> necessities) {
        this.necessities = necessities;
    } */
}
