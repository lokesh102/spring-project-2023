package com.SpringProject.MyProject.others.SingleTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface STMentorRepository extends JpaRepository<ST_Mentor,Long> {
    ST_Mentor save(ST_Mentor stMentor);
}
