package com.SpringProject.MyProject.others.MappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MSCInstructorRepository extends JpaRepository<MSC_Instructor,Long> {
    MSC_Instructor save(MSC_Instructor mscInstructor);
    Optional<MSC_Instructor> findById(Long Id);
}
