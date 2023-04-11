package com.callcenter.CallCenterManagement.service.impl;

import com.callcenter.CallCenterManagement.domain.Call;
import com.callcenter.CallCenterManagement.dto.CallDto;
import com.callcenter.CallCenterManagement.repository.CallRepository;
import com.callcenter.CallCenterManagement.service.CallCenterService;
import com.callcenter.CallCenterManagement.util.DateUtil;
import com.callcenter.CallCenterManagement.util.UtilService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CallCenterServiceImpl implements CallCenterService {

    @Autowired
    private CallRepository callRepository;
    @Override
    public ResponseEntity<?> saveCall(CallDto callDto) {

        Call call = new Call(callDto);
        call.setStartTime(DateUtil.getTimeStamp(callDto.getStartTime()));
        call.setEndTime(DateUtil.getTimeStamp(callDto.getEndTime()));
        call.setDuration(DateUtil.getSeconds(callDto.getStartTime(), callDto.getEndTime()));
        callRepository.save(call);
        return ResponseEntity.ok(call);
    }

    public ResponseEntity<?> getCallStatics(String date){
        DateTime starTime = DateUtil.getDateTime(date);
        DateTime endTime = starTime.plusDays(1);
        List<Call> calls = callRepository.findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(new Timestamp(starTime.getMillis()), new Timestamp(endTime.getMillis()));
         System.out.println(calls);
         Integer volume = getVolume(calls);
         String AMPM = volume > 12 ? " PM" : " AM";
         Integer volumePlus = volume + 1;
         String format = volume + "-" + volumePlus + AMPM;
        System.out.println("Hour of the day when the call volume is highest is "+format);
        volume = getHighest(calls);
        AMPM = volume > 12 ? " PM" : " AM";
        volumePlus = volume + 1;
        format = volume + "-" + volumePlus + AMPM;
        System.out.println("Hour of the day when the calls are longest is "+format);
         return ResponseEntity.ok(calls);
    }

    private Integer getVolume(List<Call> calls) {
        Map<Integer, Long> map = new HashMap<>();
        Integer key = 0;
        Integer volume = 0;
        for (Call call : calls){
            Integer hoursOfDay = new DateTime(call.getStartTime()).getHourOfDay();
            if (map.containsKey(hoursOfDay)){
               map.put(hoursOfDay, map.get(hoursOfDay) + 1L);
            }else {
                map.put(hoursOfDay, 1L);
            }
        }

        for (Map.Entry<Integer, Long> entry : map.entrySet()){
            if (entry.getValue() > volume){
                key = entry.getKey();
            }
        }

        return key;

    }

    private Integer getHighest(List<Call> calls) {

        Map<Integer, Long> map = new HashMap<>();
        Integer key = 0;
        Integer volume = 0;
        for (Call call : calls){
            Integer hoursOfDay = new DateTime(call.getStartTime()).getHourOfDay();
            if (map.containsKey(hoursOfDay)){
                map.put(hoursOfDay, map.get(hoursOfDay) + call.getDuration());
            }else {
                map.put(hoursOfDay, call.getDuration());
            }
        }

        for (Map.Entry<Integer, Long> entry : map.entrySet()){
            if (entry.getValue() > volume){
                key = entry.getKey();
            }
        }

        return key;
    }

    public ResponseEntity<?> getCallStaticsDayWise(String startDate, String endDate){
        DateTime starTime = DateUtil.getDateTime(startDate);
        DateTime endTime = DateUtil.getDateTime(endDate);
        List<Call> calls = callRepository.findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(new Timestamp(starTime.getMillis()), new Timestamp(endTime.getMillis()));
        System.out.println(calls);
        Integer volume = getVolumeDayWise(calls);
        System.out.println("Day of the week when the call volume is highest : "+ UtilService.getDayName(volume));
        volume = getHighestDayWise(calls);

        System.out.println("Day of the week when the calls are longest : "+UtilService.getDayName(volume));
        return ResponseEntity.ok(calls);
    }

    private Integer getHighestDayWise(List<Call> calls) {

        Map<Integer, Long> map = new HashMap<>();
        Integer key = 0;
        Integer volume = 0;
        for (Call call : calls){
            Integer dayOfWeek = new DateTime(call.getStartTime()).getDayOfWeek();
            if (map.containsKey(dayOfWeek)){
                map.put(dayOfWeek, map.get(dayOfWeek) + call.getDuration());
            }else {
                map.put(dayOfWeek, call.getDuration());
            }
        }

        for (Map.Entry<Integer, Long> entry : map.entrySet()){
            if (entry.getValue() > volume){
                key = entry.getKey();
            }
        }

        return key;
    }

    private Integer getVolumeDayWise(List<Call> calls) {
        Map<Integer, Long> map = new HashMap<>();
        Integer key = 0;
        Integer volume = 0;
        for (Call call : calls){
            Integer dayOfWeek = new DateTime(call.getStartTime()).getDayOfWeek();
            if (map.containsKey(dayOfWeek)){
                map.put(dayOfWeek, map.get(dayOfWeek) + 1L);
            }else {
                map.put(dayOfWeek, 1L);
            }
        }

        for (Map.Entry<Integer, Long> entry : map.entrySet()){
            if (entry.getValue() > volume){
                key = entry.getKey();
            }
        }

        return key;
    }
}
