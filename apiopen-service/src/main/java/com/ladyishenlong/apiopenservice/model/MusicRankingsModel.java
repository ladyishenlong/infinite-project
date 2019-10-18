package com.ladyishenlong.apiopenservice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/18 9:09 上午
 */
@Data
public class MusicRankingsModel implements Serializable {

    private String pic_s210;
    private String bg_pic;
    private String color;
    private String pic_s444;
    private String count;
    private String type;
    private List<MusicRankingsContentModel> content;
    private String bg_color;
    private String web_url;
    private String name;
    private String comment;
    private String pic_s192;
    private String pic_s260;

}
