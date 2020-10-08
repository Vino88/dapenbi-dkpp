package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.Role;

public interface RoleRepository extends BaseRepository<Role, Integer> {

    Role findOneByCodeAndIsActiveIsTrue(String code);
}
