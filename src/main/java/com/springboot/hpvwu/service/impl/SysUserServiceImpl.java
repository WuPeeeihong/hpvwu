package com.springboot.hpvwu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.hpvwu.entity.SysUser;
import com.springboot.hpvwu.mapper.SysUserMapper;
import com.springboot.hpvwu.service.ISysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
