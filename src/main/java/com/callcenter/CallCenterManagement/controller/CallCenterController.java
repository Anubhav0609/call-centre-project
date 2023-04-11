package com.callcenter.CallCenterManagement.controller;

import com.callcenter.CallCenterManagement.dto.CallDto;
import com.callcenter.CallCenterManagement.service.CallCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("call-center")
public class CallCenterController {

    @Autowired
    private CallCenterService callCenterService;
    @GetMapping
    public ResponseEntity<?> getCallStatics(@RequestParam String date){

        return callCenterService.getCallStatics(date);
    }
    @GetMapping("/day-wise")
    public ResponseEntity<?> getCallStaticsDayWise(@RequestParam String startDate, @RequestParam String endDate){

        return callCenterService.getCallStaticsDayWise(startDate, endDate);
    }


    @PostMapping
    public ResponseEntity<?> saveCall(@RequestBody CallDto callDto){

        return callCenterService.saveCall(callDto);
    }
}
