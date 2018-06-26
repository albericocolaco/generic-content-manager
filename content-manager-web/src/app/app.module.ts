import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { QuillModule } from 'ngx-quill';
import { CreateManualComponent } from './create-manual/create-manual.component';
import { ListManualComponent } from './list-manual/list-manual.component';
import { ViewManualComponent } from './view-manual/view-manual.component';
import { RouterModule, Routes } from '@angular/router';

import { HttpModule } from "@angular/http";
import { EditManualComponent } from './edit-manual/edit-manual.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


const appRoutes: Routes = [
  { path: 'create/manual', component: CreateManualComponent },
  { path: 'list/manual', component: ListManualComponent },
  { path: 'edit/manual/:id', component: EditManualComponent },
  { path: 'view/manual/:id', component: ViewManualComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    CreateManualComponent,
    ViewManualComponent,
    ListManualComponent,
    EditManualComponent
  ],
  imports: [
    BrowserModule,
    QuillModule,
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true}
    ),
    HttpModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}
