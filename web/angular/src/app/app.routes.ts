import {Routes} from '@angular/router';
import {NotFoundComponent} from './shared/components/not-found/not-found.component';
import { LoginComponent } from './modules/login/component/login-component.component';

export const ROUTES: Routes = [
  {
    path: '', children: [
      {path: 'login', loadChildren: './modules/login/login.module#LoginModule'},
      {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
      {path: 'dashboard', loadChildren: './modules/dashboard/dashboard.module#DashboardModule'},
      {path: 'user', loadChildren: './modules/user/user.module'},
      {path: 'employer', loadChildren: './modules/employer/employer.module#EmployerModule'},
      {path: '**', component: NotFoundComponent}
    ]
  },
  {path: '**', component: NotFoundComponent}
];
