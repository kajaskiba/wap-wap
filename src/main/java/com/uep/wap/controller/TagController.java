package com.uep.wap.controller;

import com.uep.wap.dto.PhotoDTO;
import com.uep.wap.dto.TagDTO;
import com.uep.wap.model.Photo;
import com.uep.wap.model.Tag;
import com.uep.wap.service.PhotoService;
import com.uep.wap.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping(path="/tags")
    public String addTag(@RequestBody TagDTO tagDTO) {
        TagService.addTag(tagDTO);
        return "Tag added successfully";
    }

    @PutMapping(path="/tags/{tag_id}")
    public String eidtTag(@PathVariable int tag_id, @RequestBody TagDTO tagDTO) {
        TagService.editTag(tag_id, tagDTO);
        return "Tag edited successfully";
    }

    @GetMapping(path="/tags")
    public Iterable<Tag> getAllTags() {
        return tagService.getAllTags();
    }
    @GetMapping(path="/{id}")
    public Optional<Tag> getTagById(@PathVariable int id) {
        return TagService.getTagById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTagById(@PathVariable int id) {
        TagService.deleteTag(id);
        return "Photo deleted successfully";
    }


}
