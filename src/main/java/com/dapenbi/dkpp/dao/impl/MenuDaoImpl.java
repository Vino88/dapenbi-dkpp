package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.MenuDao;
import com.dapenbi.dkpp.dto.MenuDto;
import com.dapenbi.dkpp.model.Menu;
import com.dapenbi.dkpp.model.Role;
import com.dapenbi.dkpp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuDaoImpl extends BaseDaoImpl<Menu, MenuDto, Long> implements MenuDao {

    private MenuRepository menuRepository;

    @Autowired
    public MenuDaoImpl(MenuRepository menuRepository) {
        super(menuRepository);
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> findByRole(Role role) {
        return menuRepository.findByRolesAndIsActiveIsTrue(role);
    }

    @Override
    public List<Menu> findByRoleCode(String roleCode) {
        return menuRepository.findByRoles_codeAndSidebarIsTrueAndIsActiveIsTrueOrderByParentAscMenuOrderAsc(roleCode);
    }

    @Override
    public List<Menu> findByRoleCodeAndPathStart(String roleName, String path) {
        return menuRepository.findByRoles_codeAndPathStartsWithAndIsActiveIsTrueOrderByParentAscMenuOrderAsc(roleName, path);
    }
}
