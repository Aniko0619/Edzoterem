package com.nye.edzoterem.nyeuni.controller;

import com.nye.edzoterem.nyeuni.dto.edzes.EdzesRequestDto;
import com.nye.edzoterem.nyeuni.dto.edzes.EdzesResponseDto;
import com.nye.edzoterem.nyeuni.service.EdzesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/edzesek")
// Ezt az edzes controllert innentol kezdve a http://localhost:8080/api/edzesek
@RequiredArgsConstructor
public class EdzesController {

private final EdzesService edzesService;

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public EdzesResponseDto createEdzesResponse(@RequestBody EdzesRequestDto requestDto) {        // RequestBody : innen jon a JSON
   return  edzesService.createEdzes(requestDto);
}

@GetMapping
    public List<EdzesResponseDto>getAllEdzesek(){
    return edzesService.getAllEdzesek();
}
@GetMapping("/{id}")
//  http://localhost:8080/api/edzesek/120
    public EdzesResponseDto getEdzesById(@PathVariable Long id){
    return edzesService.getEdzesById(id);
}


// Put való az uodate-hez
    @PutMapping("/{id}")
    public EdzesResponseDto updateEdzesResponse(@PathVariable Long id, @RequestBody EdzesRequestDto requestDto){
    return edzesService.updateEdzes(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEdzes(@PathVariable Long id){
    edzesService.deleteEdzes(id);
    }

    //TESZT   ---> http://localhost:8080/api/edzesek/hello

    @GetMapping("/hello")
    public String hello() {
        return "API is working!";
    }

}


/*  ELLENŐRZÉS:

* http://localhost:8080/api/edzesek/hello --> API is working!
* Tehát:
  - A Spring Boot alkalmazás elindult
  - A szerver fut a localhost:8080-on
  - A Controller elérhető
*
http://localhost:8080/api/edzesek ---> []
Tehát:
*
* */