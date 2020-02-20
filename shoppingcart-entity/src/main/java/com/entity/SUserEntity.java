package com.entity;

/**
 * @author SherWin
 * @date 2019/12/2 11:12
 */
public class SUserEntity {
    private String username;
    private String passsword;

    public SUserEntity() {
    }

    public SUserEntity(String username, String passsword) {
        this.username = username;
        this.passsword = passsword;
    }

    @Override
    public String toString() {
        return "SUserEntity{" +
                "username='" + username + '\'' +
                ", passsword='" + passsword + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }
}
