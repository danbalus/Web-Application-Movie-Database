import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-users',
  templateUrl: './admin-users.component.html',
  styleUrls: ['./admin-users.component.scss']
})
export class AdminUsersComponent implements OnInit {
  

  movies:Array<User>=new Array<User>();


  constructor(private router:Router,private userService:UserService) { }

  ngOnInit() {
    this.getAllUsers();
  }
  getAllUsers(){
    this.userService.getAllUsers().subscribe((movies)=>this.movies=movies);
  }

  deleteUser(user:User){
    this.userService.deleteUser(user.id).subscribe((user)=>this.getAllUsers());
  }

  addUser(){
    this.router.navigateByUrl('admin/add-user');
  }
  updateUser(user:User){
    this.router.navigate(['admin/edit-user',{id:user.id}]);
  }

}
