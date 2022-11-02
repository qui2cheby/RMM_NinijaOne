package com.project.rmm_ninjaone.controller;

import com.project.rmm_ninjaone.model.Ledger;
import com.project.rmm_ninjaone.response.Response;
import com.project.rmm_ninjaone.service.LedgerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;

/***
 * @Autor Eric Quiroz Garcia
 * @Use Controller to do the Save of a transaction and
 * have the capacity to calculate By Service and Month in a Year.
 */
@RestController
@Slf4j
public class LedgerController {
    private final LedgerService ledgerService;

    public LedgerController(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    /**
     * Save the movement Add of service.
     * @param ledger
     * @return
     */
    @PostMapping(
            value = "/ledger/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody Ledger ledger) {
        log.info("Save ledger: {}", ledger);
        return ResponseEntity.ok(
                Response.builder()
                        .datos(
                                this.ledgerService.save(ledger))
                        .build());
    }

    /**
     * Method to calculate the total of month by Service.
     * @param ledger
     * @return
     */
    @PostMapping(
            value = "/ledger/totalMonthly/byService",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getTotalMonthByService(@RequestBody Ledger ledger) {
        log.debug("LedgerController.getTotalMonthByService: {}", ledger);
        return ResponseEntity.ok(
                Response.builder()
                        .datos(
                                this.ledgerService.getTotalMonthlyByService(ledger))
                        .build());
    }

    /**
     * Method to calculate the total price by all months in a year.
     * @param ledger
     * @return
     */
    @PostMapping(
            value = "/ledger/totalPrice/byMonth",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getTotalPriceByService(@RequestBody Ledger ledger) {
        log.debug("LedgerController.getTotalPriceByService: {}", ledger);
        try {
        return ResponseEntity.ok(
                Response.builder()
                        .datos(
                                this.ledgerService.getTotalPriceByMonth(ledger))
                        .build());
        } catch (ParseException e) {
            log.error("ERROR: ", e);
            return ResponseEntity.badRequest()
                    .body(
                            Response.builder()
                                    .codigo(HttpStatus.BAD_REQUEST.value())
                                    .mensaje(e.getMessage())
                                    .build());
        }
    }
}
