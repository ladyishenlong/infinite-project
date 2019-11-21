package com.ladyishenlong.oauth2authservice.serive;

import com.ladyishenlong.oauth2authservice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ruanchenhao
 * @Date 2019/11/13 10:02 上午
 */
public interface UserRepository extends JpaRepository<UserModel,String> {

}
