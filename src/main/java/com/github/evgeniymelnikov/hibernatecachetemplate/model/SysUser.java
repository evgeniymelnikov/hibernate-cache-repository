package com.github.evgeniymelnikov.hibernatecachetemplate.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "t_sys_users", schema = "sc")
@PrimaryKeyJoinColumn(name = "id")
public class SysUser extends User {

    private LocalDate dateBegin;
}
