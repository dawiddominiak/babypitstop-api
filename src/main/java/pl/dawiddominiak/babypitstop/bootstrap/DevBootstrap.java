package pl.dawiddominiak.babypitstop.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.dawiddominiak.babypitstop.domain.ChangingTable;
import pl.dawiddominiak.babypitstop.domain.Location;
import pl.dawiddominiak.babypitstop.domain.Place;
import pl.dawiddominiak.babypitstop.repositories.PlaceRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private PlaceRepository placeRepository;

    public DevBootstrap(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Location location1 = new Location(54.3, 34.2);
        Location location2 = new Location(55.7, 33.8);


        Place place1 = new Place(location1, "Test location 1", null);
        Place place2 = new Place(location2, "Test location 2", null);

        ChangingTable changingTable1 = new ChangingTable("First changing table", place1);
        ChangingTable changingTable2 = new ChangingTable("Second changing table", place1);
        ChangingTable changingTable3 = new ChangingTable("Third changing table", place2);

        place1.getChangingTables().add(changingTable1);
        place1.getChangingTables().add(changingTable2);
        place2.getChangingTables().add(changingTable3);

        placeRepository.save(place1);
        placeRepository.save(place2);
    }
}
