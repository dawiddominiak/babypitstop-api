package pl.dawiddominiak.babypitstop.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class ChangingTable {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Place place;

    public ChangingTable(String description, Place place) {
        this.description = description;
        this.place = place;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Place getPlace() {
        return place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangingTable that = (ChangingTable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ChangingTable{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", place=" + place +
                '}';
    }
}
