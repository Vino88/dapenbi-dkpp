package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.MenuDto;
import com.dapenbi.dkpp.model.Menu;
import com.dapenbi.dkpp.model.Role;

import java.util.List;

public interface MenuDao extends BaseDao<Menu, MenuDto, Long> {

    List<Menu> findByRole(Role role);

    List<Menu> findByRoleCode(String roleName);

    List<Menu> findByRoleCodeAndPathStart(String roleName, String path);
}
