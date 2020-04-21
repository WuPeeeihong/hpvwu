package com.springboot.hpvwu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.hpvwu.entity.VoteTopic;
import com.springboot.hpvwu.mapper.VoteTopicMapper;
import com.springboot.hpvwu.service.IVoteTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VoteTopicServiceImpl extends ServiceImpl<VoteTopicMapper, VoteTopic> implements IVoteTopicService {

    @Autowired
    private VoteTopicMapper voteTopicMapper;







}
