import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';
import { Credentials } from '../models/credentials';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl="http://localhost:8080/login";
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'}); 
  constructor(private http:HttpClient) { }

 // submitLogin(id:number, password:string): Observable<User>{
 //   return this.http.get<User>(this.loginUrl+"/id/"+id+"pw/"+password, {headers:this.headers});
 // }
 submitLogin(credentials:Credentials): Observable<User>{
  return this.http.post<any>(this.loginUrl,credentials,{headers:this.headers});
}
}
