import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Student, Admin } from '../data-models';

const API_URL_ADMIN = "http://localhost:8090/admin";
const API_URL_STUDENT = "http://localhost:8090/student";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(public http: HttpClient) { }

  studentLogin(emailId: string, password: string) {
    let httpParams = new HttpParams();
    httpParams = httpParams.append("email_id", emailId);
    httpParams = httpParams.append("password_hash", password);
    return this.http.get<Student>(API_URL_STUDENT + '/login', {params: httpParams});
  }

  adminLogin(emailId: string, password: string) {
    let httpParams = new HttpParams();
    httpParams = httpParams.append("email_id", emailId);
    httpParams = httpParams.append("password_hash", password);
    return this.http.get<Admin>(API_URL_ADMIN + '/login', {params: httpParams});
  }
}
