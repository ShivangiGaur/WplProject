import { Injectable } from '@angular/core';
import { UserModel } from '../models/usermodel';
import {Observable} from 'rxjs/Observable';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
@Injectable()
export class AuthserviceService {

  users: UserModel[];
  isLoggedIn:boolean = false;
  loggedInUser: UserModel = null;

  constructor(public http:Http) {
    this.users = [
      {
        email: 'r@s.com',
        password: '1234',
        firstName: 'Rahul',
        lastName: 'Sengupta',
        securityQuestion: '',
        securityAnswer: ''
      },
      {
        email: 'rishika@s.com',
        password: '1234',
        firstName: 'Rishika',
        lastName: 'Sinha',
        securityQuestion: '',
        securityAnswer: ''
      }
    ];
  }

  authenticateUser(userEmail:string,userPassword:string): UserModel{
    for(let i=0;i<this.users.length;i++){
      let email = this.users[i].email;
      let password = this.users[i].password;
      if(userEmail == email && userPassword == password){
        return this.users[i];   
      }
    }
    return null;
  }
  
  addUser(user:UserModel){
    let result:number = this.users.unshift(user);    
    console.log(this.users);
    return result;
  }
  
  getState(){
    return {
      'isLoggedIn': this.isLoggedIn,
      'user':this.loggedInUser
    };
  }

}
