package gpbdemo.controller;

import gpbdemo.entity.Folder;
import gpbdemo.service.FolderService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folders")
@RequiredArgsConstructor
public class FolderController {

  private final FolderService folderService;

  @ApiOperation("Список всех папок")
  @GetMapping("")
  public ResponseEntity<List<Folder>> getAll() {
    return ResponseEntity.ok(folderService.findAll());
  }

  @ApiOperation("Создание новой папки")
  @PostMapping("/insert")
  public ResponseEntity insert(@RequestBody Folder folder) {
    folderService.insert(folder);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
