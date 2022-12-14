package controllers;

import entities.CD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.CDService;

@Controller
@RequestMapping("/music")
public class CDController {

    private CDService cdService;

    @Autowired
    public CDController(CDService cdService) {
        this.cdService = cdService;
    }

    @GetMapping("/cd")
    public ResponseEntity<Iterable<CD>> getAll() {
        return new ResponseEntity<>(cdService.index(), HttpStatus.OK);
    }

    @GetMapping("/cd/{id}")
    public ResponseEntity<CD> show(@PathVariable Long id) {
        return new ResponseEntity<>(cdService.show(id), HttpStatus.OK);
    }

    @PostMapping("/cd")
    public ResponseEntity<CD> create(@RequestBody CD cd) {
        return new ResponseEntity<>(cdService.create(cd), HttpStatus.CREATED);
    }

    @PutMapping("/cd/{id}")
    public ResponseEntity<CD> update(@PathVariable Long id, @RequestBody CD cd) {
        return new ResponseEntity<>(cdService.update(id, cd), HttpStatus.OK);
    }

    @DeleteMapping("/cd/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(cdService.delete(id), HttpStatus.OK);
    }
}
