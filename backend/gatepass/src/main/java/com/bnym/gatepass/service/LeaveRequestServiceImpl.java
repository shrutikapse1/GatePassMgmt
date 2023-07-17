package com.bnym.gatepass.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnym.gatepass.Repositories.LeaveRequestRepository;
@Service
public class LeaveRequestServiceImpl implements LeaveRequestService{

	@Autowired
	LeaveRequestRepository leaveRequestRepository;
	
	@Override
    @Transactional
	public int submitRequestForm(int studentId, LocalDate startDate, LocalDate endDate, String reason,
			String status,LocalDate created_at) {
		
		return leaveRequestRepository.submitRequestForm(studentId, startDate, endDate, reason, status,created_at);
	}

	@Override
    @Transactional
	public int adminApproval(int LeaveRequestId, String status, String approved_by,LocalDateTime updatedAt) {
		
		return leaveRequestRepository.adminApproval(LeaveRequestId, approved_by, status, updatedAt);
	}

}
