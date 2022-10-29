package by.x1ss.controller;

import by.x1ss.dto.MeetUpDTO;
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
    public ResponseEntity<Long> create(@RequestBody MeetUpDTO meetUpDTO) {
        return ResponseEntity.ok(meetUpService.create(meetUpDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetUpDTO> getById(@PathVariable long id) {
        return ResponseEntity.ok(meetUpService.getById(id));
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<MeetUpDTO>> getAllSorted(@RequestParam(name = "sortOrder") String sortOrder) {
        return ResponseEntity.ok(meetUpService.getAllSorted(sortOrder));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<MeetUpDTO>> getAllWithFilter(@RequestParam(name = "MeetUpDTO") MeetUpDTO meetUpDTO) {
        return ResponseEntity.ok(meetUpService.getAllWithFilter(meetUpDTO));
    }

    @GetMapping
    public ResponseEntity<List<MeetUpDTO>> getAll() {
        return ResponseEntity.ok(meetUpService.getAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@RequestBody MeetUpDTO meetUpDTO, @PathVariable long id) {
        meetUpService.update(meetUpDTO,id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        meetUpService.delete(id);
        return ResponseEntity.ok().build();
    }
}
