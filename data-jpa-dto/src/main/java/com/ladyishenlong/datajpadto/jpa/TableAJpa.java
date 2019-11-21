package com.ladyishenlong.datajpadto.jpa;

import com.ladyishenlong.datajpadto.model.CusDto;
import com.ladyishenlong.datajpadto.model.TableAVo;
import com.ladyishenlong.datajpadto.model.table.TableA;
import com.ladyishenlong.datajpadto.model.TableADto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/11/21 6:00 下午
 */
public interface TableAJpa extends JpaRepository<TableA, Integer> {

    // 原生语句是个大坑！！！，还是使用jpa的sql来查询
    //todo 不能使用原生sql来查询，名字必须与投影对应
    @Query(value = "select a.name as name," +
            " a.password as password ," +
            " a.tableB as tableB " +
            "from TableA a where id=1 and " +
            " (1=(case when :password is null then 1 else 0 end )" +
            " or a.password = :password )"
//            "case when :password is null then a.password = '666' end"
    )
    Page<TableADto> find2(Pageable pageable, @Param("password") String password);


    /**
     * 这么查询完全ko，就sql语句写的有问题
     */
    List<TableADto> findAllByPassword(String password);


    //一号解决方案
//    @Query(value = "select new com.ladyishenlong.datajpadto.model.CusDto(name) " +
//            " from TableA ")
//    Page<CusDto> findTheOne(Pageable pageable);


}
