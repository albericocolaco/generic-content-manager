import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { QuillModule } from 'ngx-quill';
import { CreateManualComponent } from './create-manual/create-manual.component';
import { RouterModule, Routes } from '@angular/router';
import { ViewManualComponent } from './view-manual/view-manual.component';
import { HttpClientModule } from '@angular/common/http';

const appRoutes: Routes = [
  { path: 'create/manual', component: CreateManualComponent },
  { path: 'view/manual/:id', component: ViewManualComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    CreateManualComponent,
    ViewManualComponent
  ],
  imports: [
    BrowserModule,
    QuillModule,
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true}
    ),
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}
