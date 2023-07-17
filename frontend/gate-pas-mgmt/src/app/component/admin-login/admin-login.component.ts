import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from 'src/app/data-models';
import { AuthService } from 'src/app/service/auth.service';

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

  admin: Admin = {
    email_id: 'likhitha@gmail.com',
    admin_full_name: 'likhitha'
  };

  constructor(public router: Router, public authService: AuthService) {} 

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

    this.authService.adminLogin(username, password).subscribe({
      next: (data) => {
      // this.admin = data;
      console.log(this.admin.admin_full_name);
      this.router.navigate(['/app-admin-content',this.admin.admin_full_name]);
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

