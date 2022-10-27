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

import com.neatage.employee.entity.Job;
import com.neatage.employee.service.JobService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees/jobs")
public class JobController {

    private final JobService jobService;

    @GetMapping("{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable long jobId) {
        Job job = this.jobService.getByJobId(jobId);
        return ResponseEntity.ok().body(job);
    }

    @PostMapping()
    public ResponseEntity<Job> saveJob(@RequestBody Job job) {
        Job savedJob = this.jobService.saveJob(job);
        return ResponseEntity.ok().body(savedJob);
    }

    @GetMapping("all")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = this.jobService.getAllJobs();
        return ResponseEntity.ok().body(jobs);
    }

    @DeleteMapping("{jobId}")
    public ResponseEntity<?> deleteByJobId(@PathVariable long jobId) {
        this.jobService.deleteByJobId(jobId);
        return ResponseEntity.ok("Job with id: " + jobId + " has been deleted");
    }

    @GetMapping("all/min-salary/greater-than/{minSalary}")
    public ResponseEntity<List<Job>> getAllByMinSalaryGreaterThan(@PathVariable double minSalary) {
        List<Job> jobs = this.jobService.getAllByMinSalaryGreaterThan(minSalary);
        return ResponseEntity.ok().body(jobs);
    }

    @GetMapping("all/min-salary/less-than/{minSalary}")
    public ResponseEntity<List<Job>> getAllByMinSalaryLessThan(@PathVariable double minSalary) {
        List<Job> jobs = this.jobService.getAllByMinSalaryLessThan(minSalary);
        return ResponseEntity.ok().body(jobs);
    }

    @GetMapping("all/max-salary/greater-than/{maxSalary}")
    public ResponseEntity<List<Job>> getAllByMaxSalaryGreaterThan(@PathVariable double maxSalary) {
        List<Job> jobs = this.jobService.getAllByMaxSalaryGreaterThan(maxSalary);
        return ResponseEntity.ok().body(jobs);
    }

    @GetMapping("all/max-salary/less-than/{maxSalary}")
    public ResponseEntity<List<Job>> getAllByMaxSalaryLessThan(@PathVariable double maxSalary) {
        List<Job> jobs = this.jobService.getAllByMaxSalaryLessThan(maxSalary);
        return ResponseEntity.ok().body(jobs);
    }

    @GetMapping("all/job-title/{title}")
    public ResponseEntity<List<Job>> getAllByJobTitleContainsIgnoreCase(@PathVariable String title) {
        List<Job> jobs = this.jobService.getAllByJobTitleContainsIgnoreCase(title);
        return ResponseEntity.ok().body(jobs);
    }
}
