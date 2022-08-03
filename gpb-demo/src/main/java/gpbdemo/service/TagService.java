package gpbdemo.service;

import gpbdemo.entity.Tag;
import gpbdemo.repository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagService {
  private final TagRepository tagRepository;

  public List<Tag> findAll() {
    return tagRepository.findAll();
  }

  public void insert(Tag tag) {
    tagRepository.insert(tag);
  }
}
