package gpbdemo.controller;

import gpbdemo.entity.Request;
import gpbdemo.service.RequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
@Api
public class RequestController {

  public final RequestService requestService;

  @ApiOperation("Список всех Requests")
  @GetMapping("")
  public ResponseEntity<List<Request>> getAll() {
    return ResponseEntity.ok(requestService.findAll());
  }

  @ApiOperation("Поиск по тегу")
  @GetMapping("/filter-tag/{tagName}")
  public ResponseEntity<List<Request>> getByTagName (@PathVariable String tagName) {
    return ResponseEntity.ok(requestService.findAllByTagName(tagName));
  }

  @ApiOperation("Поиск по папке")
  @GetMapping("/filter-folder/{folderName}")
  public ResponseEntity<List<Request>> getByFolderName (@PathVariable String folderName) {
    return ResponseEntity.ok(requestService.findAllByFolderName(folderName));
  }

  @ApiOperation("Сохранение нового Request")
  @PostMapping("/insert")
  public ResponseEntity insert(@RequestBody Request request) {
    requestService.insert(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @ApiOperation("Изменение Request")
  @PutMapping("/update")
  public ResponseEntity update (@RequestBody Request request) {
    requestService.update(request);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
