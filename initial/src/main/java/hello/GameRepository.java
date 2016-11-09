package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {

    public Game findByName(String name);
    public List<Game> findByCreator(String creator);

}
