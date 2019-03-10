export class User{
    id:number;
    email: string;
    password: string;
    name: string;
    typeAccount: number;
    age: number;
    ratings:Map<number,number>;
    

    constructor(id:number, email:string, password:string, name:string, typeAccount:number, age:number, ratings:Map<number,number>) {
        this.id=id;
        this.email=email;
        this.password=password;
        this.name=name;
        this.typeAccount=typeAccount;
        this.age = age;
        this.ratings = ratings;
    }


}