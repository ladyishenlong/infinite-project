package com.ladyishenlong.apiopenservice.utils;

import com.ladyishenlong.apiopenservice.model.ApiopenModel;
import org.springframework.http.HttpStatus;
import com.ladyishenlong.responseutils.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author ruanchenhao
 * @Date 2019/10/10 9:57 上午
 */
public class ApiOpenResponseUtils {

    public static <T> ResponseUtils entityAnalysis(HttpServletResponse response,
                                                     ResponseEntity<ApiopenModel> entity) {
        if (entity.getStatusCode() == HttpStatus.OK) {
            ApiopenModel<T> apiopenModel = entity.getBody();
            if (apiopenModel == null) return ResponseUtils.failure("返回的body为空");
            else if (apiopenModel.getCode() == 200)
                return ResponseUtils.success(apiopenModel.getResult());
            else return ResponseUtils.failure(apiopenModel.getMessage());
        } else {
            response.setStatus(entity.getStatusCodeValue());
            return ResponseUtils.failure(entity.getStatusCodeValue());
        }
    }

    public static <T> ResponseUtils entityAnalysis(ResponseEntity<ApiopenModel> entity) {
        if (entity.getStatusCode() == HttpStatus.OK) {
            ApiopenModel<T> apiopenModel = entity.getBody();
            if (apiopenModel == null) return ResponseUtils.failure("返回的body为空");
            else if (apiopenModel.getCode() == 200) return ResponseUtils.success(apiopenModel.getResult());
            else return ResponseUtils.failure(apiopenModel.getMessage());
        } else {
            return ResponseUtils.failure(entity.getStatusCodeValue());
        }
    }

}
