package com.ciberaccion.jobportal.repository;

import com.ciberaccion.jobportal.entity.JobPostActivity;
import com.ciberaccion.jobportal.entity.JobSeekerProfile;
import com.ciberaccion.jobportal.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

    List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);
}
