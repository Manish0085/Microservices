package com.eazybytes.cards.dto;

import org.apache.catalina.LifecycleState;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "cards")
public record CardsContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}
