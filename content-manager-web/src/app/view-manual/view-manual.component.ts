import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ContentService } from '../services/ContentService';

import 'rxjs/add/operator/map';

import { Content } from '../model/Content';

@Component({
  selector: 'app-view-manual',
  templateUrl: './view-manual.component.html',
  styleUrls: ['./view-manual.component.css'],
  providers: [ContentService]
})
export class ViewManualComponent implements OnInit {
 
  public id: string;
  public content: Content;
  constructor(private route: ActivatedRoute, private contentService: ContentService) {
  }
  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.contentService.getContent(this.id, null, null, null, null, null).subscribe(
      (response: Content) => {
        this.content = response[0];
      }, error => {
        console.debug(error);
      }
    );
  }

}
