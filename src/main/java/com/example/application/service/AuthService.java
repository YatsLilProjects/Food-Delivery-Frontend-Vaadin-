package com.example.application.service;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class AuthService {

    private AuthService() {
    }

    private static int userId = 0;

    public static void setUserId(int id) {
        userId = id;
    }

    public static int getUserId() {
        return userId;
    }

    public static boolean isAuthenticated() {
        return userId != 0;
    }

}



