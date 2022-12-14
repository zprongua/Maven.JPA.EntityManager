package controllers;

import entities.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.ArtistService;

@Controller
@RequestMapping("/music")
public class ArtistController {

    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artist")
    public ResponseEntity<Iterable<Artist>> getAll() {
        return new ResponseEntity<>(artistService.index(), HttpStatus.OK);
    }

    @GetMapping("/artist/{id}")
    public ResponseEntity<Artist> show(@PathVariable Long id) {
        return new ResponseEntity<>(artistService.show(id), HttpStatus.OK);
    }

    @PostMapping("/artist")
    public ResponseEntity<Artist> create(@RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.create(artist), HttpStatus.CREATED);
    }

    @PutMapping("/artist/{id}")
    public ResponseEntity<Artist> update(@PathVariable Long id, @RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.update(id, artist), HttpStatus.OK);
    }

    @DeleteMapping("/artist/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(artistService.delete(id), HttpStatus.OK);
    }
}
