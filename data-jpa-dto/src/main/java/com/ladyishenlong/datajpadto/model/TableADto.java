package com.ladyishenlong.datajpadto.model;

import com.ladyishenlong.datajpadto.model.table.TableB;

/**
 * @Author ruanchenhao
 * @Date 2019/11/21 6:08 下午
 */
public interface TableADto {

    String getName();

    String getPassword();


    TableBDto getTableB();


}
