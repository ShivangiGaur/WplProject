import { Injectable } from '@angular/core';
import { UserModel } from '../models/usermodel';
import {Http, Response} from '@angular/http';
import {Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Rx';
@Injectable()
export class AuthserviceService {

  loggedInUser: UserModel;
  loggedInUserEmail:String;

  constructor(public http:Http) {

  }
  
  authenticateUser(userEmail:string,userPassword:string): Observable<any>{

    let options = new RequestOptions({ 
      params:{
      'email': userEmail,
      'password': userPassword
      }
    });
    return this.http.get('http://localhost:8080/Wpl/user/authenticateuser/',options)
      .map(res => {
        return res;
      })
      .catch(this.handleError);
  }

  authenticateAdmin(userEmail:string,userPassword:string): Observable<any>{
    
        let options = new RequestOptions({ 
          params:{
          'email': userEmail,
          'password': userPassword
          }
        });
        return this.http.get('http://localhost:8080/Wpl/user/authenticateadmin/',options)
          .map(res => {
            return res;
          })
          .catch(this.handleError);
      }

  fetchUser(email:String): Observable<any>{
    let options = new RequestOptions({ 
      params:{
      'email': email
      }
    });
    return this.http.get('http://localhost:8080/Wpl/user/getuser/',options)
      .map(res => {
        console.log(res);
        return res;
      })
      .catch(this.handleError);
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw('Invalid Credentials. Please try again.');
  }

}
