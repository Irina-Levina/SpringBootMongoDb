package gpbdemo.service;

import gpbdemo.entity.Folder;
import gpbdemo.repository.FolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderService {

  private final FolderRepository folderRepository;

  public List<Folder> findAll() {
    return folderRepository.findAll();
  }

  public void insert(Folder folder) {
    folderRepository.insert(folder);
  }
}
