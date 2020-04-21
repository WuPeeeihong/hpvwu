package com.springboot.hpvwu.controller;

import com.springboot.hpvwu.service.ISysUserService;
import com.springboot.hpvwu.service.IVoteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private IVoteInfoService voteInfoService;



}
