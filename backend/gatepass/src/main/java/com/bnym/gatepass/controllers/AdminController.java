package com.bnym.gatepass.controllers;

import com.bnym.gatepass.models.LeaveRequest;
import com.bnym.gatepass.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value="/leaveHistory", method= RequestMethod.GET)
    public List<LeaveRequest> readHistory() throws Exception {
        List<LeaveRequest> leaveRequests=adminService.getAllLeaveRequests();;
        if(leaveRequests==null) throw new Exception("No leave Request till now ");
        return leaveRequests;
    }

    @RequestMapping(value="/leaveHistory/approved", method= RequestMethod.GET)
    public List<LeaveRequest> readApprovedRequests() throws Exception {
        List<LeaveRequest> leaveRequests=adminService.getAllApprovedRequests();;
        if(leaveRequests==null) throw new Exception("No leave Request till now ");
        return leaveRequests;
    }

    @RequestMapping(value="/leaveHistory/rejected", method= RequestMethod.GET)
    public List<LeaveRequest> readRejectdRequests() throws Exception {
        List<LeaveRequest> leaveRequests=adminService.getAllRejectedRequests();
        if(leaveRequests==null) throw new Exception("No Rejected Request till now ");
        return leaveRequests;
    }
    @RequestMapping(value="/leaveHistory/pending", method= RequestMethod.GET)
    public List<LeaveRequest> readPendingRequests() throws Exception {
        List<LeaveRequest> leaveRequests=adminService.getAllPendingRequests();
        if(leaveRequests==null) throw new Exception("No Pending Request till now ");
        return leaveRequests;
    }
}
