package com.ladyishenlong.datajpadto.jpa;

import com.ladyishenlong.datajpadto.model.TableB;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ruanchenhao
 * @Date 2019/11/21 6:02 下午
 */
public interface TableBJpa extends JpaRepository<TableB,String> {
}
