import { Movie } from './movie';

//import { Movie } from 'src/app/models/movie';

export class Director{
    id:number;
    name:string;
    info:string;
    movies:Array<Movie>;

    constructor(id:number,  name:string, info:string, movies:Array<Movie>) {
        this.id=id;
        this.name=name;
        this.movies=movies;
    }
}