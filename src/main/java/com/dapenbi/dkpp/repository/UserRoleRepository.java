package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.UserRole;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleRepository extends BaseRepository<UserRole,Long> {

    @Query(
            value = "select * from TBL_R_USER_ROLE WHERE ID_USER = ?1 and ID_ROLE = ?2",
            nativeQuery = true
    )
    UserRole findByKeduaId(Long idUser,Long idRole);

    @Query(
            value = "UPDATE tbl_r_user_role SET id_user = ?1, id_role = ?2 where tbl_r_user_role.id_user = ?3 and tbl_r_user_role.id_role = ?4",
            nativeQuery = true
    )
    void updateData (Long idUser,Long idRole,Long idUserUpdate, Long idRoleUpdate);

}
