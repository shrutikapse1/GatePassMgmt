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
export class UserLoginComponent{
  alerttext = "";
  alertBgColor = "";
  username = new FormControl("");
  password = new FormControl("");
  student: Student = {
    studentID: 1,
    studentFullName: '',
    className: '',
    division: '',
    rollNo: '',
    email_id: ''
  };

  constructor(public router: Router, public authService: AuthService) {
  } 

  onLogIn() {
    const username = <string>this.username.value;
    const password = <string>this.password.value;

    if (username === "" || password === "") {
      this.alerttext = (username === ""? "Student username": "Password") + " cannot be empty";
      this.alertBgColor = "white";
      setTimeout(() => {
        this.alerttext = "";
        this.alertBgColor = "";
      }, 1000)
      return;
    }

    this.authService.studentLogin(username, password).subscribe({
      next: (data) => {
      this.student = data;
      this.router.navigate(['/app-student-content',data.studentID]);
      }, 
      error: () => {
        this.alerttext = "Invalid username or password";
        this.alertBgColor = "white";
        setTimeout(() => {
          this.alerttext = "";
          this.alertBgColor = "";
        }, 1000)
      }
    });
  }
}
