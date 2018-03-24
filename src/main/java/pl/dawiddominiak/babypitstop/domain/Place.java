package pl.dawiddominiak.babypitstop.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Place {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID id;

    @Embedded
    private Location location;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private List<ChangingTable> changingTables = new ArrayList<>();

    @Column(columnDefinition = "TEXT")
    private String description;

    public Place(Location location, String name, String description) {
        this.location = location;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public List<ChangingTable> getChangingTables() {
        return changingTables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        return id != null ? id.equals(place.id) : place.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", location=" + location +
                ", name='" + name + '\'' +
                ", changingTables=" + changingTables +
                ", description='" + description + '\'' +
                '}';
    }
}
