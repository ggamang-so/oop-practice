package org.example;

import lombok.Getter;


public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String password = passwordGenerator.generatePassword();

        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }


    public String getPassword() {

        return this.password;
    }
}
