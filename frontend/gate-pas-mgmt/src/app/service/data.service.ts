import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const AUTH_USER_URL = "";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(public httpClient: HttpClient) { }

  
}
