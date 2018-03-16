import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CoreModule} from '../../core/core.module';

import {AuthGuard} from '../../core/auth/auth.guard';
import { LoginComponent } from './component/login-component.component';
import { LoginOutlet } from './login.outlet';


@NgModule({
  imports: [
    CoreModule,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  declarations: [LoginComponent, LoginOutlet],
  exports: [LoginComponent, LoginOutlet],
})
export class LoginModule {
}
