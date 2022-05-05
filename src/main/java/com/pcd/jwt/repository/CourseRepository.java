package com.pcd.jwt.repository;

import com.pcd.jwt.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Courses,Long> {
  /*  @Query("SELECT e FROM Courses e WHERE e.formerEmail=?1")
    List<Courses> findCoursesByEmail(String formerEmail);

    @Query("SELECT c from Courses c  WHERE c.category= ?1 ")
    List<Courses> findByCategory(String category);
    @Query("SELECT c from Courses c  WHERE c.category LIKE %:title%" )
    List<Courses> findAllCategory(String category);
*/
  @Query("SELECT c from Courses c  WHERE c.category= ?1 ")
  List<Courses> findByCategory(String category);
  @Query("SELECT ci from Courses ci  WHERE ci.city= ?1 ")
  List<Courses> findByCity(String city);
  @Query("SELECT e FROM Courses e WHERE e.formerEmail=?1")
  List<Courses> findCoursesByEmail(String formerEmail);
}

