import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserLoginComponent } from './component/user-login/user-login.component';
import { AdminLoginComponent } from './component/admin-login/admin-login.component';

const routes: Routes = [
  {path: "user-login", component: UserLoginComponent},
  {path: "admin-login", component: AdminLoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
