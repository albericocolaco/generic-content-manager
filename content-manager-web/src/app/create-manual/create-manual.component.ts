import { Component, OnInit } from '@angular/core';
import { ContentService } from '../services/ContentService';

import 'rxjs/add/operator/map';

import { Content } from '../model/Content';
import { ContentType } from '../model/ContentType';
import { System } from '../model/System';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-manual',
  templateUrl: './create-manual.component.html',
  styleUrls: ['./create-manual.component.css'],
  providers: [ContentService]
})
export class CreateManualComponent implements OnInit {
  content: Content = new Content();


  constructor(private contentService: ContentService, private router: Router) { }

  /**
   * Function of Create Manual
   */
  public createManual(){
    this.mockContent();
    this.contentService.postContent(this.content).subscribe(
      (response: Content) => {
        this.goViewManual(response.id);
      }, error => {
        console.debug(error);
      }
    );
  }

  /**
   * Function of Component Text Area
   * @param event 
   */
  onContentChanged(event){
    this.content.contentLiv = event.html;
  }

  /**
   * Function of Component Text Area
   * @param event 
   */
  onSelectionChanged(event){
  }

  /**
   * MOCK  CONTENT
   */
  private mockContent(){
    this.content.active = "S";
    this.content.contentType = new ContentType();
    this.content.contentType.id = 1;
    this.content.system = new System();
    this.content.system.id = 1;
  }

  private goViewManual(id: number) {
    this.router.navigate(['view/manual/'+id]); 
  }

  ngOnInit() {
  }

}
