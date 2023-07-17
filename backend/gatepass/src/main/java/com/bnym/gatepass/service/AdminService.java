package com.bnym.gatepass.service;

import java.util.List;

import com.bnym.gatepass.models.Admin;
import com.bnym.gatepass.models.LeaveRequest;

public interface AdminService {
	public List<LeaveRequest> getAllLeaveRequests(String studentid);

	public List<LeaveRequest> getAllApprovedRequests(String studentid);

	public List<LeaveRequest> getAllRejectedRequests(String studentid);

	public List<LeaveRequest> getAllPendingRequests(String studentid);

	public Admin findByEmailIdAndPasswordHash(String emailId, String passwordHash);

}
