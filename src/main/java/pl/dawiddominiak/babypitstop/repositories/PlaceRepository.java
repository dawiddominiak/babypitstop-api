package pl.dawiddominiak.babypitstop.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dawiddominiak.babypitstop.domain.Place;

import java.util.UUID;

public interface PlaceRepository extends CrudRepository<Place, UUID> {
}
