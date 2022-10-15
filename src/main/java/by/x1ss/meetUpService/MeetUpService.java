package by.x1ss.meetUpService;

import by.x1ss.model.MeetUp;

import java.util.Date;
import java.util.List;

public interface MeetUpService {
    List<MeetUp> getAll();
    MeetUp getById(long id);
    List<MeetUp> getAllWithFilter(String theme, String description, String location, Date date);
    List<MeetUp> getAllSorted(String sortOrder);
    Long create(MeetUp meetUp);
    void update(MeetUp meetUp);
    void delete(MeetUp meetUp);
}
