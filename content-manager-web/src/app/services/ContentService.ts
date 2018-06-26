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

    postContent(content: Content): Observable<Content> {
        const headers: Headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post('/api/content/', content,{headers: headers}).map(
            (response: Response) => {
                return response.json() as Content;
            }
        );
    }

    getContent(idContent: string, dateCreate: Date, dateModify: Date, 
        active: string, contentTypeId: number, systemId: number): Observable<Content> {
        const headers: Headers = new Headers();
        headers.append('Content-Type', 'application/json');

        const urlSearchParams = new URLSearchParams();
        if(idContent){
            urlSearchParams.append('id', idContent.toString());
        }
        if(dateCreate){
            urlSearchParams.append('dateCreate', dateCreate.toString());
        }
        if(dateModify){
            urlSearchParams.append('dateModify', dateModify.toString());
        }
        if(active){
            urlSearchParams.append('active', active.toString());
        }
        if(contentTypeId){
            urlSearchParams.append('contentTypeId', contentTypeId.toString());
        }
        if(systemId){
            urlSearchParams.append('systemId', systemId.toString());
        }
        const params = urlSearchParams.toString();

        return this.http.get('/api/content/',{headers: headers, params: params }).map(
            (response: Response) => {
                return response.json() as Content;
            }
        );
    }

}