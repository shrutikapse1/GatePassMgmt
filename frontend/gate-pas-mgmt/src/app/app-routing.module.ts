import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserLoginComponent } from './component/user-login/user-login.component';
import { AdminLoginComponent } from './component/admin-login/admin-login.component';
import { HomeComponent } from './component/home/home.component';
import { StudentContentComponent } from './component/student-content/student-content.component';
import { AdminContentComponent } from './component/admin-content/admin-content.component';

const routes: Routes = [
  {path: "", redirectTo: "/home", pathMatch: "full"},
  {path: "home", component: HomeComponent},
  {path: "user-login", component: UserLoginComponent},
  {path: "admin-login", component: AdminLoginComponent},
  {path:"app-student-content/:sid",component: StudentContentComponent},
  {path:"app-admin-content/:adminName",component:AdminContentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
