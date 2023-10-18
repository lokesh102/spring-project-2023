package com.SpringProject.MyProject.others.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class JT_Mentor extends JT_User {
    private int experience;
    private String address;
}
