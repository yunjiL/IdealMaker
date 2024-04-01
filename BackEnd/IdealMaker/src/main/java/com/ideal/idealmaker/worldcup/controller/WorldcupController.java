package com.ideal.idealmaker.worldcup.controller;

import com.ideal.idealmaker.worldcup.dto.WorldcupDTO;
import com.ideal.idealmaker.worldcup.service.WorldcupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/worldcup")
@RequiredArgsConstructor
public class WorldcupController {

    private final WorldcupService worldcupService;

    @GetMapping("/gender")
    public List<WorldcupDTO> getRandomIdeals(@RequestParam Integer genderId) {
        return worldcupService.getRandomIdealsByGender(genderId);
    }
}
