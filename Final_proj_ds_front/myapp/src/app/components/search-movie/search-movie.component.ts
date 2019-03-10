import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/models/movie';
import { Router } from '@angular/router';
import { MovieService } from 'src/app/services/movie.service';
import { Actor } from 'src/app/models/actor';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user';
declare var jquery:any;
declare var $ :any;

@Component({
  selector: 'app-search-movie',
  templateUrl: './search-movie.component.html',
  styleUrls: ['./search-movie.component.scss']
})
export class SearchMovieComponent implements OnInit {
  // title = 'abgular 4 with jquery';

  // toggleTitle(){
  //   $('.title').slideToggle(); //
  // }
  
  movies:Array<Movie>=new Array<Movie>();
  user:User;

  constructor(private router:Router,private movieService:MovieService, private userService:UserService) { }

  ngOnInit() {
    this.getAllMovies();
  }
  getAllMovies(){
    this.movieService.getAllMovies().subscribe((movies)=>this.movies=movies);
  }

  searchInForm(){
    $(document).ready(function(){
      $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function() {
          $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
      });
    });
  }

  objToString (actors:Array<Actor>) {
    var str = '';

    actors.forEach(function (actor) {
      str = str + actor.name + " ";
     // console.log("str--> " + str);
  });

    // for (var actor in actors) {
    //         str += actor.name + '::' + any[p] + '\n';

    // }
    //return JSON.stringify(any);
   // return String(any);
  // console.log("strfin--> " + str);
   return str;
}
okToRate(x : number){
  if(x === 1){
    return true;
  }
  return false;
  
}
updateRating(){
  var valuee: string;
  var nameMovie: string;
// $(document).ready(function(){
//   $("#customRange3").on("keyup", function() {
//      valuee = $(this).val();
//   });
// });
valuee = (<HTMLInputElement>document.getElementById("customRange3")).value;

//console.log("id: " + id);
console.log("value: " + valuee);
this.userService.getUserById(Number(localStorage.getItem('user'))).subscribe((user)=>{this.user=user;
  console.log("aa: " + this.user.name);

  nameMovie = (<HTMLInputElement>document.getElementById("movie_name")).value;
  console.log("movie name: " + nameMovie);
this.movieService.rateMovie(Number(valuee), user.id, nameMovie);


});

}
logout(){
  localStorage.removeItem('user');
}
}
