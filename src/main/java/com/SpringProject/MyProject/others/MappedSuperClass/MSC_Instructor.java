package com.SpringProject.MyProject.others.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MSC_Instructor extends MSC_User {
    private int rating;
    private String department;


}
