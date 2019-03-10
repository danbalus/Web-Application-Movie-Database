import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { Material } from './material/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { Material } from './material/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { UserComponent } from './components/user/user.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { UserPageComponent } from './components/user-page/user-page.component';
import { AdminMoviesComponent } from './components/admin-movies/admin-movies.component';
import { AddMovieComponent } from './components/add-movie/add-movie.component';
import { EditMovieComponent } from './components/edit-movie/edit-movie.component';
import { AdminUsersComponent } from './components/admin-users/admin-users.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { EditUserComponent } from './components/edit-user/edit-user.component';
import { RatedListComponent } from './components/rated-list/rated-list.component';
import { SearchMovieComponent } from './components/search-movie/search-movie.component'; 

@NgModule({
  declarations: [
    AppComponent,
    // HttpClientModule,
     LoginComponent,
     RegisterComponent,
     UserComponent,
     AdminPageComponent,
     UserPageComponent,
     AdminMoviesComponent,
     AddMovieComponent,
     EditMovieComponent,
     AdminUsersComponent,   
    AddUserComponent,
     EditUserComponent,
     RatedListComponent,
     SearchMovieComponent,   
      // FormsModule
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    Material,

    BrowserModule,
    AppRoutingModule,
    Material,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
