import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../models/movie';


@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private moviesUrl = "http://localhost:8080/movies";
  private mailUrl   = "http://localhost:8080/movies/sendMail";
  
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'}); 

  constructor(private http:HttpClient) { }

  getAllMovies():Observable<Array<Movie>>{
    return this.http.get<Array<Movie>>(this.moviesUrl,{headers:this.headers});
  }
  addMovie(Movie:Movie):Observable<Movie>{
    return this.http.post<Movie>(this.moviesUrl,Movie,{headers:this.headers});
  }
  deleteMovie(id:number):Observable<Movie>{
    return this.http.delete<Movie>(this.moviesUrl+'/'+id,{headers:this.headers});
  }
  getMovieById(id:number):Observable<Movie>{
    return this.http.get<Movie>(this.moviesUrl+'/'+id,{headers:this.headers});
  }
  updateMovie(Movie:Movie):Observable<Movie>{
    return this.http.put<Movie>(this.moviesUrl,Movie,{headers:this.headers});
  }
  sendNotification(email:string, content:string):Observable<any>{
    return this.http.post<any>(this.mailUrl+'/'+email+'/'+content,{headers:this.headers});
  }

  getMoviesByRating(rating:number):Observable<Array<Movie>>{
    return this.http.get<Array<Movie>>(this.moviesUrl + '/search/rating/' + rating ,{headers:this.headers});
  }

  rateMovie(rating:number, userId:number, movieName:string):Observable<Movie>{
    return this.http.put<any>(this.moviesUrl + '/user/' + userId + '/movieName/' + movieName + '/rating/' + rating ,Movie,{headers:this.headers});
  }
  
  // getMoviesByRatingg(rating:number):Observable<any>{
  //   let userId=localStorage.getItem('movie');
  //   return this.http.post<any>(this.moviesUrl+'/search/rating/'+rating+'/'+userId,{headers:this.headers});
  // }
  // ownBorrowing():Observable<Array<Borrowing>>{
  //   let userId=localStorage.getItem('user');
  //   return this.http.get<Array<Borrowing>>(this.borrowingsUrl+'/own/'+userId);
  // }

  // returnMovie(id:number,result:number):Observable<Borrowing>{
  //   return this.http.post<any>(this.borrowingsUrl+'/return/'+id+'/'+result,{headers:this.headers});
  // }
}
