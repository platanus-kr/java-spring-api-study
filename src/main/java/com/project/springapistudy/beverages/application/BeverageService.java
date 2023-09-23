package com.project.springapistudy.beverages.application;

import com.project.springapistudy.beverages.application.dto.BeverageCreateRequest;
import com.project.springapistudy.beverages.application.dto.BeverageRetrieveResponse;
import com.project.springapistudy.beverages.application.dto.BeverageUpdateRequest;
import com.project.springapistudy.beverages.commons.constants.BeverageMessages;
import com.project.springapistudy.beverages.domain.Beverage;
import com.project.springapistudy.beverages.domain.BeverageRepository;
import com.project.springapistudy.beverages.exception.BeverageNotFountException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BeverageService {

    private final BeverageRepository beverageRepository;

    @Transactional
    public void create(BeverageCreateRequest request) {
        beverageRepository.save(request.to());
    }

    public BeverageRetrieveResponse retrieve(long id) {
        Beverage findItem = beverageRepository.findById(id)
                .orElseThrow(() -> new BeverageNotFountException(BeverageMessages.BEVERAGE_NOT_FOUND));

        return BeverageRetrieveResponse.of(findItem);
    }

    public List<BeverageRetrieveResponse> retrieveAll() {
        List<Beverage> findAll = beverageRepository.findByDeletedFalseOrderByUpdatedDesc();

        return findAll.stream()
                .map(BeverageRetrieveResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public void update(long id, BeverageUpdateRequest request) {
        Beverage findItem = beverageRepository.findById(id)
                .orElseThrow(() -> new BeverageNotFountException(BeverageMessages.BEVERAGE_NOT_FOUND));

        Beverage requestItem = request.to();
        findItem.update(requestItem);
    }

    @Transactional
    public void delete(long id) {
        Beverage findItem = beverageRepository.findById(id)
                .orElseThrow(() -> new BeverageNotFountException(BeverageMessages.BEVERAGE_NOT_FOUND));
        findItem.delete();
    }
}
