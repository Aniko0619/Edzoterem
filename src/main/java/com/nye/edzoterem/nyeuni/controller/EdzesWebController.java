package com.nye.edzoterem.nyeuni.controller;

import com.nye.edzoterem.nyeuni.dto.edzes.EdzesRequestDto;
import com.nye.edzoterem.nyeuni.dto.edzes.EdzesResponseDto;
import com.nye.edzoterem.nyeuni.service.EdzesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/edzesek")
public class EdzesWebController {

    private final EdzesService edzesService;

    public EdzesWebController(EdzesService edzesService) {
        this.edzesService = edzesService;
    }

    // LISTÁZÁS
    @GetMapping
    public String lista(Model model) {
        model.addAttribute("edzesek", edzesService.getAllEdzesek());
        return "edzesek/lista";
    }

    // LÉTREHOZÁS - űrlap
    @GetMapping("/uj")
    public String ujForm(Model model) {
        model.addAttribute("edzes", new EdzesRequestDto(null, null));
        return "edzesek/uj";
    }

    // LÉTREHOZÁS - mentés
    @PostMapping("/uj")
    public String letrehozas(@ModelAttribute EdzesRequestDto dto) {
        edzesService.createEdzes(dto);
        return "redirect:/edzesek";
    }

    // MÓDOSÍTÁS - űrlap
    @GetMapping("/szerkesztes/{id}")
    public String szerkesztesForm(@PathVariable Long id, Model model) {
        EdzesResponseDto edzes = edzesService.getEdzesById(id);
        EdzesRequestDto dto = EdzesRequestDto.builder()
                .edzesprogramNeve(edzes.getEdzesprogramNeve())
                .edzoNeve(edzes.getEdzoNeve())
                .build();
        model.addAttribute("edzes", dto);
        model.addAttribute("id", id);
        return "edzesek/szerkesztes";
    }

    // MÓDOSÍTÁS - frissítés
    @PostMapping("/szerkesztes/{id}")
    public String modositas(@PathVariable Long id, @ModelAttribute EdzesRequestDto dto) {
        edzesService.updateEdzes(id, dto);
        return "redirect:/edzesek";
    }

    // TÖRLÉS
    @GetMapping("/torles/{id}")
    public String torles(@PathVariable Long id) {
        edzesService.deleteEdzes(id);
        return "redirect:/edzesek";
    }


    //http://localhost:8080/edzesek/teszt
    @GetMapping("/teszt")
    @ResponseBody
    public String teszt() {
        return "WebController működik!";
    }
}