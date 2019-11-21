package com.ladyishenlong.datajpadto.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/11/21 6:45 下午
 *
 *
 * todo 如同该类所示，先查出主表需要部分，再查出从表，最后读数据进行处理即可
 */
@Data
public class CusDto implements Serializable {

    private String name;

    public CusDto() {
    }

    public CusDto(String name) {
        super();
        this.name = name;
    }

}
