package by.x1ss.model;

import by.x1ss.utils.DateUtils;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "meet_up")
@EqualsAndHashCode
public class MeetUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "description")
    private String description;

    @Column(name = "organizer")
    private String organizer;

    @Column(name = "date")
    private Date date;

    @Column(name = "location")
    private String location;

    public MeetUp(String theme, String description, String organizer, Date date, String location) {
        this.theme = theme;
        this.description = description;
        this.organizer = organizer;
        this.date = date;
        this.location = location;
    }

    public MeetUp(String theme, String description, String organizer, String date, String location) {
        this(theme, description, organizer, DateUtils.stringToDate(date), location);
    }

    public void setDate(String date){
        this.date = DateUtils.stringToDate(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
