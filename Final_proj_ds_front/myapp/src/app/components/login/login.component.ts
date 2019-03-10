import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { User } from 'src/app/models/user';
import { HttpResponse } from '@angular/common/http';
import { Credentials } from 'src/app/models/credentials';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm:FormGroup;
  user:User;
  errorMessage:string="";

  constructor(private formBuilder:FormBuilder, private router:Router, private loginService:LoginService) { }

  ngOnInit() {
    this.createForm();
  }

  createForm(){
    this.loginForm=this.formBuilder.group({
      email:['',[Validators.required]],
      password:['',Validators.required]
    })
  }

  login(){
      let credentials:Credentials=new Credentials(this.loginForm.value.email, this.loginForm.value.password);
      this.loginService.submitLogin(credentials)//this.loginForm.value.email,this.loginForm.value.password)
                  .subscribe(
                    ( response) => {
                                    this.user=response;
                                   if(this.user.typeAccount===0){
                                      localStorage.setItem('admin',this.user.id.toString());
                                      this.router.navigateByUrl('admin');
                                      console.log("succs tata");
                                    }
                                   else{
                                        localStorage.setItem('user',this.user.id.toString());
                                       this.router.navigateByUrl('user');
                                       console.log('user tata');
                                   }
                                    },
                    ( error )=> { this.errorMessage = "Incorrect email or password!"}
    );
  }

  register(){
    this.router.navigateByUrl('register');
  }

}
