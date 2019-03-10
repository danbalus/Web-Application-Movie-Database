import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Movie } from 'src/app/models/movie';
import { MovieService } from 'src/app/services/movie.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Actor } from 'src/app/models/actor';

@Component({
  selector: 'app-edit-movie',
  templateUrl: './edit-movie.component.html',
  styleUrls: ['./edit-movie.component.scss']
})
export class EditMovieComponent implements OnInit {

  addForm:FormGroup;
  movie:Movie;
  oldMovie:Movie;

  constructor(private fb:FormBuilder, private movieService:MovieService, private router:Router,
      private activatedRoute:ActivatedRoute) { }
 
  ngOnInit() {
    this.activatedRoute.params.subscribe(params=>{
      const id=params.id;
      if(id){
      this.movieService.getMovieById(id).subscribe(movie=>{this.movie=movie;
      this.createForm(this.movie);
      });
      }
    });
  }

  createForm(movie:Movie) {
    this.addForm = this.fb.group({
      id: [ movie.id,[ Validators.required]],
      name: [movie.name , [Validators.required]],
      genre: [movie.genre , [Validators.required]],
      title: [movie.title , [Validators.required]],
      rating: [movie.rating , [Validators.required]],

    });
  }

  update(){
    this.movieService.getMovieById(this.addForm.value.id).subscribe((movie)=>this.oldMovie=movie);
    //Array<Actor> actors = oldMovie.actors;
    //Array<Dicrectors> directors = oldMovie.directors;
    let moviee: any;
    if(this.oldMovie.actors == null || this.oldMovie.directors == null){
      let movie:Movie=new Movie(this.movie.id,this.addForm.value.name, this.addForm.value.genre,this.addForm.value.title,this.movie.rating,null,null);
      moviee = movie;

    }else{
    let movie:Movie=new Movie(this.movie.id,this.addForm.value.name, this.addForm.value.genre,this.addForm.value.title,this.movie.rating,this.oldMovie.actors,this.oldMovie.directors);
    moviee = movie;
    }
    this.movieService.updateMovie(moviee)
    .subscribe(
      (response)=>{this.router.navigateByUrl('admin/movies');},
      (error)=>console.log('incorrect update')
    );
  }

}
