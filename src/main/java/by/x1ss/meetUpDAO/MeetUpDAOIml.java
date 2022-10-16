package by.x1ss.meetUpDAO;

import by.x1ss.dto.MeetUpDTO;
import by.x1ss.model.MeetUp;
import by.x1ss.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class MeetUpDAOIml implements MeetUpDAO {
    @Override
    @SuppressWarnings("unchecked")
    public List<MeetUp> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<MeetUp> meetUps = session.createQuery("From MeetUp").list();
        session.close();
        return meetUps;
    }

    @Override
    public MeetUp getById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        MeetUp meetUp = session.get(MeetUp.class, id);
        session.close();
        return meetUp;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MeetUp> getAllWithFilter(MeetUpDTO meetUpDTO) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<MeetUp> meetUps =
                session.createQuery("From MeetUp where " +
                                "(theme = ?1 or ?2 is null) " +
                                "and (description = ?3 or ?4 is null) " +
                                "and (location = ?5 or ?6 is null) " +
                                "and (date = ?7 or ?8 is null)")
                        .setParameter(1, meetUpDTO.getTheme())
                        .setParameter(2, meetUpDTO.getTheme())
                        .setParameter(3, meetUpDTO.getDescription())
                        .setParameter(4, meetUpDTO.getDescription())
                        .setParameter(5, meetUpDTO.getLocation())
                        .setParameter(6, meetUpDTO.getLocation())
                        .setParameter(7, meetUpDTO.getDate())
                        .setParameter(8, meetUpDTO.getDate() == null ? null : meetUpDTO.getDate().toString())
                        .list();
        session.close();
        return meetUps;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MeetUp> getAllSorted(String sortOrder) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<MeetUp> meetUps = session.createQuery("From MeetUp ORDER BY " + sortOrder).list();
        session.close();
        return meetUps;
    }

    @Override
    public Long create(MeetUpDTO meetUpDTO) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        MeetUp meetUp = MeetUpDTO.toMeetUp(meetUpDTO);
        session.save(meetUp);
        session.getTransaction().commit();
        session.close();
        return meetUp.getId();
    }

    @Override
    public void update(MeetUpDTO meetUpDTO, long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        MeetUp meetUpFromDB = session.get(MeetUp.class, id);
        meetUpDTO.setMeetUpNotNullFields(meetUpFromDB);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(session.get(MeetUp.class, id));
        session.getTransaction().commit();
        session.close();
    }
}
