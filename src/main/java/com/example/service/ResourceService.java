package com.example.service;

import com.example.client.ResourceClient;
import com.example.model.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ResourceService {
    private final ResourceClient resourceClient;

    public ResourceService(ResourceClient resourceClient) {
        this.resourceClient = resourceClient;
    }

    public Mono<Boolean> validateResourceExists(String resourceId) {
        return resourceClient.validateResourceExists(resourceId);
    }

    public Mono<Resource> retrieveResource(String resourceId) {
        return resourceClient.retrieveResource(resourceId);
    }

    public Mono<Void> updateResource(String resourceId, Resource resource) {
        return resourceClient.updateResource(resourceId, resource);
    }

    public Mono<Void> deleteResource(String resourceId) {
        return resourceClient.deleteResource(resourceId);
    }
}
