package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.RoleDao;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.model.Role;
import com.dapenbi.dkpp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleDaoImpl extends BaseDaoImpl<Role, RoleDto, Long> implements RoleDao {

    private RoleRepository roleRepository;

    @Autowired
    public RoleDaoImpl(RoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findOneByCode(String code) {
        return roleRepository.findOneByCodeAndIsActiveIsTrue(code);
    }
}
