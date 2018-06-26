import { Component, OnInit } from '@angular/core';
import { ContentService } from '../services/ContentService';

import { Observable } from 'rxjs';

import { QuillEditorComponent } from 'ngx-quill/src/quill-editor.component';

import Quill from 'quill';

import 'rxjs/add/operator/map';

import { Content } from '../model/Content';
import { ContentType } from '../model/ContentType';
import { System } from '../model/System';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';

import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
  selector: 'app-edit-manual',
  templateUrl: './edit-manual.component.html',
  styleUrls: ['./edit-manual.component.css'],
  providers: [ContentService]
})
export class EditManualComponent implements OnInit {

  public content: Content = new Content();
  public id: string = "0";
  form: FormGroup;

  constructor(private contentService: ContentService, 
              private route: ActivatedRoute, 
              private router: Router,
              fb: FormBuilder) { 
                this.form = fb.group({
                  editor: ['']
                });
              }

  /**
   * Function of Update Manual
   */
  public updateManual(){
    this.mockContent();
    this.content.contentLiv = this.form.controls.editor.value;
    this.contentService.putContent(this.content).subscribe(
      (response: Content) => {
        this.goViewManual(response.id);
      }, error => {
        console.debug(error);
      }
    );
  }

  /**
   * MOCK  CONTENT
   */
  private mockContent(){
    this.content.active = "S";
    this.content.contentType = new ContentType();
    this.content.contentType.id = 2;
    this.content.system = new System();
    this.content.system.id = 2;
  }

  private goViewManual(id: number) {
    this.router.navigate(['view/manual/'+id]); 
  }

  patchValue() {
    this.form.controls['editor'].patchValue(`${this.form.controls['editor'].value} patched!`);
  }
  setControl() {
    this.form.setControl('editor', new FormControl('test - new Control'))
  }

  ngOnInit() {
    this.form
    .controls
    .editor
    .valueChanges.pipe(debounceTime(400),
      distinctUntilChanged()
    )
    .subscribe(data => {
      console.log('native fromControl value changes with debounce', data)
    });

    this.id = this.route.snapshot.paramMap.get('id');
    this.contentService.getContent(this.id, null, null, null, null, null).subscribe(
      (response: Content[]) => {
        this.content = response[0];
        this.form.controls['editor'].patchValue(`${this.form.controls['editor'].value} `+response[0].contentLiv);
      }, error => {
        console.debug(error);
      }
    );
  }

}
