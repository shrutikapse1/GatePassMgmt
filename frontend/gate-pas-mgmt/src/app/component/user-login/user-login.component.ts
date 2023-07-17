import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Student } from 'src/app/data-models';
import { AuthService } from 'src/app/service/auth.service';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent implements OnInit{
  alerttext = "";
  alertBgColor = "";
  username = new FormControl("");
  password = new FormControl("");
  student: Student = {
    studentID: 0,
    studentFullName: '',
    className: '',
    division: '',
    rollNo: '',
    email_id: ''
  };;

  constructor(public router: Router, public dataService: DataService, public authService: AuthService) {
  } 

  ngOnInit(): void {
    this.authService.studentLogin('shruti@gmail.com', 'shruti123').subscribe((data) => {
      this.student = data;
    });
  }

  onLogIn() {
    const username = this.username.value;
    const password = this.password.value;

    if (username === "" || password === "") {
      this.alerttext = (username === ""? "Student username": "Password") + " cannot be empty";
      this.alertBgColor = "white";
      setTimeout(() => {
        this.alerttext = "";
        this.alertBgColor = "";
      }, 1000)
      return;
    }
    this.router.navigate(['/', 'app-student-content']);
  }
}