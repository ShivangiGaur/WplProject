import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { NotAPageComponent } from './components/not-a-page/not-a-page.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { ViewregistryComponent } from './components/viewregistry/viewregistry.component';
import { SearchregistryComponent } from './components/searchregistry/searchregistry.component';
import { CreateregistryComponent } from './components/createregistry/createregistry.component';

import { FlashMessagesModule} from 'angular2-flash-messages';

import {RouterModule, Routes} from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpModule} from '@angular/http'
import {AuthserviceService} from './services/authservice.service';
import {DataserviceService} from './services/dataservice.service';
import {RegistryService} from './services/registry.service';
import {RegisterService} from './services/register.service';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

//routes for this application
const appRoutes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'about-us',
    component: AboutusComponent
  },
  {
    path: 'create-registry/:regName',
    component: CreateregistryComponent
  },
  {
    path: 'view-registry',
    component: ViewregistryComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    AboutusComponent,
    NotAPageComponent,
    UserprofileComponent,
    ViewregistryComponent,
    SearchregistryComponent,
    CreateregistryComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    FormsModule, 
    ReactiveFormsModule,
    FlashMessagesModule,
    HttpModule
  ],
  providers: [AuthserviceService, DataserviceService, RegistryService, RegisterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
