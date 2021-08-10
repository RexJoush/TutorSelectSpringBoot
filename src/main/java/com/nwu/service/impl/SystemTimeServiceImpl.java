package com.nwu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwu.entity.SystemTime;
import com.nwu.mapper.SystemTimeMapper;
import com.nwu.service.SystemTimeService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SystemTimeServiceImpl extends ServiceImpl<SystemTimeMapper, SystemTime> implements SystemTimeService {
}
