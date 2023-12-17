package com.amigoscode.testing.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneNumberValidatorTest {

    private PhoneNumberValidator phoneNumberValidator;

    @BeforeEach
    void setUp() {
        phoneNumberValidator = new PhoneNumberValidator();
    }


    @ParameterizedTest
    @CsvSource(
            value = {
                    "+447000000000, true",
                    "+447000000000999, false",
                    "4470000000000, false"
            }

    )
    @DisplayName("Should validate when phone number")
    void itShouldValidatePhoneNumberParamTest(String phoneNumber, boolean expected) {

        // When
        boolean isValid =  phoneNumberValidator.test(phoneNumber);

        // Then
        assertThat(isValid).isEqualTo(expected);
    }

}
