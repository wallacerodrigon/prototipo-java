import {Component, Input} from '@angular/core';
import {AUTH_METHOD, AUTH_METHOD_ENUM} from '../../../app.constants';
import {Router} from '@angular/router';
import {AuthService} from '../../../core/auth/auth.service';

declare function require(path: string);

@Component({
  selector: 'app-sidebar-menu',
  templateUrl: './sidebar-menu.component.html',
  styleUrls: ['./sidebar-menu.component.css'],
})
export class SidebarMenuComponent {

  @Input() system: string;
  @Input() clientName: string;
  @Input() systemVersion: string;
  imageSrc: string = require('../../../../../logo.png');

  navOptions: any = [
    {
      label: 'Dashboard',
      routerLink: ['dashboard'],
      icon: 'dashboard'
    },
    {
      label: 'Empregadores',
      routerLink: ['employer'],
      icon: 'domain'
    },
    {
      label: 'Configuração',
      children: [{
        label: 'Usuários',
        routerLink: ['user'],
        icon: 'person'
      }]
    }
  ];

  constructor(private router: Router, private authService: AuthService) {
  }

  onLogout(): void {
    this.authService.logout();
  }

  displayLogin(): boolean {
    return AUTH_METHOD !== AUTH_METHOD_ENUM.NONE;
  }

}
