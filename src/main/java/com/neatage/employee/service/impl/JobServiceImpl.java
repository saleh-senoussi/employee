package com.neatage.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.neatage.employee.entity.Job;
import com.neatage.employee.error.NotFoundException;
import com.neatage.employee.repository.JobRepository;
import com.neatage.employee.service.JobService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public Job getByJobId(long jobId) {
        Optional<Job> job = this.jobRepository.findById(jobId);
        if (job.isPresent()) {
            return job.get();
        }

        throw new NotFoundException(HttpStatus.NOT_FOUND, "No job found for the given id");
    }

    @Override
    public List<Job> getAllJobs() {
        List<Job> jobs = this.jobRepository.findAll();
        return jobs;
    }

    @Override
    public Job saveJob(Job job) {
        return this.jobRepository.save(job);
    }

    @Override
    public void deleteByJobId(long jobId) {
        this.jobRepository.deleteById(jobId);
    }

    @Override
    public List<Job> getAllByMinSalaryGreaterThan(double minSalary) {
        return this.jobRepository.findByMinSalaryGreaterThan(minSalary);
    }

    @Override
    public List<Job> getAllByMinSalaryLessThan(double minSalary) {
        return this.jobRepository.findByMinSalaryLessThan(minSalary);
    }

    @Override
    public List<Job> getAllByMaxSalaryGreaterThan(double maxSalary) {
        return this.jobRepository.findByMaxSalaryGreaterThan(maxSalary);
    }

    @Override
    public List<Job> getAllByMaxSalaryLessThan(double maxSalary) {
        return this.jobRepository.findByMaxSalaryLessThan(maxSalary);
    }

    @Override
    public List<Job> getAllByJobTitleContainsIgnoreCase(String title) {
        return this.jobRepository.findByJobTitleContainsIgnoreCase(title);
    }

}
