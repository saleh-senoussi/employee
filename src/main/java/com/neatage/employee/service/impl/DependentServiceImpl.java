package com.neatage.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.neatage.employee.entity.Dependent;
import com.neatage.employee.error.NotFoundException;
import com.neatage.employee.repository.DependentRepository;
import com.neatage.employee.service.DependentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DependentServiceImpl implements DependentService {

    private final DependentRepository dependentRepository;

    @Override
    public Dependent getByDependentId(long dependentId) {
        Optional<Dependent> dependent = this.dependentRepository.findById(dependentId);
        if (dependent.isPresent()) {
            return dependent.get();
        }

        throw new NotFoundException(HttpStatus.NOT_FOUND, "No dependent found for the given id");
    }

    @Override
    public List<Dependent> getAllDependents() {
        List<Dependent> dependents = (List<Dependent>) this.dependentRepository.findAll();
        return dependents;
    }

    @Override
    public Dependent saveDependent(Dependent dependent) {
        return this.dependentRepository.save(dependent);
    }

    @Override
    public void deleteByDependentId(long dependentId) {
        this.dependentRepository.deleteById(dependentId);
    }

    @Override
    public List<Dependent> getByEmployeeId(String employeeId) {
        return this.dependentRepository.findByEmployeeId(employeeId);
    }
}
