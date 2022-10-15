package by.x1ss.controller;

import by.x1ss.meetUpService.MeetUpService;
import by.x1ss.model.MeetUp;
import by.x1ss.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/meetUp")
public class MeetUpController {
    @Autowired
    private MeetUpService meetUpService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody MeetUp meetUp) {
        return ResponseEntity.ok(meetUpService.create(meetUp));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetUp> getById(@PathVariable long id) {
        return ResponseEntity.ok(meetUpService.getById(id));
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<MeetUp>> getAllSorted(@RequestBody(required = false) String sortOrder) {
        if (sortOrder != null) {
            return ResponseEntity.ok(meetUpService.getAllSorted(sortOrder));
        } else {
            return ResponseEntity.ok(meetUpService.getAll());
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<MeetUp>> getAllWithFilter(@RequestParam(required = false) String theme,
                                                         @RequestParam(required = false) String description,
                                                         @RequestParam(required = false) String place,
                                                         @RequestParam(required = false) String date) {
        if (date != null) {
            return ResponseEntity.ok(meetUpService.getAllWithFilter(theme, description, place, DateUtils.stringToDate(date)));
        } else {
            return ResponseEntity.ok(meetUpService.getAllWithFilter(theme, description, place, null));
        }
    }

    @GetMapping
    public ResponseEntity<List<MeetUp>> getAll() {
        return ResponseEntity.ok(meetUpService.getAll());
    }

    @PatchMapping
    public ResponseEntity update(@RequestBody MeetUp meetUp) {
        meetUpService.update(meetUp);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody MeetUp meetUp) {
        meetUpService.delete(meetUp);
        return ResponseEntity.ok().build();
    }
}
