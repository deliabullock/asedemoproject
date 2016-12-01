package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhraseRepository extends MongoRepository<Phrase, String> {
    public Phrase findById(String id);
}
