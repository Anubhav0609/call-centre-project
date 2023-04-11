package com.callcenter.CallCenterManagement.domain;

import com.callcenter.CallCenterManagement.dto.CallDto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Call{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long fromNumber;

    private Timestamp startTime;
    private Timestamp endTime;
    private Long duration;

    public Call() {
     super();
    }

    public Call(CallDto callDto) {
        this.duration = callDto.getDuration();
        this.fromNumber  = callDto.getFromNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromNumber() {
        return fromNumber;
    }

    public void setFromNumber(Long fromNumber) {
        this.fromNumber = fromNumber;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Call call = (Call) o;
        return Objects.equals(id, call.id) && Objects.equals(fromNumber, call.fromNumber) && Objects.equals(startTime, call.startTime) && Objects.equals(endTime, call.endTime) && Objects.equals(duration, call.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromNumber, startTime, endTime, duration);
    }
}
