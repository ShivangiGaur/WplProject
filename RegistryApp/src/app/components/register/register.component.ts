import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { AuthserviceService } from '../../services/authservice.service';
import { UserModel } from '../../models/usermodel';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Router } from '@angular/router';
import {RegisterService} from '../../services/register.service';
import { log } from 'util';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class RegisterComponent implements OnInit {
 
  user:UserModel = {
    firstName: '',
    lastName: '',
    email: '',
    password: '',   
    securityAnswer:'',
    securityQuestion:''
  };
  createdUser:any;
  constructor(
    private authService: AuthserviceService,
    private flashMessagesService: FlashMessagesService,
    private router: Router,
    private registerService:RegisterService
  ) { }

  ngOnInit() {

  }
  onSubmit({value, valid}:{value: UserModel, valid:boolean}){
    console.log(value);
    if(!valid){
      this.flashMessagesService.show('Please fill in all fields.',{
        cssClass:'alert-danger',
        timeout:'4000'
      });
      this.router.navigate(['register']);
    } else{
      this.registerService.registerUser(value).subscribe(
        result => {
          console.log(result);
          this.flashMessagesService.show('Registration successful! Please login now.',{
            cssClass:'alert-success',
            timeout:'4000'
          });
          this.router.navigate(['login']);
        },
        error=>{
          this.flashMessagesService.show('Registration failed due to: '+error,{
            cssClass:'alert-danger',
            timeout:'4000'
          });
          this.router.navigate(['register']);
        }
      );
    }
  }

}
