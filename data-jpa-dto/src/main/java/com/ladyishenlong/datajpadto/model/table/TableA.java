package com.ladyishenlong.datajpadto.model.table;

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
    private String name;
    private String password;


    //TODO 全部查询的问题和更新的问题解决
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    //本个key 和 另外一张表key
    @JoinColumn(name = "name",referencedColumnName = "name",
            insertable = false,updatable = false)
    private TableB tableB;


}
