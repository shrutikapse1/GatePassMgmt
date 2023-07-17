package com.bnym.gatepass.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnym.gatepass.models.Admin;
import com.bnym.gatepass.models.ApprovalRequest;
import com.bnym.gatepass.models.LeaveRequest;
import com.bnym.gatepass.service.AdminService;
import com.bnym.gatepass.service.LeaveRequestService;
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@Autowired
	LeaveRequestService leaveRequestService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<Object> adminLogin(@RequestParam("email_id") String emailId,
			@RequestParam("password_hash") String passwordHash) {
		Admin admin = adminService.findByEmailIdAndPasswordHash(emailId, passwordHash);
		if (admin == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid username or password");
		} else {
			return ResponseEntity.ok(admin);
		}
	}

	@RequestMapping(value = "/leaveHistory", method = RequestMethod.GET)
	public ResponseEntity<Object> readHistory(@RequestParam("studentid") String studentId) {
		List<LeaveRequest> leaveRequests = adminService.getAllLeaveRequests(studentId);
		if (leaveRequests==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No leave requests found for the student");
		} else {
			return ResponseEntity.ok(leaveRequests);
		}
	}

	@RequestMapping(value = "/leaveHistory/approved", method = RequestMethod.GET)
	public ResponseEntity<Object> readApprovedRequests(@RequestParam("studentid") String studentid) throws Exception {
		List<LeaveRequest> leaveRequests = adminService.getAllApprovedRequests(studentid);
		if (leaveRequests==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No approved requests found for the student");
		} else {
			return ResponseEntity.ok(leaveRequests);
		}
	}

	@RequestMapping(value = "/leaveHistory/rejected", method = RequestMethod.GET)
	public ResponseEntity<Object> readRejectdRequests(@RequestParam("studentid") String studentid) throws Exception {
		List<LeaveRequest> leaveRequests = adminService.getAllRejectedRequests(studentid);
		if (leaveRequests==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No rejected requests found for the student");
		} else {
			return ResponseEntity.ok(leaveRequests);
		}
	}

	@RequestMapping(value = "/leaveHistory/pending", method = RequestMethod.GET)
	public ResponseEntity<Object> readPendingRequests(@RequestParam("studentid") String studentid) throws Exception {
		List<LeaveRequest> leaveRequests = adminService.getAllPendingRequests(studentid);
		if (leaveRequests==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No pending requests found for the student");
		} else {
			return ResponseEntity.ok(leaveRequests);
		}
	}
	
	@RequestMapping(value = "/approval", method = RequestMethod.POST)
	public ResponseEntity<String> adminApproval(@RequestBody ApprovalRequest approvalRequest) {
		LocalDateTime updatedAt =LocalDateTime.now();
	    int status = leaveRequestService.adminApproval(
	        approvalRequest.getLeaveRequestId(),
	        approvalRequest.getStatus(),
	        approvalRequest.getApprovedBy(),
	        updatedAt
	    );

	    if (status > 0) {
	        return ResponseEntity.ok("Successful");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid");
	    }
	}

}