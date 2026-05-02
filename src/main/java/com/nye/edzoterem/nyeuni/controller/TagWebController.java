package com.nye.edzoterem.nyeuni.controller;

import com.nye.edzoterem.nyeuni.dto.tag.TagRequestDto;
import com.nye.edzoterem.nyeuni.service.EdzesService;
import com.nye.edzoterem.nyeuni.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tagok")
public class TagWebController {

    private final TagService tagService;
    private final EdzesService edzesService;

    public TagWebController(TagService tagService, EdzesService edzesService) {
        this.tagService = tagService;
        this.edzesService = edzesService;
    }

    // LISTÁZÁS
    @GetMapping
    public String lista(Model model) {
        model.addAttribute("tagok", tagService.getAllTagok());
        return "tagok/lista";
    }

    // LÉTREHOZÁS - űrlap
    @GetMapping("/uj")
    public String ujForm(Model model) {
        model.addAttribute("tag", new TagRequestDto(null, null, null));
        model.addAttribute("edzesek", edzesService.getAllEdzesek());
        return "tagok/uj";
    }

    // LÉTREHOZÁS - mentés
    @PostMapping("/uj")
    public String letrehozas(@ModelAttribute TagRequestDto dto) {
        tagService.createTag(dto);
        return "redirect:/tagok";
    }

    // TÖRLÉS
    @GetMapping("/torles/{id}")
    public String torles(@PathVariable Long id) {
        tagService.deleteTag(id);
        return "redirect:/tagok";
    }
}