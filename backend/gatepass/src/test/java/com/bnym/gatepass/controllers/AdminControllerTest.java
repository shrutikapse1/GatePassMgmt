package com.bnym.gatepass.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.bnym.gatepass.models.Admin;
import com.bnym.gatepass.models.ApprovalRequest;
import com.bnym.gatepass.models.LeaveRequest;
import com.bnym.gatepass.service.AdminService;
import com.bnym.gatepass.service.LeaveRequestService;

@ExtendWith(MockitoExtension.class)
public class AdminControllerTest {
	@InjectMocks
	AdminController adminController;

	@Mock
	AdminService adminService;

	@Mock
	LeaveRequestService leaveRequestService;

	@Test
	public void adminLoginTest1() throws Exception{
		Admin admin=new Admin();
		Mockito.when(adminService.findByEmailIdAndPasswordHash("","")).thenReturn(admin);
		ResponseEntity<Object> res= adminController.adminLogin("", "");
		assertEquals(200,res.getStatusCodeValue());
	}

	@Test
	public void adminLoginTest2() throws Exception{
		Mockito.when(adminService.findByEmailIdAndPasswordHash("","")).thenReturn(null);
		ResponseEntity<Object> res= adminController.adminLogin("", "");
		assertEquals(404,res.getStatusCodeValue());
	}

	@Test
	public void readHistoryTest1() throws Exception {
		List<LeaveRequest> leaveRequests=new ArrayList<LeaveRequest>();
		Mockito.when(adminService.getAllLeaveRequests("")).thenReturn(leaveRequests);
		ResponseEntity<Object> list= adminController.readHistory("");
		assertEquals(200,list.getStatusCodeValue());
	}

	@Test
	public void readHistoryTest2() throws Exception {
		Mockito.when(adminService.getAllLeaveRequests("")).thenReturn(null);
		ResponseEntity<Object> list= adminController.readHistory("");
		assertEquals(404,list.getStatusCodeValue());
	}

	@Test
	public void readApprovedRequestsTest1() throws Exception {
		List<LeaveRequest> leaveRequests=new ArrayList<LeaveRequest>();
		Mockito.when(adminService.getAllApprovedRequests("")).thenReturn(leaveRequests);
		ResponseEntity<Object> list= adminController.readApprovedRequests("");
		assertEquals(200,list.getStatusCodeValue());
	}

	@Test
	public void readApprovedRequestsTest2() throws Exception {
		Mockito.when(adminService.getAllApprovedRequests("")).thenReturn(null);
		ResponseEntity<Object> list= adminController.readApprovedRequests("");
		assertEquals(404,list.getStatusCodeValue());
	}

	@Test
	public void readRejectdRequestsTest1() throws Exception {
		List<LeaveRequest> leaveRequests=new ArrayList<LeaveRequest>();
		Mockito.when(adminService.getAllRejectedRequests("")).thenReturn(leaveRequests);
		ResponseEntity<Object> list= adminController.readRejectdRequests("");
		assertEquals(200,list.getStatusCodeValue());
	}

	@Test
	public void readRejectdRequestsTest2() throws Exception {
		Mockito.when(adminService.getAllRejectedRequests("")).thenReturn(null);
		ResponseEntity<Object> list= adminController.readRejectdRequests("");
		assertEquals(404,list.getStatusCodeValue());
	}

	@Test
	public void readPendingRequestsTest1() throws Exception {
		List<LeaveRequest> leaveRequests=new ArrayList<LeaveRequest>();
		Mockito.when(adminService.getAllPendingRequests("")).thenReturn(leaveRequests);
		ResponseEntity<Object> list= adminController.readPendingRequests("");
		assertEquals(200,list.getStatusCodeValue());
	}

	@Test
	public void readPendingRequestsTest2() throws Exception {
		Mockito.when(adminService.getAllPendingRequests("")).thenReturn(null);
		ResponseEntity<Object> list= adminController.readPendingRequests("");
		assertEquals(404,list.getStatusCodeValue());
	}

	@Test
	public void readAllPendingRequestsTest1() throws Exception {
		List<LeaveRequest> leaveRequests=new ArrayList<LeaveRequest>();
		Mockito.when(adminService.getPendingRequests()).thenReturn(leaveRequests);
		List<LeaveRequest> list=adminController.readAllPendingRequests();
		assertNotNull(list);
	}

//	@Test
//	public void adminApprovalTest1() throws Exception {
//		ApprovalRequest approvalRequest=new ApprovalRequest();
//		approvalRequest.setLeaveRequestId(1);
//		approvalRequest.setStatus("approved");
//		approvalRequest.setApprovedBy("Pratap");
//		ResponseEntity<String> list= adminController.adminApproval(approvalRequest);
//
//	}

}