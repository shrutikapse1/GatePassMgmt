import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent {

  constructor(public router: Router) {} 

  alerttext = "";
  alertBgColor = "";
  username = new FormControl("");
  password = new FormControl("");

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