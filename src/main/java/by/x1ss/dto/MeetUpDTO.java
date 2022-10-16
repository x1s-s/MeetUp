package by.x1ss.dto;

import by.x1ss.model.MeetUp;
import by.x1ss.utils.DateUtils;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MeetUpDTO {
    private String theme;
    private String description;
    private String organizer;
    private Date date;
    private String location;

    public static MeetUpDTO fromMeetUp(MeetUp meetUp) {
        MeetUpDTO meetUpDTO = new MeetUpDTO();
        meetUpDTO.setTheme(meetUp.getTheme());
        meetUpDTO.setDescription(meetUp.getDescription());
        meetUpDTO.setLocation(meetUp.getLocation());
        meetUpDTO.setDate(meetUp.getDate());
        meetUpDTO.setOrganizer(meetUp.getOrganizer());
        return meetUpDTO;
    }

    public static MeetUp toMeetUp(MeetUpDTO meetUpDTO) {
        MeetUp meetUp = new MeetUp();
        meetUp.setTheme(meetUpDTO.getTheme());
        meetUp.setDescription(meetUpDTO.getDescription());
        meetUp.setOrganizer(meetUpDTO.getOrganizer());
        meetUp.setLocation(meetUpDTO.getLocation());
        meetUp.setDate(meetUpDTO.getDate());
        return meetUp;
    }

    public void setMeetUpNotNullFields(MeetUp meetUp) {
        if (theme != null) {
            meetUp.setTheme(theme);
        }
        if (description != null) {
            meetUp.setDescription(description);
        }
        if (location != null) {
            meetUp.setLocation(location);
        }
        if (date != null) {
            meetUp.setDate(date);
        }
        if(organizer != null){
            meetUp.setOrganizer(organizer);
        }
    }

    public void setDate(String date) {
        this.date = DateUtils.stringToDate(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
