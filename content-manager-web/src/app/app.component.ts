import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'app';
  content: string;

  onContentChanged(event){
    this.content = event.html;
  }

  onSelectionChanged(event){
    console.log(event);
  }
}
