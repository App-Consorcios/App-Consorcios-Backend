package com.seminario.controller;

import com.seminario.dto.ReunionDTO;
import com.seminario.service.ReunionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReunionController {

    @Autowired
    private ReunionService reunionService;

    @PostMapping(value = "/reunion")
    public ReunionDTO saveReunion(@RequestBody ReunionDTO reunionDTO) {
        return reunionService.saveReunion(reunionDTO);
    }

    @DeleteMapping(value = "/reunion")
    public Boolean deleteReunion(@RequestParam(value="id") Long id) {
        return reunionService.deleteReunion(id);
    }

    @GetMapping(value = "/reuniones")
    public List<ReunionDTO> getReuniones() {
        return reunionService.getReuniones();
    }

    @PutMapping(value = "/reunion")
    public ReunionDTO updateReunion(@RequestParam(value="id") Long id, @RequestBody ReunionDTO reunionDTO) {
        return reunionService.updateReunion(id, reunionDTO);
    }

}
