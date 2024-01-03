package org.example;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "abcdefgh"; // 8글자 올바르게 고정된 패스워드
    }
}
