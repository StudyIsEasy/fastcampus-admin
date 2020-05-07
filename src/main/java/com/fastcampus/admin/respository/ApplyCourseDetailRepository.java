package com.fastcampus.admin.respository;

import com.fastcampus.admin.entity.ApplyCourseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyCourseDetailRepository extends JpaRepository<ApplyCourseDetail, Long> {
}
