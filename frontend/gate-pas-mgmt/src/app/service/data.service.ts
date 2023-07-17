import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RequestStatus, Student, Admin, LeaveRequest, ApprovalRequest} from '../data-models';

const API_URL_ADMIN = "http://localhost:8090/admin";
const API_URL_STUDENT = "http://localhost:8090/student"

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(public http: HttpClient) { }
  

  getAllPendingRequests() {
    return this.http.get<LeaveRequest[]>(API_URL_ADMIN + '/leaveHistory/allpending');
  }
  getAllRequestsByStudentId(studentId: string) {
    let httpParams = new HttpParams();
    httpParams = httpParams.append("studentid", studentId);
    return this.http.get<LeaveRequest[]>(API_URL_ADMIN + '/leaveHistory', {params: httpParams});
  }

  getApprovedRequestsByStudentId(studentId: string) {
    let httpParams = new HttpParams();
    httpParams = httpParams.append("studentid", studentId);
    return this.http.get<LeaveRequest[]>(API_URL_ADMIN + '/leaveHistory/approved', {params: httpParams});
  }
  
  getRejectedRequestsByStudentId(studentId: string) {
    let httpParams = new HttpParams();
    httpParams = httpParams.append("studentid", studentId);
    return this.http.get<LeaveRequest[]>(API_URL_ADMIN + '/leaveHistory/rejected', {params: httpParams});
  }

  getPendingRequestsByStudentId(studentId: string) {
    let httpParams = new HttpParams();
    httpParams = httpParams.append("studentid", studentId);
    return this.http.get<LeaveRequest[]>(API_URL_ADMIN + '/leaveHistory/pending', {params: httpParams});
  }

  postAdminApproval(leaveRequestId: number, status: string, approvedBy: string) {
    let httpParams = new HttpParams();
    httpParams = httpParams.append("request_id", leaveRequestId);
    httpParams = httpParams.append("status", status);
    httpParams = httpParams.append("approved_by", approvedBy);
    return this.http.post(API_URL_ADMIN + '/approval', null, {params: httpParams});
  }

  postSubmitRequestForm(studentId: number, startDate: string, endDate: string, reason: string) {
    let httpParams = new HttpParams();
    httpParams = httpParams.append("studentid", studentId);
    httpParams = httpParams.append("start_date", startDate);
    httpParams = httpParams.append("end_date", endDate);
    httpParams = httpParams.append("reason", reason);
    return this.http.post(API_URL_STUDENT + '/submit', null, {params: httpParams})
  }
}
