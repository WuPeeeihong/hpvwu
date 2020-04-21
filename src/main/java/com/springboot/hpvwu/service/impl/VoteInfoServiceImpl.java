package com.springboot.hpvwu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.hpvwu.entity.VoteInfo;
import com.springboot.hpvwu.mapper.VoteInfoMapper;
import com.springboot.hpvwu.service.IVoteInfoService;
import org.springframework.stereotype.Service;

@Service
public class VoteInfoServiceImpl extends ServiceImpl<VoteInfoMapper, VoteInfo> implements IVoteInfoService {


}
