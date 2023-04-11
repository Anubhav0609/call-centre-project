package com.callcenter.CallCenterManagement.service;

import com.callcenter.CallCenterManagement.dto.CallDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CallCenterService {

    ResponseEntity<?> saveCall(CallDto callDto);

    ResponseEntity<?> getCallStatics(String date);

    ResponseEntity<?> getCallStaticsDayWise(String startDate, String endDate);
}
