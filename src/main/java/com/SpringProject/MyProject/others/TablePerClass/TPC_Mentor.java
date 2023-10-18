package com.SpringProject.MyProject.others.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TPC_Mentor extends TPC_User {
    private int experience;
    private String address;
}
