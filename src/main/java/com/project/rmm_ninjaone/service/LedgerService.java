package com.project.rmm_ninjaone.service;

import com.project.rmm_ninjaone.database.LedgerRepository;
import com.project.rmm_ninjaone.model.Ledger;
import com.project.rmm_ninjaone.model.Period;
import com.project.rmm_ninjaone.model.ServiceDTO;
import com.project.rmm_ninjaone.model.TotalMonthly;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Class to inject the repository and do the logical functions.
 */
@Service
@Slf4j
public class LedgerService {
    private final LedgerRepository ledgerRepository;
    private final ServiceService serviceService;

    public LedgerService(LedgerRepository ledgerRepository, ServiceService serviceService) {
        this.ledgerRepository = ledgerRepository;
        this.serviceService = serviceService;
    }

    /**
     * Method to save the movement in ledger
     * @param ledger
     * @return
     */
    public Ledger save(Ledger ledger) {
        log.info("Save in LedgerService: {}", ledger);
        //Get the Id Service to get the Price.
        ServiceDTO serviceDTO = this.serviceService.findBy(ledger.getIdService()).orElse(null);
        ledger.setCreated(LocalDateTime.now());
        if (null != serviceDTO ) {
            ledger.setIdService(serviceDTO);
            ledger.setUnitPrice(serviceDTO.getPrice());
                ledger.setTotalPrice(ledger.getUnitPrice()
                    .multiply(new BigDecimal(ledger.getQuantity()))
                                );
        }
        return this.ledgerRepository.save(ledger);
    }

    /**
     * Method to get The total Price of month by Service.
     * @param ledger
     * @return
     */
    public List<TotalMonthly> getTotalMonthlyByService(Ledger ledger) {
        List<TotalMonthly> totalMonthlyList = new ArrayList<>();
        TotalMonthly totalMonthlyAux = new TotalMonthly();
        List<Ledger> ledgerList = this.ledgerRepository.getTotalBy(ledger.getYear());
        HashMap<String, TotalMonthly> map = new HashMap<>();
        for (Ledger l : ledgerList) {
            ServiceDTO service = this.serviceService.findBy(l.getIdService()).orElseThrow();
            if (map.containsKey(l.getIdService())) {
                totalMonthlyAux = map.get(l.getIdService());
                List<Period> periodsAux = totalMonthlyAux.getPeriods();
                setPeriods(periodsAux, l);
            } else { //Not exists, so is a new Object
                String serviceDescription = service.getServiceName();
                TotalMonthly totalMonthly = TotalMonthly.builder().name(serviceDescription).build();
                map.put(l.getIdService().getServiceName(), totalMonthly);
                List<Period> periods = new ArrayList<>();
                setNewPeriods(l, periods);
                totalMonthly.setPeriods(periods);
                totalMonthlyList.add(totalMonthly);
            }
        }
        return totalMonthlyList;
    }

    /**
     * Method to create the new Months
     * @param l
     * @param periods
     */
    private void setNewPeriods(Ledger l, List<Period> periods) {
        Period p1 = Period.builder().monthNumber(1).value(BigDecimal.valueOf(0)).build();
        Period p2 = Period.builder().monthNumber(2).value(BigDecimal.valueOf(0)).build();
        Period p3 = Period.builder().monthNumber(3).value(BigDecimal.valueOf(0)).build();
        Period p4 = Period.builder().monthNumber(4).value(BigDecimal.valueOf(0)).build();
        Period p5 = Period.builder().monthNumber(5).value(BigDecimal.valueOf(0)).build();
        Period p6 = Period.builder().monthNumber(6).value(BigDecimal.valueOf(0)).build();
        Period p7 = Period.builder().monthNumber(7).value(BigDecimal.valueOf(0)).build();
        Period p8 = Period.builder().monthNumber(8).value(BigDecimal.valueOf(0)).build();
        Period p9 = Period.builder().monthNumber(9).value(BigDecimal.valueOf(0)).build();
        Period p10 = Period.builder().monthNumber(10).value(BigDecimal.valueOf(0)).build();
        Period p11 = Period.builder().monthNumber(11).value(BigDecimal.valueOf(0)).build();
        Period p12 = Period.builder().monthNumber(12).value(BigDecimal.valueOf(0)).build();
        Month month = l.getCreated().getMonth();
        int numberMonth = month.getValue();
        switch (numberMonth) {
            case 1:
                p1.setValue(l.getTotalPrice());
                break;
            case 2:
                p2.setValue(l.getTotalPrice());
                break;
            case 3:
                p3.setValue(l.getTotalPrice());
                break;
            case 4:
                p4.setValue(l.getTotalPrice());
                break;
            case 5:
                p5.setValue(l.getTotalPrice());
                break;
            case 6:
                p6.setValue(l.getTotalPrice());
                break;
            case 7:
                p7.setValue(l.getTotalPrice());
                break;
            case 8:
                p8.setValue(l.getTotalPrice());
                break;
            case 9:
                p9.setValue(l.getTotalPrice());
                break;
            case 10:
                p10.setValue(l.getTotalPrice());
                break;
            case 11:
                p11.setValue(l.getTotalPrice());
                break;
            case 12:
                p12.setValue(l.getTotalPrice());
                break;
            default:
                break;
        }
        periods.add(p1);
        periods.add(p2);
        periods.add(p3);
        periods.add(p4);
        periods.add(p5);
        periods.add(p6);
        periods.add(p7);
        periods.add(p8);
        periods.add(p9);
        periods.add(p10);
        periods.add(p11);
        periods.add(p12);
    }

    /**
     * Get the existents Periods and do the Plus.
     * @param periodsAux
     * @param ledger
     */
    private void setPeriods(List<Period> periodsAux, Ledger ledger) {
        Period p1 = periodsAux.get(0);
        Period p2 = periodsAux.get(1);
        Period p3 = periodsAux.get(2);
        Period p4 = periodsAux.get(3);
        Period p5 = periodsAux.get(4);
        Period p6 = periodsAux.get(5);
        Period p7 = periodsAux.get(6);
        Period p8 = periodsAux.get(7);
        Period p9 = periodsAux.get(8);
        Period p10 = periodsAux.get(9);
        Period p11 = periodsAux.get(10);
        Period p12 = periodsAux.get(11);
        Month month = ledger.getCreated().getMonth();
        int numberMonth = month.getValue();
        switch (numberMonth) {
            case 1:
                p1.setValue(p1.getValue().add(ledger.getTotalPrice()));
                break;
            case 2:
                p2.setValue(p2.getValue().add(ledger.getTotalPrice()));
                break;
            case 3:
                p3.setValue(p3.getValue().add(ledger.getTotalPrice()));
                break;
            case 4:
                p4.setValue(p4.getValue().add(ledger.getTotalPrice()));
                break;
            case 5:
                p5.setValue(p5.getValue().add(ledger.getTotalPrice()));
                break;
            case 6:
                p6.setValue(p6.getValue().add(ledger.getTotalPrice()));
                break;
            case 7:
                p7.setValue(p7.getValue().add(ledger.getTotalPrice()));
                break;
            case 8:
                p8.setValue(p8.getValue().add(ledger.getTotalPrice()));
                break;
            case 9:
                p9.setValue(p9.getValue().add(ledger.getTotalPrice()));
                break;
            case 10:
                p10.setValue(p10.getValue().add(ledger.getTotalPrice()));
                break;
            case 11:
                p11.setValue(p11.getValue().add(ledger.getTotalPrice()));
                break;
            case 12:
                p12.setValue(p12.getValue().add(ledger.getTotalPrice()));
                break;
            default:
                break;
        }
    }

    /**
     * Method to calculate the total Price of each month in a Year.
     * @param ledger
     * @return
     * @throws ParseException
     */
    public List<Period> getTotalPriceByMonth(Ledger ledger) throws ParseException {
        Integer year = ledger.getYear();
        List<Period> periods = new ArrayList<>();
        // Get the number of days in each month
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        BigDecimal totalValuePeriod = BigDecimal.valueOf(0);
        LocalDate currentdate = LocalDate.now();
        for (Month month : Month.values()) {
            YearMonth yearMonth = YearMonth.of(year, month.getValue());
            int daysInMonth = yearMonth.lengthOfMonth();
            StringBuilder dateStartStr =
                    new StringBuilder("1-").append(month.getValue() + "-").append(year);
            Date dateStart = format.parse(dateStartStr.toString());
            StringBuilder dateFinishStr =
                    new StringBuilder(daysInMonth + "-").append(month.getValue() + "-").append(year);
            Date dateFinish = format.parse(dateFinishStr.toString());
            Period p =
                    Period.builder()
                            .monthNumber(month.getValue())
                            .value( //Get the total SUM by each month.
                                    ledgerRepository.getTotalByDate(dateStart, dateFinish).orElse(new BigDecimal(0)))
                            .build();
            periods.add(p);
            if (null != p.getValue()) {
                totalValuePeriod = totalValuePeriod.add(p.getValue());
            }
        }
        return periods;
    }
}
