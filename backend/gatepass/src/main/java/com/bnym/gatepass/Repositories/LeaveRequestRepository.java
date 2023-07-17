package com.bnym.gatepass.Repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Modifying
    @Query(value = "INSERT INTO leave_requests (studentid, start_date, end_date, reason, status,created_at) " +
                   "VALUES (:studentId, :startDate, :endDate, :reason, :status,:created_at)", nativeQuery = true)
    int submitRequestForm(@Param("studentId") int studentId,
                          @Param("startDate") LocalDate startDate,
                          @Param("endDate") LocalDate endDate,
                          @Param("reason") String reason,
                          @Param("status") String status,
                          @Param("created_at") LocalDate createdAt);
    
    @Modifying
    @Query(value = "UPDATE leave_requests  SET approved_by = :approved_by, status = :status ,updated_at=:updated_at " +
                   "WHERE leave_request_id = :leave_request_id", nativeQuery = true)
    int adminApproval(@Param("leave_request_id") int leave_request_id,
                           @Param("approved_by") String approved_by,
                           @Param("status") String status,
                           @Param("updated_at") LocalDateTime updated_at);

}