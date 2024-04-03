package com.ideal.idealmaker.worldcup.service;

import com.ideal.idealmaker.worldcup.dto.WorldcupDto;
import java.util.List;

public interface WorldcupService {
    List<WorldcupDto> getRandomIdealsByGender(Integer genderId);
}
