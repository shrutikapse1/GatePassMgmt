package com.bnym.gatepass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnym.gatepass.Repositories.AdminRepository;
import com.bnym.gatepass.Repositories.LeaveRequestRepository;
import com.bnym.gatepass.models.Admin;
import com.bnym.gatepass.models.LeaveRequest;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	LeaveRequestRepository leaveRequestRepository;
	
	@Autowired 
	AdminRepository adminRepository;

	public List<LeaveRequest> getAllLeaveRequests(String studentid) {
		return leaveRequestRepository.getAllLeaveRequests(studentid);
	}

	public List<LeaveRequest> getAllApprovedRequests(String studentid) {
		return leaveRequestRepository.getLeaveRequestsByStatus_Approved(studentid);
	}

	public List<LeaveRequest> getAllRejectedRequests(String studentid) {
		return leaveRequestRepository.getLeaveRequestsByStatus_Rejected(studentid);
	}

	public List<LeaveRequest> getAllPendingRequests(String studentid) {
		return leaveRequestRepository.getLeaveRequestsByStatus_Pending(studentid);
	}

	@Override
	public Admin findByEmailIdAndPasswordHash(String emailId, String passwordHash) {
		return adminRepository.findByEmailIdAndPasswordHash(emailId, passwordHash);
	}
}