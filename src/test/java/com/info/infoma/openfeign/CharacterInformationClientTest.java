package com.info.infoma.openfeign;

import com.info.infoma.domain.dto.UserOcid;
import com.info.infoma.domain.dto.character.CharacterItemEquipment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

// @SpringBootTest(classes = InfomaApplication.class)
@DisplayName("Client 단 조회 테스트")
class CharacterInformationClientTest {

    @Autowired
    CharacterInformationClient characterInformationClient;

    @DisplayName("ocid 조회")
    @Test
    void getOcid() throws Exception {
        // Arrange
        String ocid = null;
        String characterName = "11살";

        // Act
        UserOcid uo = characterInformationClient.getUserOcid(characterName);
        ocid = uo.ocid();

        // Assert
        assertEquals("3cb0134ca18a18657c04facc3e552e98efe8d04e6d233bd35cf2fabdeb93fb0d"
        , ocid);
    }

    @DisplayName("장착 장비 정보 조회")
    @Test
    void getItemEquipment() throws Exception {
        // Arrange
        String ocid = "3cb0134ca18a18657c04facc3e552e98efe8d04e6d233bd35cf2fabdeb93fb0d";
        // Act
        CharacterItemEquipment characterItemEquipment = characterInformationClient.getCharacterItemEquipment(ocid);
        System.out.println(characterItemEquipment.characterClass());

        // Assert
        assertEquals("메르세데스", characterItemEquipment.characterClass());
    }

}