package com.ladyishenlong.oauth2authservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/11/13 9:49 上午
 */
@Entity
@Data
public class UserModel implements Serializable {
    @Id
    private String username;
    private String password;
}
