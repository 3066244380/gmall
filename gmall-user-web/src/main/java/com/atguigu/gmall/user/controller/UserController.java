package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * ClassName :UserController
 * Package :com.atguigu.gmall.user.controller
 * Description :
 *
 * @author :张哈哈
 * @date :2020/4/14 10:50
 */
@Controller
public class UserController {

    @Reference
    UserService userService;

    //根据用户id获取用户的收获地址
    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses =  userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }


    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMemberList = userService.getAllUser();
        return umsMemberList;
    }


}
