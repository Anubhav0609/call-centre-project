package com.callcenter.CallCenterManagement.repository;

import com.callcenter.CallCenterManagement.domain.Call;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CallRepository extends CrudRepository<Call, Long> {

    List<Call> findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(Timestamp start, Timestamp end);

}
