import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ContentService } from '../services/ContentService';

import 'rxjs/add/operator/map';

import { Content } from '../model/Content';

@Component({
  selector: 'app-list-manual',
  templateUrl: './list-manual.component.html',
  styleUrls: ['./list-manual.component.css'],
  providers: [ContentService]
})
export class ListManualComponent implements OnInit {

  public contents: Content[];
  constructor(private contentService: ContentService) { }

  public removeManual(idContent){
    this.contentService.removeContent(idContent).subscribe(
      (response: any) => {
        console.debug(response);
      }, error => {
        console.debug(error);
      }
    );
  }

  ngOnInit() {
    this.contentService.getContent(null, null, null, null, null, null).subscribe(
      (response: Content[]) => {
        this.contents = response;
      }, error => {
        console.debug(error);
      }
    );
  }

}
