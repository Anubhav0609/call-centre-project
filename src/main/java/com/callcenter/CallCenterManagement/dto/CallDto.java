package com.callcenter.CallCenterManagement.dto;

import java.sql.Timestamp;

public class CallDto {

    private Long fromNumber;

    private String startTime;
    private String endTime;
    private Long duration;

    public Long getFromNumber() {
        return fromNumber;
    }

    public void setFromNumber(Long fromNumber) {
        this.fromNumber = fromNumber;
    }


    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public CallDto() {
    }

    public CallDto(Long fromNumber, String startTime, String endTime, Long duration) {
        this.fromNumber = fromNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "CallDto{" +
                "fromNumber=" + fromNumber +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", duration=" + duration +
                '}';
    }
}
