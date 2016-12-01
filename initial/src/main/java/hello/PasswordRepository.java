package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PasswordRepository extends MongoRepository<Password, String> {
    public Password findByHash(String hash);
}
