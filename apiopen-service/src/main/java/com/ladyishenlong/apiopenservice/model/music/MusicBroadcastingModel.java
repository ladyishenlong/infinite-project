package com.ladyishenlong.apiopenservice.model.music;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/18 1:39 下午
 */
@Data
public class MusicBroadcastingModel implements Serializable {

    private List<MusicBroadcastingChannelListModel> channellist;

    private String cid;
    private String title;
}
