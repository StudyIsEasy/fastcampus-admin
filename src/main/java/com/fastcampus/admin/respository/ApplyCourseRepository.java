package com.fastcampus.admin.respository;

import com.fastcampus.admin.entity.ApplyCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyCourseRepository extends JpaRepository<ApplyCourse, Long> {
}
