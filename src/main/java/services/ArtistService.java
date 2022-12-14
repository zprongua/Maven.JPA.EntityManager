package services;

import entities.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ArtistRepository;

@Service
public class ArtistService {

    private ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Iterable<Artist> index() {
        return artistRepository.findAll();
    }

    public Artist show(Long id) {
        return artistRepository.findById(id).get();
    }

    public Artist create(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist update(Long id, Artist newArtistData) {
        Artist originalArtist = artistRepository.findById(id).get();
        originalArtist.setName(newArtistData.getName());
        return artistRepository.save(originalArtist);
    }

    public Boolean delete(Long id) {
        artistRepository.deleteById(id);
        return true;
    }
}
