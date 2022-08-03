package gpbdemo.repository;

import gpbdemo.entity.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag,Long> {
}
