package com.example.client;

import com.example.model.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ResourceClient {
    private final WebClient webClient;

    public ResourceClient(@Value("${dependency.service.url}") String serviceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(serviceUrl)
                .build();
    }

    public Mono<Boolean> validateResourceExists(String resourceId) {
        return webClient.get()
                .uri("/resources/{id}/exists", resourceId)
                .retrieve()
                .bodyToMono(Boolean.class);
    }

    public Mono<Resource> retrieveResource(String resourceId) {
        return webClient.get()
                .uri("/resources/{id}", resourceId)
                .retrieve()
                .bodyToMono(Resource.class);
    }

    public Mono<Void> updateResource(String resourceId, Resource resource) {
        return webClient.put()
                .uri("/resources/{id}", resourceId)
                .bodyValue(resource)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<Void> deleteResource(String resourceId) {
        return webClient.delete()
                .uri("/resources/{id}", resourceId)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
