package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.model.Role;

public interface RoleDao extends BaseDao<Role, RoleDto, Long> {

    Role findOneByCode(String code);
}
