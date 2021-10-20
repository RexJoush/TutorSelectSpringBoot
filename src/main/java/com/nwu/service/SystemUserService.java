package com.nwu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nwu.entities.SystemUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nwu.vo.UserQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dynamic
 * @since 2021-08-10
 */
public interface SystemUserService extends IService<SystemUser> {

    int addSystemUser(String username);

    Page<SystemUser> getAll(UserQuery query);
}
