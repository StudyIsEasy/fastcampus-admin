package com.fastcampus.admin.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminAuditorAware implements AuditorAware<String> {

    @Value("${spring.application.name}")
    private String serverName;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(serverName);
    }
}
