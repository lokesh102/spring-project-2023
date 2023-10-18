package com.SpringProject.MyProject.others.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCInstructorRepository extends JpaRepository<TPC_Instructor,Long> {
    TPC_Instructor save(TPC_Instructor tpcInstructor);

}
