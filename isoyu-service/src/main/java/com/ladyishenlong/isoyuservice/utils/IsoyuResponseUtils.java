package com.ladyishenlong.isoyuservice.utils;

import com.ladyishenlong.isoyuservice.model.IsoyuModel;
import com.ladyishenlong.responseutils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author ruanchenhao
 * @Date 2019/10/10 1:26 下午
 */
@Slf4j
public class IsoyuResponseUtils {

    public static <T>ResponseUtils entityAnalysis(ResponseEntity<IsoyuModel> entity) {
        if(entity.getStatusCode()== HttpStatus.OK){
            IsoyuModel<T> isoyuModel=entity.getBody();
            if(isoyuModel==null)return ResponseUtils.failure("返回的信息为空");
            else if(isoyuModel.getCode()==1)return ResponseUtils.success(isoyuModel.getData());
            else return ResponseUtils.failure(isoyuModel.getMessage());
        }else{
            return ResponseUtils.failure(entity.getStatusCodeValue());
        }
    }
}
