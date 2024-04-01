package com.ideal.idealmaker.worldcup.service;

import com.ideal.idealmaker.worldcup.dto.WorldcupDTO;
import java.util.List;

public interface WorldcupService {
    List<WorldcupDTO> getRandomIdealsByGender(Integer genderId);
}
