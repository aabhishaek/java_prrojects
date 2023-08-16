package com.abhishek.taxcalculator.controller;

import com.abhishek.taxcalculator.model.Salary;
import com.abhishek.taxcalculator.model.SalaryDTO;
import com.abhishek.taxcalculator.service.SalaryService;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controller containing end points to perform salary related operations
 */
@RestController
@RequestMapping("/salary")
public class SalaryController extends BaseController{

    SalaryService salaryService;

    public SalaryController(SalaryService salaryService, ResourceBundleMessageSource messageSource) {
        super(messageSource);
        this.salaryService = salaryService;
    }

    /**
     * POST Endpoint to save the salary details
     *
     * @param "Salary Object with required properties"
     * @return Confirmation message indicating salary has been stored
     */
    @PostMapping
    public ResponseEntity<Void> storeSalary(@RequestBody Salary salary) {
        salaryService.storeSalary(salary);

        return wrapResponse("salary.save.successful.message");
    }

    /**
     * GET Endpoint to get the saved salary details of a user
     * @param userId
     * @return Salary Object
     */
    @GetMapping("/{userId}")
    public ResponseEntity<List<Object>> getSalary(@PathVariable String userId) {
        Salary salary = salaryService.getSalary(userId);

        List<Object> responseList = new ArrayList<>();
        responseList.add(new SalaryDTO("basic", "basic", getRes("salary.basic.label"), salary.getBasic()));
        responseList.add(new SalaryDTO("hra", "hra", getRes("salary.hra.label"), salary.getHra()));
        responseList.add(new SalaryDTO("spAll", "specialAllowance", getRes("salary.sa.label"), salary.getSpecialAllowance()));
        responseList.add(new SalaryDTO("eepf", "employerEPFContribution", getRes("salary.eepf.label"), salary.getEmployerEPFContribution()));

        Map<String, BigDecimal> otherAllowances = salary.getOtherAllowances();
        List<Object> otherAllowancesObj = new ArrayList<>();
        if (otherAllowances != null) {

            for (Map.Entry<String, BigDecimal> entry: otherAllowances.entrySet()) {
                otherAllowancesObj.add(new SalaryDTO(entry.getKey().replaceAll("\\s+", "").toLowerCase(), entry.getKey(),
                                               entry.getKey(), entry.getValue()));
            }
        }
        responseList.add(new SalaryDTO("otherAllowances", "", "", otherAllowancesObj));


        return wrapResponse(responseList);
    }

}
