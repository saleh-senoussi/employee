package com.neatage.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neatage.employee.entity.Dependent;
import com.neatage.employee.service.DependentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees/dependent")
public class DependentController {

    private final DependentService dependentService;

    @GetMapping("{dependentId}")
    public ResponseEntity<Dependent> getDependentById(@PathVariable long DependentId) {
        Dependent Dependent = this.dependentService.getByDependentId(DependentId);
        return ResponseEntity.ok().body(Dependent);
    }

    @PostMapping()
    public ResponseEntity<Dependent> saveDependent(@RequestBody Dependent Dependent) {
        Dependent savedDependent = this.dependentService.saveDependent(Dependent);
        return ResponseEntity.ok().body(savedDependent);
    }

    @GetMapping()
    public ResponseEntity<List<Dependent>> getAllDependents() {
        List<Dependent> Dependents = this.dependentService.getAllDependents();
        return ResponseEntity.ok().body(Dependents);
    }

    @GetMapping("/all/{employeeId}")
    public ResponseEntity<List<Dependent>> getDependentsByEmployeeId(@PathVariable String employeeId) {
        List<Dependent> dependents = this.dependentService.getByEmployeeId(employeeId);
        return ResponseEntity.ok().body(dependents);
    }

    @DeleteMapping("{dependentId}")
    public ResponseEntity<?> deleteByDependentId(@PathVariable long dependentId) {
        this.dependentService.deleteByDependentId(dependentId);
        return ResponseEntity.ok("Dependent with id: " + dependentId + " has been deleted");
    }
}
