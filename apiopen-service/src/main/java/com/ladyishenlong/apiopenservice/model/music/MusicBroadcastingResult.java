package com.ladyishenlong.apiopenservice.model.music;

import com.ladyishenlong.apiopenservice.model.BaseApiopenModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/18 2:24 下午
 */
@Data
public class MusicBroadcastingResult extends BaseApiopenModel implements Serializable {

    private List<MusicBroadcastingModel> result;

}
