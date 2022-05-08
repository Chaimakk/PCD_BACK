package com.pcd.jwt.repository;

import com.pcd.jwt.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseRepository extends JpaRepository<Courses,Long> {
  /*  @Query("SELECT e FROM Courses e WHERE e.formerEmail=?1")
    List<Courses> findCoursesByEmail(String formerEmail);

    @Query("SELECT c from Courses c  WHERE c.category= ?1 ")
    List<Courses> findByCategory(String category);
    @Query("SELECT c from Courses c  WHERE c.category LIKE %:title%" )
    List<Courses> findAllCategory(String category);

*/
  List<Courses> findFirst5ByIsFavorite(boolean isFavorite);
  @Query("SELECT fc from Courses fc  WHERE fc.CourseName= ?1 and fc.formerEmail=?2")
  List<Courses> findByCourseAndFormer(String CourseName,String formerEmail);


  @Query("SELECT c from Courses c  WHERE c.category= ?1 ")
  List<Courses> findByCategory(String category);
  @Query("SELECT ci from Courses ci  WHERE ci.city= ?1 ")
  List<Courses> findByCity(String city);
  @Query("SELECT e FROM Courses e WHERE e.formerEmail=?1")
  List<Courses> findCoursesByEmail(String formerEmail);
  @Query("SELECT DISTINCT ce.formerEmail, ce.picture , ce.formerName FROM Courses ce")
  List findDistinctCoursesByEmail();
  @Query("SELECT DISTINCT  p.picture  FROM Courses p where p.formerEmail=?1 ")
  List findPictureByEmail(String formerEmail);
  @Query("SELECT f from Courses f where f.isFavorite=?1")
  List<Courses> findByFavorite(Boolean isFavorites);
  @Transactional
  @Modifying
  @Query("update Courses cf set cf.isFavorite =true  where cf.id = ?1")
  void setIsFavoriteById(Long id );
  @Query("SELECT fc from Courses fc where fc.isFavorite=true ")
  List<Courses> findAllFavorite();


}

