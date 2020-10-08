package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.UserRoleDao;
import com.dapenbi.dkpp.dto.UserRoleDto;
import com.dapenbi.dkpp.model.UserRole;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole, UserRoleDto, Long> implements UserRoleDao {

    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleDaoImpl(UserRoleRepository userRoleRepository) {
        super(userRoleRepository);
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole findByKeduaId(Long idUser, Long idRole) {
        return userRoleRepository.findByKeduaId(idUser,idRole);
    }

    @Override
    public Boolean updateData(Long idUser, Long idRole, Long idUserUpdate, Long idRoleUpdate) {
        try {
            userRoleRepository.updateData(idUser, idRole, idUserUpdate,idRoleUpdate);
            return true;

        }catch (Exception ex){
            return false;
        }
    }
}
