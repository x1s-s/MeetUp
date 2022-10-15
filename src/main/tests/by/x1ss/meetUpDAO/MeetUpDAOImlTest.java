package by.x1ss.meetUpDAO;

import by.x1ss.model.MeetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetUpDAOImlTest {
    private final MeetUpDAO meetUpDAO = new MeetUpDAOIml();

    @Test
    void getAllWithFilter() {
        List<MeetUp> meetUps = meetUpDAO.getAllWithFilter("theme", null, null, null);
        Assertions.assertTrue(meetUps.stream().allMatch(meetUp -> "theme".equals(meetUp.getTheme())));
    }

    @Test
    void getAllSorted() {
        List<MeetUp> createList = new ArrayList<>();
        createList.add(new MeetUp("theme5", "description", "location", new Date(), "place"));
        createList.add(new MeetUp("theme4", "description", "location", new Date(), "place"));
        createList.add(new MeetUp("theme3", "description", "location", new Date(), "place"));
        createList.add(new MeetUp("theme2", "description", "location", new Date(), "place"));
        createList.add(new MeetUp("theme1", "description", "location", new Date(), "place"));
        createList.forEach(meetUpDAO::create);
        List<MeetUp> meetUps = meetUpDAO.getAllSorted("theme");
        meetUps.forEach(System.out::println);
        for (int i = 0; i < meetUps.size() - 1; i++) {
            if(meetUps.get(i).getTheme().compareTo(meetUps.get(i + 1).getTheme()) > 0) {
                Assertions.fail();
            }
        }
        createList.forEach(meetUpDAO::delete);
    }

    @Test
    void createAndDelete() {
        MeetUp meetUp = new MeetUp("theme", "description", "organizer", "12/12/2021 12:00:00", "place");
        meetUpDAO.create(meetUp);
        assertTrue(meetUpDAO.getAll().contains(meetUp));
        meetUpDAO.delete(meetUp);
        assertFalse(meetUpDAO.getAll().contains(meetUp));
    }

    @Test
    void update() {
        MeetUp meetUp = new MeetUp("theme", "description", "organizer", "12/12/2021 12:00:00", "place");
        meetUpDAO.create(meetUp);
        MeetUp meetUpUpdate = meetUpDAO.getAll().get(0);
        meetUpUpdate.setPlace("new place");
        meetUpDAO.update(meetUpUpdate);
        assertEquals(meetUpDAO.getAll().get(0).getPlace(), "new place");
        meetUpDAO.delete(meetUp);
    }
}