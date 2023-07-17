import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.scss']
})
export class AdminLoginComponent {
  alerttext = "";
  alertBgColor = "";
  username = new FormControl("");
  password = new FormControl("");

  constructor(public router: Router) {} 

  onLogIn() {
    const username = this.username.value;
    const password = this.password.value;

    if (username === "" || password === "") {
      this.alerttext = (username === ""? "Admin username": "Password") + " cannot be empty";
      this.alertBgColor = "white";
      setTimeout(() => {
        this.alerttext = "";
        this.alertBgColor = "";
      }, 1000)
      return;
    }
    this.router.navigate(['/', 'app-admin-content']);
  }
}
