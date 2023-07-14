import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent {
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
  }
}