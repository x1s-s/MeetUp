package by.x1ss.MeetUpDAO;

import by.x1ss.model.MeetUp;
import by.x1ss.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class MeetUpDAOIml implements MeetUpDAO{
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
    public List<MeetUp> getAllWithFilter(String theme, String description, String place, Date date) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<MeetUp> meetUps =
                session.createQuery("From MeetUp where " +
                                "(theme = ?1 or ?2 is null) " +
                                "and (description = ?3 or ?4 is null) " +
                                "and (place = ?5 or ?6 is null) " +
                                "and (date = ?7 or ?8 is null)")
                        .setParameter(1, theme)
                        .setParameter(2, theme)
                        .setParameter(3, description)
                        .setParameter(4, description)
                        .setParameter(5, place)
                        .setParameter(6, place)
                        .setParameter(7, date)
                        .setParameter(8, date)
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
    public Long create(MeetUp meetUp) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(meetUp);
        session.getTransaction().commit();
        session.close();
        return meetUp.getId();
    }

    @Override
    public void update(MeetUp meetUp) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(meetUp);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(MeetUp meetUp) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(meetUp);
        session.getTransaction().commit();
        session.close();
    }
}
