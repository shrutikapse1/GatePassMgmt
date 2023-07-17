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
    let approvalRequest: ApprovalRequest = {leaveRequestId, status, approvedBy};
    return this.http.post(API_URL_ADMIN + '/approval', approvalRequest);
  }

  postSubmitRequestForm(studentId: number, startDate: Date, endDate: Date, reason: string) {
    let httpParams = new HttpParams();
    httpParams = httpParams.append("studentid", studentId);
    httpParams = httpParams.append("start_date", startDate.toISOString());
    httpParams = httpParams.append("end_date", endDate.toISOString());
    httpParams = httpParams.append("reason", reason);
    return this.http.post(API_URL_STUDENT + '/approval', null, {params: httpParams})
  }
}
