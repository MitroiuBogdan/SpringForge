package com.springforge.springforge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class DummyController {

    @GetMapping("/dummy-response")
    public CompletableFuture<DummyResponse> getDummyResponse() {
        return CompletableFuture.supplyAsync(() -> {
                    System.out.println("getDummyResponse");
                    return new DummyResponse("Success", 200, "Spring-Forge is optimized!");
                }
        );
    }

    public record DummyResponse(String status, int code, String message) {
    }
}
