package com.example.wantedpreonboardingbackend.web;

import com.example.wantedpreonboardingbackend.service.applyservice.ApplyService;
import com.example.wantedpreonboardingbackend.web.dto.ApplyRequestDto;
import com.example.wantedpreonboardingbackend.web.message.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class ApplyApiController {

    private final ApplyService applyService;

    @PostMapping("/apply")
    public ResponseEntity<?> apply(@RequestBody ApplyRequestDto requestDto) {
        Result<?> result = applyService.apply(requestDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
