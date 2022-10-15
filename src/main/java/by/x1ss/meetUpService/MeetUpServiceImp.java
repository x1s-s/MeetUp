package by.x1ss.meetUpService;

import by.x1ss.meetUpDAO.MeetUpDAO;
import by.x1ss.model.MeetUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MeetUpServiceImp implements MeetUpService {
    @Autowired
    private MeetUpDAO meetUpDAO;

    @Override
    public List<MeetUp> getAll() {
        return meetUpDAO.getAll();
    }

    @Override
    public MeetUp getById(long id) {
        return meetUpDAO.getById(id);
    }

    @Override
    public List<MeetUp> getAllWithFilter(String theme, String description, String location, Date date) {
        return meetUpDAO.getAllWithFilter(theme, description, location, date);
    }

    @Override
    public List<MeetUp> getAllSorted(String sortOrder) {
        return meetUpDAO.getAllSorted(sortOrder);
    }

    @Override
    public Long create(MeetUp meetUp) {
        return meetUpDAO.create(meetUp);
    }

    @Override
    public void update(MeetUp meetUp) {
        meetUpDAO.update(meetUp);
    }

    @Override
    public void delete(MeetUp meetUp) {
        meetUpDAO.delete(meetUp);
    }
}
