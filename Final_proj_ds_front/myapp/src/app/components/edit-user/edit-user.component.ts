import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})
export class EditUserComponent implements OnInit {

  addForm:FormGroup;
  user:User;
  oldUser:User;

  constructor(private fb:FormBuilder, private userService:UserService, private router:Router,
      private activatedRoute:ActivatedRoute) { }
 
  ngOnInit() {
    this.activatedRoute.params.subscribe(params=>{
      const id=params.id;
      if(id){
      this.userService.getUserById(id).subscribe(user=>{this.user=user;
      this.createForm(this.user);
      });
      }
    });
  }

  createForm(user:User) {
    this.addForm = this.fb.group({
      id: [ user.id,[ Validators.required]],
      email: [user.email , [Validators.required]],
      password: [user.password , [Validators.required]],
      name: [user.name , [Validators.required]],
      typeAccount: [user.typeAccount , [Validators.required]],
      age: [user.age , [Validators.required]],
    });
  }

  update(){
    this.userService.getUserById(this.addForm.value.id).subscribe((user)=>this.oldUser=user);
    //Array<Actor> actors = oldUser.actors;
    //Array<Dicrectors> directors = oldUser.directors;
    let uuser: any;
    if(this.oldUser.ratings == null){
      let user:User=new User(this.user.id,this.addForm.value.email, this.addForm.value.password,this.addForm.value.name,this.addForm.value.typeAccount,this.addForm.value.age,null);
      uuser = user;

    }else{
    let user:User=new User(this.user.id,this.addForm.value.email, this.addForm.value.password,this.addForm.value.name,this.addForm.value.typeAccount,this.addForm.value.age,this.oldUser.ratings);
    uuser = user;
    }
    this.userService.updateUser(uuser)
    .subscribe(
      (response)=>{this.router.navigateByUrl('admin/users');},
      (error)=>console.log('incorrect update')
    );
  }
}
