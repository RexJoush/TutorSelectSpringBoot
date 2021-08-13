package com.nwu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nwu.entities.Role;

public interface testService extends IService<Role> {
     Role getRoleById(String id);
}
