package gpbdemo.controller;

import gpbdemo.entity.Folder;
import gpbdemo.entity.Tag;
import gpbdemo.service.TagService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {
  private final TagService tagService;

  @ApiOperation("Список всех tags")
  @GetMapping("")
  public ResponseEntity<List<Tag>> getAll() {
    return ResponseEntity.ok(tagService.findAll());
  }


  @ApiOperation("создание нового tag")
  @PostMapping("/insert")
  public ResponseEntity insert(@RequestBody Tag tag) {
    tagService.insert(tag);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
