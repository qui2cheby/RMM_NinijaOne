package com.project.rmm_ninjaone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.rmm_ninjaone.RmmNinjaOneApplication;
import com.project.rmm_ninjaone.model.Device;
import com.project.rmm_ninjaone.service.DeviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RmmNinjaOneApplication.class})
@WebMvcTest(DeviceController.class)
@AutoConfigureMockMvc
@AutoConfigureDataJpa
public class DeviceControllerTest {
    public static final Long ID = 1L;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private DeviceService deviceService;

    private Device deviceEntity;

    @BeforeEach
    void setup(){
        deviceEntity = new Device(ID, "Windows 10", "Windows Server");
    }

    @Test
    void postDeviceData() throws Exception {
        when(deviceService.saveDeviceEntity(any())).thenReturn(deviceEntity);

        String deviceEntityString = objectMapper.writeValueAsString(deviceEntity);
        mockMvc.perform(post("/device/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(deviceEntityString))
                .andExpect(status().isCreated())
                .andExpect(content().string(deviceEntityString));
    }

    @Test
    void deleteSampleData() throws Exception {
        doNothing().when(deviceService).deleteDeviceEntity(ID);

        mockMvc.perform(delete("/device/delete/" + ID))
                .andExpect(status().isNoContent());
    }
}
