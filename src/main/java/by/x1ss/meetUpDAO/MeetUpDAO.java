package by.x1ss.meetUpDAO;

import by.x1ss.dto.MeetUpDTO;
import by.x1ss.model.MeetUp;

import java.util.Date;
import java.util.List;

public interface MeetUpDAO {
    List<MeetUp> getAll();

    MeetUp getById(long id);

    List<MeetUp> getAllWithFilter(MeetUpDTO meetUpDTO);

    List<MeetUp> getAllSorted(String sortOrder);

    Long create(MeetUpDTO meetUpDTO);

    void update(MeetUpDTO meetUpDTO, long id);

    void delete(long id);
}
