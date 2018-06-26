import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'app';
  content: string;
  linkStyle: string[];

  eventSetActive(position){
    let count = 0;
    this.linkStyle.forEach(element => {
      if(count === position){
        element = 'active';
      } else {
        element = '';
      }
      count++;
    });
    
  }

  onContentChanged(event){
    this.content = event.html;
  }

  onSelectionChanged(event){
    console.log(event);
  }
}
