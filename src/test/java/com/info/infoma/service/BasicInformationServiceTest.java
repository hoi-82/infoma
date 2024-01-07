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
    BasicInformationService basicInformationService;

    @Test
    @DisplayName("ocid 조회 테스트")
    void getOcidTest() throws Exception {
        // Arrange
        Object actual = "";

        // Act
        actual = basicInformationService.getCharacterInformation("11살");

        // Assert
        Assertions.assertEquals("3cb0134ca18a18657c04facc3e552e98efe8d04e6d233bd35cf2fabdeb93fb0d"
        , actual);
    }
}