package com.nye.edzoterem.nyeuni.service;

import com.nye.edzoterem.nyeuni.dto.tag.TagRequestDto;
import com.nye.edzoterem.nyeuni.dto.tag.TagResponseDto;
import com.nye.edzoterem.nyeuni.entity.Edzes;
import com.nye.edzoterem.nyeuni.entity.Tag;
import com.nye.edzoterem.nyeuni.entity.exception.ResourceNotFoundException;
import com.nye.edzoterem.nyeuni.repository.EdzesRepository;
import com.nye.edzoterem.nyeuni.repository.TagRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;
    private final EdzesRepository edzesRepository;

    public TagService(TagRepository tagRepository, EdzesRepository edzesRepository) {
        this.tagRepository = tagRepository;
        this.edzesRepository = edzesRepository;
    }

    public TagResponseDto createTag(TagRequestDto requestDto) {
        Edzes edzes = null;
        if (requestDto.getEdzesId() != null) {
            edzes = edzesRepository.findById(requestDto.getEdzesId())
                    .orElseThrow(() -> new ResourceNotFoundException("Edzes not found"));
        }
        Tag tag = Tag.builder()
                .tagNeve(requestDto.getTagNeve())
                .kor(requestDto.getKor())
                .edzes(edzes)
                .build();
        return mapToDto(tagRepository.save(tag));
    }

    public List<TagResponseDto> getAllTagok() {
        return tagRepository.findAll().stream().map(this::mapToDto).toList();
    }

    public TagResponseDto getTagById(Long id) {
        return mapToDto(tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found")));
    }

    public TagResponseDto updateTag(Long id, TagRequestDto requestDto) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found"));
        tag.setTagNeve(requestDto.getTagNeve());
        tag.setKor(requestDto.getKor());
        if (requestDto.getEdzesId() != null) {
            Edzes edzes = edzesRepository.findById(requestDto.getEdzesId())
                    .orElseThrow(() -> new ResourceNotFoundException("Edzes not found"));
            tag.setEdzes(edzes);
        } else {
            tag.setEdzes(null);
        }
        return mapToDto(tagRepository.save(tag));
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    private TagResponseDto mapToDto(Tag tag) {
        return TagResponseDto.builder()
                .tagId(tag.getTagId())
                .tagNeve(tag.getTagNeve())
                .kor(tag.getKor())
                .edzesId(tag.getEdzes() != null ? tag.getEdzes().getEdzesId() : null)
                .edzesprogramNeve(tag.getEdzes() != null ? tag.getEdzes().getEdzesprogramNeve() : null)
                .build();
    }
}