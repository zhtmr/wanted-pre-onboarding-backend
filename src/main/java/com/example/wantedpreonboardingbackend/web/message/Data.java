package com.example.wantedpreonboardingbackend.web.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Data<T> {
    private T data;
}
