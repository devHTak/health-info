package com.example.kbhc.framework.input.file;

import com.example.kbhc.framework.dto.HealthResource;
import com.example.kbhc.usecase.dto.HealthDto;
import com.example.kbhc.usecase.port.HealthUsecase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HealthFileAdapter {

    @Value("${input.file-names}")
    private String inputFileNames;
    private final Logger log = LoggerFactory.getLogger(HealthFileAdapter.class);

    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;
    private final HealthUsecase healthUsecase;

    private HealthFileAdapter(ResourceLoader resourceLoader, ObjectMapper objectMapper, HealthUsecase healthUsecase) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
        this.healthUsecase = healthUsecase;
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            String[] fileNames = inputFileNames.split(",");
            List<HealthDto> healths = Arrays.stream(fileNames)
                    .map(fileName -> this.readFile(fileName))
                    .collect(Collectors.toList());

            healthUsecase.saveAll(healths);
        };
    }

    public HealthDto readFile(String fileName) {
        String filePath = "classPath:static/" + fileName; // resources/static 하위 파일
        Resource resource = resourceLoader.getResource(filePath);

        try(InputStream inputStream = resource.getInputStream()) {
            String inputResource = FileCopyUtils.copyToString(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            HealthResource healthResource = objectMapper.readValue(inputResource, HealthResource.class);
            return healthResource.convertToDto();
        } catch (Exception e) {
            log.error("Convert To Health exception: {}", e.getMessage());
        }

        throw new IllegalArgumentException("Convert To Health exception");
    }

}
