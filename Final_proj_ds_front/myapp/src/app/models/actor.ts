import { Movie } from 'src/app/models/movie';

export class Actor{
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