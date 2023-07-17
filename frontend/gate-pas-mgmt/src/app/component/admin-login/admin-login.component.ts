import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from 'src/app/data-models';

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
  admin:Admin={email_id:'abc@gmail.com',
    admin_full_name:'FirstAdmin'};

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
    this.router.navigate(['/app-admin-content',this.admin.admin_full_name]);
  }
}
