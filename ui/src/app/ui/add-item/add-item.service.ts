import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Book} from "../../book";

@Injectable({
  providedIn: 'root'
})
export class AddItemService {

  _url = '/api/addBook';
  constructor(private _http: HttpClient) { }

  addBook(book: Book) {
    return this._http.post<any>(this._url, book);
  }
}
