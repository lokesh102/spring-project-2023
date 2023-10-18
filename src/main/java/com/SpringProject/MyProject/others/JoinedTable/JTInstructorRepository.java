package com.SpringProject.MyProject.others.JoinedTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTInstructorRepository extends JpaRepository<JT_Instructor,Long> {
    JT_Instructor save(JT_Instructor jtInstructor);
}
