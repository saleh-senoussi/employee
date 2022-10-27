package com.neatage.employee.service;

import java.util.List;

import com.neatage.employee.entity.Dependent;

public interface DependentService {
    Dependent getByDependentId(long dependentId);

    List<Dependent> getAllDependents();

    Dependent saveDependent(Dependent dependent);

    void deleteByDependentId(long dependentId);

    List<Dependent> getByEmployeeId(String employeeId);
}
