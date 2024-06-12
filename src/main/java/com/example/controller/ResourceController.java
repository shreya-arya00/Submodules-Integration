package com.example.controller;

import com.example.model.Resource;
import com.example.service.ResourceService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class ResourceController {
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }



    @GetMapping("/validate/{resourceId}")
    public Mono<Boolean> validateResource(@PathVariable String resourceId) {
        return resourceService.validateResourceExists(resourceId);
    }

    @GetMapping("/resource/{resourceId}")
    public Mono<Resource> getResource(@PathVariable String resourceId) {
        return resourceService.retrieveResource(resourceId);
    }

    @PutMapping("/resource/{resourceId}")
    public Mono<Void> updateResource(@PathVariable String resourceId, @RequestBody Resource resource) {
        return resourceService.updateResource(resourceId, resource);
    }

    @DeleteMapping("/resource/{resourceId}")
    public Mono<Void> deleteResource(@PathVariable String resourceId) {
        return resourceService.deleteResource(resourceId);
    }
}
