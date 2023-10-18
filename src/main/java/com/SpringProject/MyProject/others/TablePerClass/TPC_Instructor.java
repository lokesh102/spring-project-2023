package com.SpringProject.MyProject.others.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TPC_Instructor extends TPC_User {
    private int rating;
    private String department;
}
