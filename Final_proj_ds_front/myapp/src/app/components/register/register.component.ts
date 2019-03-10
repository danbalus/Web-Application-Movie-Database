import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { RegisterService } from 'src/app/services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;

  constructor(private formBuilder:FormBuilder, private router:Router, private registerService:RegisterService) { }

  ngOnInit() {
    this.createForm();
  }

  createForm(){
    this.registerForm=this.formBuilder.group({
      name:['',Validators.required],
      email:['',[Validators.email,Validators.required]],
      password:['',Validators.required],
      age:[null,Validators.required]
      //age:[,Validators.,Validators.required]
    })
  }

  register(){
    let user:User=new User(null,this.registerForm.value.email, this.registerForm.value.password,this.registerForm.value.name,1,this.registerForm.value.age,null);
    this.registerService.register(user)
        .subscribe(
          (response)=>{this.router.navigateByUrl('');},
          (error)=>console.log('incorrect register')
        );
  }

  backToLogin(){
    this.router.navigateByUrl('');
  }

}
  