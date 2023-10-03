package com.example.wantedpreonboardingbackend.web.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Result<T> {


    private String message = "success";

    @JsonProperty("result")
    private Data<T> resultData;


    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Result(T contents) {
        this.resultData = new Data<>(contents);
    }

}
