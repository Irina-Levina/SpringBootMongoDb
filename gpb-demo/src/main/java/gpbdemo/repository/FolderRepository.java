package gpbdemo.repository;

import gpbdemo.entity.Folder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FolderRepository extends MongoRepository<Folder,Long> {
}
