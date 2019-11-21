package com.ladyishenlong.datajpadto.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String name;
    private String password;
}
