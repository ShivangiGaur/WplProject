import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import {AuthserviceService} from '../../services/authservice.service';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Router } from '@angular/router';
import {UserModel} from '../../models/usermodel';
import {DataserviceService} from '../../services/dataservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class LoginComponent implements OnInit {

  email:string='';
  password:string='';
  loginAsAdmin:boolean=false;

  constructor(
    private authService: AuthserviceService,
    private flashMessagesService: FlashMessagesService,
    private router: Router,
    private dataService: DataserviceService) { }

  ngOnInit() {
    
  }

  onSubmit({value, valid}:{value: any,valid: boolean}){
    console.log(value);
    if(!valid){
      this.flashMessagesService.show('Please enter valid credentials.',{
        cssClass:'alert-danger',
        timeout: 2000
      });
      this.router.navigate(['login']);
    } else {
      // this.dataService.changeMessage(result.id);
      if(!value.loginAsAdmin){
        this.authService.authenticateUser(value.email, value.password)
        .subscribe(
          result => {
            console.log(result._body);
            this.dataService.changeMessage(result._body);
            this.flashMessagesService.show('Login successful!',{
              cssClass:'alert-success',
              timeout:'2000'
            });
            this.router.navigate(['']);
          },
          error => {
            this.flashMessagesService.show('User Login failed due to: '+error,{
              cssClass:'alert-danger',
              timeout:'2000'
            });
            this.router.navigate(['login']);
          }
        );
      } else {
        this.authService.authenticateAdmin(value.email, value.password)
        .subscribe(
          result => {
            console.log(result._body);
            this.dataService.changeMessage(result._body);
            this.flashMessagesService.show('Login successful!',{
              cssClass:'alert-success',
              timeout:'2000'
            });
            this.router.navigate(['admin-panel']);
          },
          error => {
            this.flashMessagesService.show('Admin Login failed due to: '+error,{
              cssClass:'alert-danger',
              timeout:'2000'
            });
            this.router.navigate(['login']);
          }
        );
      }
    }
  }
}
