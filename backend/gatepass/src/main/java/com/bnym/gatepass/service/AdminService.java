package com.bnym.gatepass.service;

import com.bnym.gatepass.models.LeaveRequest;
import com.bnym.gatepass.models.RequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnym.gatepass.Repositories.LeaveRequestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    LeaveRequestRepository leaveRequestRepository;

    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }
    public List<LeaveRequest> getAllApprovedRequests() {
        return leaveRequestRepository.getLeaveRequestsByStatus_Approved();
    }
    public List<LeaveRequest> getAllRejectedRequests() {
        return leaveRequestRepository.getLeaveRequestsByStatus_Rejected();
    }

    public List<LeaveRequest> getAllPendingRequests() {
        return leaveRequestRepository.getLeaveRequestsByStatus_Pending();
    }
}
