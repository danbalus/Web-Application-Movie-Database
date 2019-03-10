import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {


  addForm:FormGroup;
  user:User;
  oldMovie:User;

  constructor(private fb:FormBuilder, private userService:UserService, private router:Router,
      private activatedRoute:ActivatedRoute) { }
 
  ngOnInit() {
    //this.activatedRoute.params.subscribe(params=>{
    //  const id=params.id;
    //  if(id){
    //  this.userService.getMovieById(id).subscribe(user=>{this.user=user;
      this.createForm();
     // });
    //  }
    //});
  }

  createForm() {
    this.addForm = this.fb.group({
      id: ["",[ Validators.required]],
      email: ["", [Validators.required]],
      password: ["", [Validators.required]],
      name: ["", [Validators.required]],
      typeAccount: ["", [Validators.required]],
      age: ["", [Validators.required]],

    });
  }

  update(){
    //this.userService.getMovieById(this.addForm.value.id).subscribe((user)=>this.oldMovie=user);
    //Array<Actor> actors = oldMovie.actors;
    //Array<Dicrectors> directors = oldMovie.directors;
    let uuser: any;
  //  if(this.oldMovie.actors == null || this.oldMovie.directors == null){
  //    let user:User=new User(this.user.id,this.addForm.value.name, this.addForm.value.genre,this.addForm.value.title,this.user.rating,null,null);
    //  uuser = user;

    //}else{
    let user:User=new User(this.addForm.value.id,this.addForm.value.email, this.addForm.value.password,this.addForm.value.name,this.addForm.value.typeAccount,this.addForm.value.age,null);
   // uuser = user;
    //}
    this.userService.addUser(user)
    .subscribe(
      (response)=>{this.router.navigateByUrl('admin/users');},
      (error)=>console.log('incorrect update')
    );
  }
}
