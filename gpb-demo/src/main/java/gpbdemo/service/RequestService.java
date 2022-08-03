package gpbdemo.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import gpbdemo.entity.Request;
import gpbdemo.entity.Tag;
import gpbdemo.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RequestService {
  MongoTemplate mongoTemplate;
  public final RequestRepository requestRepository;

  public List<Request> findAll() {
    return requestRepository.findAll();
  }

  public List<Request> findAllByTagName(String tagName) {
    return requestRepository.findAllByTag(tagName).stream().toList();
  }

  public List<Request> findAllByFolderName(String folderName) {
    return requestRepository.findAllByFolderName(folderName).stream().toList();
  }


  public void insert(Request request) {
    requestRepository.insert(request);
  }

  public void update(Request request) {
    Request updatingRequest = requestRepository.findById(request.getId()).get();

    if (updatingRequest == null) {
      return;
    }

    ZoneId zoneId = ZoneId.systemDefault();
    updatingRequest.setModifiedDate(LocalDateTime.now().atZone(zoneId).toEpochSecond());
    updatingRequest.setTagList(request.getTagList());
    updatingRequest.setFolder(request.getFolder());

    requestRepository.save(updatingRequest);
  }
}
