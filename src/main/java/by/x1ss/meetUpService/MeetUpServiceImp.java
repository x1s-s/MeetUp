package by.x1ss.meetUpService;

import by.x1ss.dto.MeetUpDTO;
import by.x1ss.meetUpDAO.MeetUpDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeetUpServiceImp implements MeetUpService {
    @Autowired
    private MeetUpDAO meetUpDAO;

    @Override
    public List<MeetUpDTO> getAll() {
        return meetUpDAO.getAll().stream().map(MeetUpDTO::fromMeetUp).collect(Collectors.toList());
    }

    @Override
    public MeetUpDTO getById(long id) {
        return MeetUpDTO.fromMeetUp(meetUpDAO.getById(id));
    }

    @Override
    public List<MeetUpDTO> getAllWithFilter(MeetUpDTO meetUpDTO) {
        return meetUpDAO.getAllWithFilter(meetUpDTO).stream().map(MeetUpDTO::fromMeetUp).collect(Collectors.toList());
    }

    @Override
    public List<MeetUpDTO> getAllSorted(String sortOrder) {
        return meetUpDAO.getAllSorted(sortOrder).stream().map(MeetUpDTO::fromMeetUp).collect(Collectors.toList());
    }

    @Override
    public Long create(MeetUpDTO meetUpDTO) {
        return meetUpDAO.create(meetUpDTO);
    }

    @Override
    public void update(MeetUpDTO meetUpDTO, long id) {
        meetUpDAO.update(meetUpDTO, id);
    }

    @Override
    public void delete(long id) {
        meetUpDAO.delete(id);
    }
}
