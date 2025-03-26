package com.example.onetoMany.controller;

import com.example.onetoMany.DTO.ProfessorDTO;
import com.example.onetoMany.DTO.CourseDTO;
import com.example.onetoMany.entities.Professor;
import com.example.onetoMany.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    // Get all professors
    @GetMapping
    public List<ProfessorDTO> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    // Get professor by ID
    @GetMapping("/{id}")
    public ProfessorDTO getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

    // Save a professor
    @PostMapping
    public ProfessorDTO saveProfessor(@RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    // Retrieve all courses taught by a professor
    @GetMapping("/{id}/courses")
    public List<CourseDTO> getCoursesByProfessor(@PathVariable Long id) {
        return professorService.getCoursesByProfessor(id);
    }
}
