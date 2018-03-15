import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CoreModule} from '../../core/core.module';

import {AuthGuard} from '../../core/auth/auth.guard';
import { LoginComponent } from './component/login-component.component';

/*const ROUTES: Routes = [
  {
    path: 'login', canActivateChild: [AuthGuard],
    data: {
      title: 'Identificação'
    },
    children: [
      {path: '', component: LoginComponent},
    ]
  }
];*/

@NgModule({
  imports: [
    CoreModule,
    //RouterModule.forChild(ROUTES)
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  declarations: [LoginComponent],
  exports: [LoginComponent],
})
export class LoginModule {
}
