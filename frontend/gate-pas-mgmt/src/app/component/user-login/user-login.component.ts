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
  id = new FormControl("");
  password = new FormControl("");

  onLogIn() {
    const id = this.id.value;
    const password = this.password.value;
    if (id === "" || password === "") {
      this.alerttext = (id === ""? "Student Id": "Password") + " cannot be empty";
      this.alertBgColor = "white";
      setTimeout(() => {
        this.alerttext = "";
        this.alertBgColor = "";
      }, 1000)
      return;
    }
  }
}