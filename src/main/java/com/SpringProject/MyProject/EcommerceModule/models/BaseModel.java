package com.SpringProject.MyProject.EcommerceModule.models;

import com.mysql.cj.jdbc.jmx.LoadBalanceConnectionGroupManager;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt;
    private Date deletedAt;
    private Date modifiedAt;
}
