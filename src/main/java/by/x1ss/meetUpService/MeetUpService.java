package by.x1ss.meetUpService;

import by.x1ss.dto.MeetUpDTO;
import by.x1ss.model.MeetUp;

import java.util.Date;
import java.util.List;

public interface MeetUpService {
    List<MeetUpDTO> getAll();

    MeetUpDTO getById(long id);

    List<MeetUpDTO> getAllWithFilter(MeetUpDTO meetUpDTO);

    List<MeetUpDTO> getAllSorted(String sortOrder);

    Long create(MeetUpDTO meetUpDTO);

    void update(MeetUpDTO meetUpDTO, long id);

    void delete(long id);
}
