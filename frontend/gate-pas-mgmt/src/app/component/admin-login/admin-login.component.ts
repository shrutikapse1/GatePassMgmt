import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.scss']
})
export class AdminLoginComponent {
  alerttext = "";
  alertBgColor = "";
  id = new FormControl("");
  password = new FormControl("");

  onLogIn() {
    const id = this.id.value;
    const password = this.password.value;
    if (id === "" || password === "") {
      this.alerttext = (id === ""? "Admin Id": "Password") + " cannot be empty";
      this.alertBgColor = "white";
      setTimeout(() => {
        this.alerttext = "";
        this.alertBgColor = "";
      }, 1000)
      return;
    }
  }
}
