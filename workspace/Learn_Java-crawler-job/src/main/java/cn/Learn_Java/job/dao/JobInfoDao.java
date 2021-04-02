package cn.Learn_Java.job.dao;

import cn.Learn_Java.job.pojo.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobInfoDao extends JpaRepository<JobInfo, Long> {
}
