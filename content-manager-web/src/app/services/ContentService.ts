import { Injectable } from "@angular/core";
import { Http, URLSearchParams, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';


import { Content } from '../model/Content';
import { ContentType } from '../model/ContentType';
import { System } from '../model/System';

@Injectable()
export class ContentService {
    constructor(private http: Http) {
    }

    putContent(content: Content): Observable<Content> {
        const headers: Headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.put('/api/content/', content,{headers: headers}).map(
            (response: Response) => {
                return response.json() as Content;
            }
        );
    }

}