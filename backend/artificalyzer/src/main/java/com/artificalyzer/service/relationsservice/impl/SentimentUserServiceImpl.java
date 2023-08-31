package com.artificalyzer.service.relationsservice.impl;

import com.artificalyzer.helperfunction.HelperFunction;
import com.artificalyzer.models.aimodels.relations.SentimentAnalysisUsers;
import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.repository.aimodelsrepository.SentimentAnalysisRepository;
import com.artificalyzer.repository.relationsrepository.ModerationUserRepository;
import com.artificalyzer.repository.relationsrepository.SentimentAnalysisUsersRepository;
import com.artificalyzer.repository.userrolerepository.UserRepository;
import com.artificalyzer.service.relationsservice.interfaces.SentimentUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SentimentUserServiceImpl implements SentimentUserService {
    private final SentimentAnalysisUsersRepository sentimentAnalysisUsersRepository;
    private final UserRepository userRepository;
    @Override
    public Page<SentimentAnalysisUsers> findAllbyUser(String authHeader, Integer pageNo, Integer pageSize,  String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        String email = HelperFunction.decodeJwtToGetEmail(authHeader);
        User user = this.userRepository.findByEmail(email);
        return this.sentimentAnalysisUsersRepository.findAllByUser(paging, user);
    }
}
