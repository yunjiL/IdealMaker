package com.ideal.idealmaker.worldcup.service.impl;

import com.ideal.idealmaker.worldcup.dto.WorldcupDTO;
import com.ideal.idealmaker.worldcup.repository.WorldcupRepository;
import com.ideal.idealmaker.worldcup.service.WorldcupService;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorldcupServiceImpl implements WorldcupService {

    private final WorldcupRepository worldcupRepository;

    public WorldcupServiceImpl(WorldcupRepository worldcupRepository) {
        this.worldcupRepository = worldcupRepository;
    }

    @Override
    public List<WorldcupDTO> getRandomIdealsByGender(Integer genderId) {
        // 모든 후보를 조회
        List<WorldcupDTO> allIdeals = worldcupRepository.findAll().stream()
                .filter(ideal -> ideal.getIdealCharacter().getGender().getId().equals(genderId))
                .map(ideal -> WorldcupDTO.builder()
                        .idealId(ideal.getId())
                        .idealURL(ideal.getIdealURL())
                        .animalType(ideal.getAnimalType().getType())
                        .genderId(genderId)
                        .build())
                .collect(Collectors.toList());

        // 리스트를 랜덤하게 섞음
        Collections.shuffle(allIdeals);

        // 상위 16개만 선택
        return allIdeals.stream().limit(16).collect(Collectors.toList());
    }
}
