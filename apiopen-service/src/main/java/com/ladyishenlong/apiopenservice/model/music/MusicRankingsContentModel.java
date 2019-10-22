package com.ladyishenlong.apiopenservice.model.music;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/10/18 9:14 上午
 */
@Data
public class MusicRankingsContentModel implements Serializable {
    private String all_rate;
    private String song_id;
    private String rank_change;
    private String biaoshi;
    private String author;
    private String album_id;
    private String pic_small;
    private String title;
    private String pic_big;
    private String album_title;
}
