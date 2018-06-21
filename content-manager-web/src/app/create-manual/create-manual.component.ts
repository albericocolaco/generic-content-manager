import { Component, OnInit } from '@angular/core';
import { ContentService } from '../services/ContentService';

import { Http, URLSearchParams, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { Content } from '../model/Content';
import { ContentType } from '../model/ContentType';
import { System } from '../model/System';

@Component({
  selector: 'app-create-manual',
  templateUrl: './create-manual.component.html',
  styleUrls: ['./create-manual.component.css'],
  providers: [ContentService]
})
export class CreateManualComponent implements OnInit {
  content: Content;


  constructor(private contentService: ContentService) { }

  public createManual(){
    this.mockContent();
    this.contentService.putContent(this.content).subscribe(
          (response: Content) => {
              console.debug(response);
          }, error => {
            console.debug(error);
          }
      );
  }

  private mockContent(){
    this.content.active = "s";
    this.content.contentType.id = 1;
    this.content.system.id = 1;
  }

  ngOnInit() {
  }

}
