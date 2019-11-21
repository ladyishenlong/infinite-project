package com.ladyishenlong.datajpadto.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/11/21 5:59 下午
 */
@Data
@Entity
@Table(name = "table_a")
public class TableA implements Serializable {

    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "name")//外键，关联表的主键
    private TableB name;

    private String password;
}
