package com.updown.api.account.infrastructure.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.updown.api.account.infrastructure.dto.AccountEntityQueryDSLDTO;
import com.updown.api.account.infrastructure.dto.QAccountEntityQueryDSLDTO;
import com.updown.api.account.presentation.dto.request.AccountsFindRequestDTO;

import javax.persistence.EntityManager;
import java.util.List;

import static com.updown.api.account.domain.QAccount.account;


public class AccountEntityQueryDSLRepositoryImpl implements AccountEntityQueryDSLRepository{

    private final JPAQueryFactory queryFactory;

    public AccountEntityQueryDSLRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<AccountEntityQueryDSLDTO> findAccounts(AccountsFindRequestDTO accountsFindRequestDTO) {
        return queryFactory.select(new QAccountEntityQueryDSLDTO(
                account.loginId,
                account.accountName)
        ).from(account)
        .fetch();
    }
}
