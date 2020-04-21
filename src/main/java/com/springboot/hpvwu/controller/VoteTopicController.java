package com.springboot.hpvwu.controller;

import com.springboot.hpvwu.entity.VoteTopic;
import com.springboot.hpvwu.service.IVoteTopicService;
import com.springboot.hpvwu.vo.AjaxResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class VoteTopicController {

    @Autowired
    private IVoteTopicService voteTopicService;

    @Cacheable(key = "'Cache-VoteTopicList'", cacheNames = "List<VoteTopic>")
    @GetMapping(value = "/getVoteTopicList")
    public List<VoteTopic> getVoteTopicList(){
        return voteTopicService.list();
    }

    @PostMapping(value = "/test")
    @CacheEvict(key = "'Cache-VoteTopicList'", cacheNames = "List<VoteTopic>")
    public AjaxResult insertTest(){
        VoteTopic voteTopic = new VoteTopic();
        voteTopic.setTopicId(UUID.randomUUID().toString().replaceAll("-",""));
        voteTopic.setTopicTitle("测试投票111" );
        voteTopic.setTopicIntroduction("测试111" );
        voteTopic.setCreateTime(new Date());
        return voteTopicService.save(voteTopic) ? AjaxResult.success("新增成功") : AjaxResult.error("新增失败");

    }

    @CacheEvict(key = "'Cache-VoteTopicList'", cacheNames = "List<VoteTopic>")
    @PostMapping(value = "/insertVoteTopic")
    public AjaxResult insertVoteTopic(VoteTopic voteTopic){
        if (voteTopicService.save(voteTopic)){
            return AjaxResult.success("新增成功");
        }
        return AjaxResult.error("新增失败");
    }

    @CacheEvict(key = "'Cache-VoteTopicList'", cacheNames = "List<VoteTopic>")
    @PostMapping(value = "/deleteVoteTopic")
    public AjaxResult deleteVoteTopic(@RequestParam(value = "topicId", required = true) String topicId){
        if (!StringUtils.isNotBlank(topicId)){
            return AjaxResult.error("输入内容不应该为空");
        }
        if (voteTopicService.removeById(topicId)){
            return AjaxResult.success("删除成功");
        }
        return AjaxResult.error("删除失败");
    }

    @CacheEvict(key = "'Cache-VoteTopicList'", cacheNames = "List<VoteTopic>")
    @PostMapping(value = "/openVoteTopic")
    public AjaxResult openVoteTopic(@RequestParam(value = "topicId", required = true) String topicId){
        if (!StringUtils.isNotBlank(topicId)){
            return AjaxResult.error("输入内容不应该为空");
        }
        VoteTopic voteTopic = voteTopicService.getById(topicId);
        if (null == voteTopic){
            return AjaxResult.error("无此id的投票通道");
        }
        voteTopic.setTopicStatus(1);
        if (voteTopicService.updateById(voteTopic)){
            return AjaxResult.success("成功开启该通道投票");
        }
        return AjaxResult.error("通道开启失败");
    }

    @CacheEvict(key = "'Cache-VoteTopicList'", cacheNames = "List<VoteTopic>")
    @PostMapping(value = "/closeVoteTopic")
    public AjaxResult closeVoteTopic(@RequestParam(value = "topicId", required = true) String topicId){
        if (!StringUtils.isNotBlank(topicId)){
            return AjaxResult.error("输入内容不应该为空");
        }
        VoteTopic voteTopic = voteTopicService.getById(topicId);
        if (null == voteTopic){
            return AjaxResult.error("无此id的投票通道");
        }
        voteTopic.setTopicStatus(0);
        if (voteTopicService.updateById(voteTopic)){
            return AjaxResult.success("成功关闭该通道投票");
        }
        return AjaxResult.error("通道关闭失败");
    }

    @PostMapping(value = "/getVoteCountList")
    public List getVoteCountList(){
        // todo 根据 投票信息 进行投票排行榜展示
        List<VoteTopic> voteTopics = voteTopicService.list();
        return null;
    }


}
