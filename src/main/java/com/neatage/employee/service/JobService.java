package com.neatage.employee.service;

import java.util.List;

import com.neatage.employee.entity.Job;

public interface JobService {
    Job getByJobId(long jobId);

    List<Job> getAllJobs();

    Job saveJob(Job job);

    void deleteByJobId(long jobId);

    List<Job> getAllByMinSalaryGreaterThan(double minSalary);

    List<Job> getAllByMinSalaryLessThan(double minSalary);

    List<Job> getAllByMaxSalaryGreaterThan(double maxSalary);

    List<Job> getAllByMaxSalaryLessThan(double maxSalary);

    List<Job> getAllByJobTitleContainsIgnoreCase(String title);
}
