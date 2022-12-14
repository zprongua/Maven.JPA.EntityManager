package services;

import entities.Artist;
import entities.CD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CDRepository;

@Service
public class CDService {

    private CDRepository cdRepository;

    @Autowired
    public CDService(CDRepository cdRepository) {
        this.cdRepository = cdRepository;
    }

    public Iterable<CD> index() {
        return cdRepository.findAll();
    }

    public CD show(Long id) {
        return cdRepository.findById(id).get();
    }

    public CD create(CD cd) {
        return cdRepository.save(cd);
    }

    public CD update(Long id, CD newCDData) {
        CD originalCD = cdRepository.findById(id).get();
        originalCD.setTitle(newCDData.getTitle());
        originalCD.setArtist(newCDData.getArtist());
        originalCD.setYear(newCDData.getYear());
        originalCD.setPrice(newCDData.getPrice());
        return cdRepository.save(originalCD);
    }

    public Boolean delete(Long id) {
        cdRepository.deleteById(id);
        return true;
    }
}
