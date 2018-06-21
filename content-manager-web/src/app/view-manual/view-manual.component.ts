import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-manual',
  templateUrl: './view-manual.component.html',
  styleUrls: ['./view-manual.component.css']
})
export class ViewManualComponent implements OnInit {
 
  public id: string;
  constructor(private route: ActivatedRoute) {
  }
  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
  }

}
