package com.nwu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nwu.entity.ApplyType;
import com.nwu.entity.Role;

public interface testService extends IService<Role> {
     Role getroleById(String id);
}
