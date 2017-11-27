import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import {AuthserviceService} from '../../services/authservice.service';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class NavbarComponent implements OnInit {

  isLoggedIn: boolean = false;
  showRegister: boolean;
  loggedInUser: string;

  constructor(
    private authService: AuthserviceService,
    private flashMessagesService: FlashMessagesService,
    private router: Router) { }

  ngOnInit() {
    
  }
  
  onLogoutClick(){

  }

}
