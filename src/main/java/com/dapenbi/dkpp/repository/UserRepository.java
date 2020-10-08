package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.User;

public interface UserRepository extends BaseRepository<User, Long> {

    User findOneByEmail(String email);

    User findOneByUsername(String username);

    User findOneByConfirmationKey(String confirmationKey);
}