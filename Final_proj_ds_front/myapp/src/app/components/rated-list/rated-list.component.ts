import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-rated-list',
  templateUrl: './rated-list.component.html',
  styleUrls: ['./rated-list.component.scss']
})
export class RatedListComponent implements OnInit {

 
  user:User;
  ratings:Map<Number,Number> ;

  constructor(private fb:FormBuilder, private userService:UserService, private router:Router,
              private activatedRoute:ActivatedRoute) { }

  ngOnInit(){
    this.getUser();
  
  }
  logout(){
    localStorage.removeItem('user');
  }
 getUser(){
        this.userService.getUserById(Number(localStorage.getItem('user'))).subscribe((user)=>{this.user=user;
         
        console.log("aa: " + this.user.name);
        this.ratings = this.user.ratings;
        console.log("bb: " + this.ratings);
      });
      }
}