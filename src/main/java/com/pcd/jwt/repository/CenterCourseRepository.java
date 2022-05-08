package com.pcd.jwt.repository;

import com.pcd.jwt.entity.CenterCourses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterCourseRepository  extends JpaRepository<CenterCourses,Long> {
}
