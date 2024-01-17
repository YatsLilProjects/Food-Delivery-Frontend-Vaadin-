package com.example.application.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private boolean success;
    private List<String> errMessage = new ArrayList<>();
    private T responseData;
}
