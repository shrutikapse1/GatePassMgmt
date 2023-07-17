package com.bnym.gatepass.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface LeaveRequestService {

	public int submitRequestForm(int studentId, LocalDate startDate, LocalDate endDate, String reason, String status,
			LocalDate created_at);

	public int adminApproval(int LeaveRequestId, String status, String approved_by,	LocalDateTime updatedAt);

}
