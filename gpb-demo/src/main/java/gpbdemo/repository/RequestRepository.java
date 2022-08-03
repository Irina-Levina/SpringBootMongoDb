package gpbdemo.repository;

import gpbdemo.entity.Request;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


@Repository
public interface RequestRepository extends MongoRepository<Request, Long> {

  @Query("{'tags.name':?0}")
  List<Request> findAllByTag(String tagName);
  @Query("{'folder.name':?0}")
  List<Request> findAllByFolderName(String folderName);

}
