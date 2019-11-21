package com.ladyishenlong.datajpadto.jpa;

import com.ladyishenlong.datajpadto.model.TableA;
import com.ladyishenlong.datajpadto.model.TableADto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/11/21 6:00 下午
 */
public interface TableAJpa extends JpaRepository<TableA ,Integer> {

    @Query(nativeQuery = true,
    value = "select table_a.name from table_a")
    List<TableADto> find();

}
