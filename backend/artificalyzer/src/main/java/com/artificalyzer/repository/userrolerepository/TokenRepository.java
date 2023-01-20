package com.artificalyzer.repository.userrolerepository;

import com.artificalyzer.models.userroles.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query("select t from Token t where t.token=:token")
    Token findByToken(String token);

    @Modifying
    @Transactional
    @Query("delete from Token t where t.token=:token")
    void deleteByToken(String token);
}