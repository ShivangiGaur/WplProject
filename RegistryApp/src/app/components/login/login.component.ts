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

  constructor(
    private authService: AuthserviceService,
    private flashMessagesService: FlashMessagesService,
    private router: Router,
    private dataService: DataserviceService) { }

  ngOnInit() {
    
  }

  onSubmit({value, valid}:{value: any,valid: boolean}){
    if(!valid){
      this.flashMessagesService.show('Please enter valid credentials.',{
        cssClass:'alert-danger',
        timeout: 2000
      });
      this.router.navigate(['login']);
    } else {
      // let result:UserModel = this.authService.authenticateUser(value.email,value.password);
      // if(result){
      //   this.flashMessagesService.show('Successfully logged in.',{
      //     cssClass:'alert-success',
      //     timeout: 2000
      //   });
      //   this.dataService.changeMessage(result.id);
      //   this.router.navigate(['']);
      // } else{
      //   this.flashMessagesService.show('Invalid username or password. Please try again.',{
      //     cssClass:'alert-danger',
      //     timeout: 2000
      //   });
      //   this.router.navigate(['login']);
      // }
    }
  }
}
