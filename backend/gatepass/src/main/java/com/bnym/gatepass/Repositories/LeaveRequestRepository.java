package com.bnym.gatepass.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnym.gatepass.models.LeaveRequest;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {

    // Additional custom methods for LeaveRequest repository can be added here
    @Query(value ="select * from leave_requests lr where lr.studentid = ?1 AND lr.status=\"APPROVED\"", nativeQuery = true)
    List<LeaveRequest> getLeaveRequestsByStatus_Approved(String studentid);
    @Query(value ="select * from leave_requests lr where lr.studentid = ?1 AND lr.status=\"REJECTED\"", nativeQuery = true)
    List<LeaveRequest> getLeaveRequestsByStatus_Rejected(String studentid);
    @Query(value ="select * from leave_requests lr where lr.studentid = ?1 AND lr.status=\"PENDING\"", nativeQuery = true)
    List<LeaveRequest> getLeaveRequestsByStatus_Pending(String studentid);
    @Query(value ="select * from leave_requests lr where lr.studentid = ?1 ", nativeQuery = true)
	List<LeaveRequest> getAllLeaveRequests(String studentid);
}