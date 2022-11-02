package com.project.rmm_ninjaone.controller;

import com.project.rmm_ninjaone.model.Device;
import com.project.rmm_ninjaone.response.Response;
import com.project.rmm_ninjaone.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * @Autor Eric Quiroz Garcia
 * @Use RestController to do the CRUD for the Device.
 */
@RestController
@Slf4j
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    /**
     * Save a Device
     * @param device
     * @return
     */
    @PostMapping(
            value = "/device/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveDevice(@RequestBody Device device) {
        log.info("Save device: {}", device);
        return ResponseEntity.ok(
                Response.builder()
                        .datos(
                            this.deviceService.saveDeviceEntity(device))
                        .build());
    }

    /**
     * Update a device.
     * @param device
     * @return
     */
    @PostMapping(
            value = "/device/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateDevice(@RequestBody Device device) {
        log.info("Controller updateDevice: {}", device);
        return ResponseEntity.ok(
                Response.builder()
                        .datos(
                                this.deviceService.updateDeviceEntity(device))
                        .build());
    }

    /**
     * Delete a Device.
     * @param id
     */
    @DeleteMapping(value = "/device/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteDevice(@PathVariable Long id){
        log.info("Controller delete: {}", id);
        deviceService.deleteDeviceEntity(id);
    }

    /**
     * Find a device by ID.
     * @param id
     * @return
     */
    @GetMapping(value = "/device/get/by/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> findById(@PathVariable Long id) {
        log.debug("Controller findById: {}", id);
        return ResponseEntity.ok(
                Response.builder()
                        .datos(deviceService.getDeviceEntity(id))
                        .build());
    }
}
