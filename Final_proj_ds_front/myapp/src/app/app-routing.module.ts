import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { Material } from './material/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { UserPageComponent } from './components/user-page/user-page.component';
import { AdminMoviesComponent } from './components/admin-movies/admin-movies.component';
import {AddMovieComponent} from './components/add-movie/add-movie.component';
import {EditMovieComponent} from './components/edit-movie/edit-movie.component';
import { AdminUsersComponent } from './components/admin-users/admin-users.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { EditUserComponent } from './components/edit-user/edit-user.component';
import { RatedListComponent } from './components/rated-list/rated-list.component';
import { SearchMovieComponent } from './components/search-movie/search-movie.component';
import { AuthGuard } from './auth.guard';
import { AuthuGuard } from './authu.guard';
const routes: Routes = [
  {path: '',
    component: LoginComponent
  },
  {
    path:'register',
    component: RegisterComponent
  },
  {
    path:'admin',
    component: AdminPageComponent
  },
  {
    path:'user',
    component: UserPageComponent
  },
  {
    path:'admin/add-movie',
    component: AddMovieComponent,
    canActivate: [AuthGuard]
  },
  {
    path:'admin/edit-movie',
    component: EditMovieComponent,
    canActivate: [AuthGuard]
  },
  {
    path:'admin/users',
    component: AdminUsersComponent,
    canActivate: [AuthGuard]
  }
  ,
  {
    path:'admin/movies',
    component: AdminMoviesComponent,
    canActivate: [AuthGuard]
  },
  {
    path:'admin/add-user',
    component: AddUserComponent,
    //canActivate: [AuthGuard]
  },
  {
    path:'admin/edit-user',
    component: EditUserComponent,
    //canActivate: [AuthGuard]
  }
  // ,
  // {
  //   path:'admin/sendMail',
  //   component: 
  //   //canActivate: [AuthGuard]
  // }
  ,
  {
    path:'user/rated',
    component: RatedListComponent,
    canActivate: [AuthuGuard]
  }
  ,
  {
    path:'user/searchMovie',
    component: SearchMovieComponent,
    canActivate: [AuthuGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
