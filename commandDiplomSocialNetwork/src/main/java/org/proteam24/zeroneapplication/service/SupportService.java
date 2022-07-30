package org.proteam24.zeroneapplication.service;

import lombok.RequiredArgsConstructor;
import org.proteam24.zeroneapplication.repository.SupportRepository;
import org.proteam24.zeroneapplication.dto.SupportReadDto;
import org.proteam24.zeroneapplication.dto.SupportWriteDto;
import org.proteam24.zeroneapplication.mapper.SupportReadMapper;
import org.proteam24.zeroneapplication.mapper.SupportWriteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SupportService {

    private final SupportRepository supportRepository;
    private final SupportWriteMapper supportWriteMapper;
    private final SupportReadMapper supportReadMapper;

    @Transactional
    public SupportReadDto create(SupportWriteDto supportDto) {
        return Optional.of(supportDto)
                .map(supportWriteMapper::map)
                .map(supportRepository::save)
                .map(supportReadMapper::map)
                .orElseThrow();
    }
}
