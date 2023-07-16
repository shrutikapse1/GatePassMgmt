package com.bnym.gatepass.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnym.gatepass.models.LeaveRequest;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {

    // Additional custom methods for LeaveRequest repository can be added here
    @Query(value ="select * from leave_requests lr where lr.status=\"APPROVED\"", nativeQuery = true)
    List<LeaveRequest> getLeaveRequestsByStatus_Approved();
    @Query(value ="select * from leave_requests lr where lr.status=\"REJECTED\"", nativeQuery = true)
    List<LeaveRequest> getLeaveRequestsByStatus_Rejected();
    @Query(value ="select * from leave_requests lr where lr.status=\"PENDING\"", nativeQuery = true)
    List<LeaveRequest> getLeaveRequestsByStatus_Pending();
}

