package br.com.lestcode.startwars.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RebelController {

    @PostMapping("rebel")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRebel(@Valid @RequestBody Map<String, String> body) {

    }

    @PutMapping("rebel")
    public void updateRebel(@Valid @RequestBody Map<String, String> body) {

    }

    @PatchMapping("rebel")
    public void reportRebelAsTraitor(@Valid @RequestBody String name) {

    }
}
