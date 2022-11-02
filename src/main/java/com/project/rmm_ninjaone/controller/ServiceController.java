package com.project.rmm_ninjaone.controller;

import com.project.rmm_ninjaone.model.ServiceDTO;
import com.project.rmm_ninjaone.response.Response;
import com.project.rmm_ninjaone.service.ServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * @Autor Eric Quiroz Garcia
 * @Use Controller to do the Save and Delete of a Service.
 */
@RestController
@Slf4j
public class ServiceController {
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping(
            value = "/service/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveService(@RequestBody ServiceDTO service) {
        log.info("Controller Save Service: {}", service);
        return ResponseEntity.ok(
                Response.builder()
                        .datos(
                                this.serviceService.save(service))
                        .build());
    }

    @DeleteMapping(value = "/service/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteService(@PathVariable Long id){
        log.info("Controller Service delete: {}", id);
        this.serviceService.delete(id);
    }
}
