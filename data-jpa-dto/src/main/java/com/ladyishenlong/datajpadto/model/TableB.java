package com.ladyishenlong.datajpadto.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/11/21 6:01 下午
 */
@Data
@Entity
@Table(name = "table_b")
public class TableB implements Serializable {
    @Id
    private String name;
    private String card;
}
