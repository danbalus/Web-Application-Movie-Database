import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Movie } from 'src/app/models/movie';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.scss']
})
export class AddMovieComponent implements OnInit {


  addForm:FormGroup;
  movie:Movie;
  oldMovie:Movie;

  constructor(private fb:FormBuilder, private movieService:MovieService, private router:Router,
      private activatedRoute:ActivatedRoute) { }
 
  ngOnInit() {
    //this.activatedRoute.params.subscribe(params=>{
    //  const id=params.id;
    //  if(id){
    //  this.movieService.getMovieById(id).subscribe(movie=>{this.movie=movie;
      this.createForm();
     // });
    //  }
    //});
  }

  createForm() {
    this.addForm = this.fb.group({
      id: [ "",[ Validators.required]],
      name: ["" , [Validators.required]],
      genre: ["" , [Validators.required]],
      title: ["" , [Validators.required]],
      rating: ["" , [Validators.required]],

    });
  }

  update(){
    //this.movieService.getMovieById(this.addForm.value.id).subscribe((movie)=>this.oldMovie=movie);
    //Array<Actor> actors = oldMovie.actors;
    //Array<Dicrectors> directors = oldMovie.directors;
    let moviee: any;
  //  if(this.oldMovie.actors == null || this.oldMovie.directors == null){
  //    let movie:Movie=new Movie(this.movie.id,this.addForm.value.name, this.addForm.value.genre,this.addForm.value.title,this.movie.rating,null,null);
    //  moviee = movie;

    //}else{
    let movie:Movie=new Movie(this.addForm.value.id,this.addForm.value.name, this.addForm.value.genre,this.addForm.value.title,this.addForm.value.rating,null,null);
   // moviee = movie;
    //}
    this.movieService.addMovie(movie)
    .subscribe(
      (response)=>{this.router.navigateByUrl('admin/movies'); console.log(response.title)},
      (error)=>console.log('incorrect update')
    );
  }
}
