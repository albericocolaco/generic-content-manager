import { ContentType } from "./ContentType";
import { System } from "./System";


export class Content {
    id: number;
    active: string;
    contentLiv: string;
    dateCreate: Date;
    dateModify: Date;
    contentType: ContentType;
    system: System;
}