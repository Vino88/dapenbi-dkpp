package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.UserRoleDto;
import com.dapenbi.dkpp.model.UserRole;

public interface UserRoleDao extends BaseDao<UserRole, UserRoleDto, Long> {

    UserRole findByKeduaId(Long idUser,Long idRole);

    Boolean updateData (Long idUser,Long idRole,Long idUserUpdate, Long idRoleUpdate);
}
