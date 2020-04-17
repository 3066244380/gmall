package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * ClassName :UserService
 * Package :com.atguigu.gmall.user.service
 * Description :
 *
 * @author :张哈哈
 * @date :2020/4/14 10:52
 */
public interface UserService {

    List<UmsMember> getAllUser();

    /**
     * 根据用户id获取用户的收货地址
     * @return
     */
    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);

}
