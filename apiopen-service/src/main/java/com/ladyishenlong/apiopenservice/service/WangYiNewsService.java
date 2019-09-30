package com.ladyishenlong.apiopenservice.service;

import com.ladyishenlong.apiopenservice.model.WangYiNewsModel;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/9/30 10:16 上午
 */
@Service
public interface WangYiNewsService {

   List<WangYiNewsModel> getWangYiNews(String page,String count);

}
