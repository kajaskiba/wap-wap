package com.uep.wap.service;

import com.uep.wap.dto.TagDTO;
import com.uep.wap.model.Tag;
import com.uep.wap.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private static TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public static void addTag(TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setName(tagDTO.getTagName());

        tagRepository.save(tag);
    }

    public static void editTag(int tag_id, TagDTO tagDTO) {
        Tag tag = tagRepository.findById(tag_id).get();
        tag.setName(tagDTO.getTagName());

        tagRepository.save(tag);
    }




    public Iterable<Tag> getAllTags() {return tagRepository.findAll();}
    public static Optional<Tag> getTagById(int id) {return tagRepository.findById(id);}
    public void deleteTagById(int id) {tagRepository.deleteById(id);}
    public Tag findCategoryByName(String name) {return tagRepository.findByName(name);}
    public static void deleteTag(int id) {tagRepository.deleteById(id);}
}
