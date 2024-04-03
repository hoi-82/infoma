package com.info.infoma.service;

import com.info.infoma.InfomaApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = InfomaApplication.class)
@Transactional
class BasicInformationServiceTest {

    @Autowired
    CharacterInformationService basicInformationService;

}