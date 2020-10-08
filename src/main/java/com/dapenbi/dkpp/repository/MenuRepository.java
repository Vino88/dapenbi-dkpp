package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.Menu;
import com.dapenbi.dkpp.model.Role;

import java.util.List;

public interface MenuRepository extends BaseRepository<Menu, Integer> {

    List<Menu> findByRolesAndIsActiveIsTrue(Role role);

    List<Menu> findByRoles_codeAndSidebarIsTrueAndIsActiveIsTrueOrderByParentAscMenuOrderAsc(String roleName);

    List<Menu> findByRoles_codeAndPathStartsWithAndIsActiveIsTrueOrderByParentAscMenuOrderAsc(String roleName, String path);
}
