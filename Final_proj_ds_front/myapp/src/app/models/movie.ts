import { Actor } from 'src/app/models/actor';
import { Director } from 'src/app/models/director';

export class Movie{
id:number;
    name:string;
    genre:string;
    title:string;
    rating:number;
    actors:Array<Actor>;
    directors:Array<Director>;

    constructor(id:number,  name:string, genre:string, title:string, rating:number, actors:Array<Actor>, directors:Array<Director>) {
        this.id=id;
        this.title=title;
        this.genre=genre;
        this.name=name;
        this.rating=rating;
        this.actors=actors;
        this.directors=directors;
    }
}