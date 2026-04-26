package com.nye.edzoterem.nyeuni.controller;

import java.util.List;

import com.nye.edzoterem.nyeuni.dto.edzes.EdzesRequestDto;
import com.nye.edzoterem.nyeuni.dto.edzes.EdzesResponseDto;
import com.nye.edzoterem.nyeuni.service.EdzesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/edzesek")
@RequiredArgsConstructor
public class EdzesController {

    private final EdzesService edzesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EdzesResponseDto createEdzesResponse(@RequestBody EdzesRequestDto requestDto) {
        return edzesService.createEdzes(requestDto);
    }

    @GetMapping
    public List<EdzesResponseDto> getAllEdzesek() {
        return edzesService.getAllEdzesek();
    }

    @GetMapping("/{id}")
    public EdzesResponseDto getEdzesById(@PathVariable Long id) {
        return edzesService.getEdzesById(id);
    }

    @PutMapping("/{id}")
    public EdzesResponseDto updateEdzesResponse(@PathVariable Long id,
                                                @RequestBody EdzesRequestDto requestDto) {
        return edzesService.updateEdzes(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEdzes(@PathVariable Long id) {
        edzesService.deleteEdzes(id);
    }

    @GetMapping("/hello")
    public String hello() {
        return "API is working!";
    }
}