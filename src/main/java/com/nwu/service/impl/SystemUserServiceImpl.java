package com.nwu.service.impl;

import com.nwu.entity.SystemUser;
import com.nwu.mapper.SystemUserMapper;
import com.nwu.service.SystemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dynamic
 * @since 2021-08-10
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements SystemUserService {

}
