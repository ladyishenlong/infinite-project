package com.ladyishenlong.apiopenservice.model.music;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/10/18 1:43 下午
 */
@Data
public class MusicBroadcastingChannelListModel implements Serializable {
    private String thumb;
    private String name;
    private String cate_name;
    private String cate_sname;
    private String ch_name;
    private String channelid;

    private String artistid;
    private String avatar;

}
