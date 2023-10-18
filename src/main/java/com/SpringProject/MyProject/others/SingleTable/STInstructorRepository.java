package com.SpringProject.MyProject.others.SingleTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface STInstructorRepository extends JpaRepository<ST_Instructor,Long> {
    ST_Instructor save(ST_Instructor stInstructor);
}
