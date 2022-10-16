package by.x1ss.meetUpDAO;

import by.x1ss.dto.MeetUpDTO;
import by.x1ss.meetUpService.MeetUpService;
import by.x1ss.meetUpService.MeetUpServiceImp;
import by.x1ss.model.MeetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MeetUpDAOImlTest {
    private final MeetUpDAO meetUpDAO = new MeetUpDAOIml();

    @Test
    void getAllWithFilter() {
        List<MeetUpDTO> createList = new ArrayList<>();
        List<Long> idList = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> createList.add(new MeetUpDTO("theme", "description", "organizer", new Date(), "place")));
        createList.forEach(x -> idList.add(meetUpDAO.create(x)));

        List<MeetUp> meetUps = meetUpDAO.getAllWithFilter(new MeetUpDTO("theme", null, null,  null, null));
        Assertions.assertTrue(meetUps.stream().allMatch(meetUp -> "theme".equals(meetUp.getTheme())));
        idList.forEach(meetUpDAO::delete);
    }

    @Test
    void getAllSorted() {
        List<MeetUpDTO> createList = new ArrayList<>();
        List<Long> idList = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> createList.add(new MeetUpDTO("theme" + i, "description", "organizer", new Date(), "place")));
        createList.forEach(x -> idList.add(meetUpDAO.create(x)));
        List<MeetUp> meetUps = meetUpDAO.getAllSorted("theme");
        meetUps.stream().map(MeetUpDTO::fromMeetUp).forEach(System.out::println);
        for (int i = 0; i < meetUps.size() - 1; i++) {
            if (meetUps.get(i).getTheme().compareTo(meetUps.get(i + 1).getTheme()) > 0) {
                Assertions.fail();
            }
        }
        idList.forEach(meetUpDAO::delete);
    }

    @Test
    void createAndDelete() {
        MeetUpDTO meetUpDTO = new MeetUpDTO("theme", "description", "organizer", new Date(), "place");
        Long id = meetUpDAO.create(meetUpDTO);
        assertNotNull(meetUpDAO.getById(id));
        meetUpDAO.delete(id);
        assertNull(meetUpDAO.getById(id));
    }

    @Test
    void update() {
        MeetUpDTO meetUpDTO = new MeetUpDTO("theme", "description", "organizer", new Date(), "place");
        long id = meetUpDAO.create(meetUpDTO);
        MeetUpDTO meetUpDTOUpdate = new MeetUpDTO("new theme", null, null, (Date) null, null);
        meetUpDAO.update(meetUpDTOUpdate, id);
        assertEquals("new theme", meetUpDAO.getById(id).getTheme());
        meetUpDAO.delete(id);
    }
}