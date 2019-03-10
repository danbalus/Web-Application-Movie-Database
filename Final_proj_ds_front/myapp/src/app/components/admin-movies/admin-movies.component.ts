import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/models/movie';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-admin-movies',
  templateUrl: './admin-movies.component.html',
  styleUrls: ['./admin-movies.component.scss']
})
export class AdminMoviesComponent implements OnInit {


  movies:Array<Movie>=new Array<Movie>();


  constructor(private router:Router,private movieService:MovieService) { }

  ngOnInit() {
    this.getAllMovies();
  }
  getAllMovies(){
    this.movieService.getAllMovies().subscribe((movies)=>this.movies=movies);
  }

  deleteMovie(movie:Movie){
    this.movieService.deleteMovie(movie.id).subscribe((movie)=>this.getAllMovies());
  }

  addMovie(){
    this.router.navigateByUrl('admin/add-movie');
  }
  updateMovie(movie:Movie){
    this.router.navigate(['admin/edit-movie',{id:movie.id}]);
  }
  logout(){
    localStorage.removeItem('user');
  }
}
