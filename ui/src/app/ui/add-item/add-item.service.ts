import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Book} from "../../book";
import {DVD} from "../../dvd";

@Injectable({
  providedIn: 'root'
})
export class AddItemService {

  _urlBook = '/api/addBook';
  _urlDVD = '/api/addDVD';
  _urlFreeSpaceBook = '/api/freeSpace/book';
  _urlFreeSpaceDVD = '/api/freeSpace/dvd';

  constructor(private _http: HttpClient) { }

  addBook(book: Book) {
    //returns a post request made to the url
    // with the book object
    return this._http.post<any>(this._urlBook, book);
  }

  addDVD(dvd: DVD) {
    return this._http.post<any>(this._urlDVD, dvd);
  }

  getFreeSpaceBook() {
    return this._http.get(this._urlFreeSpaceBook);
  }

  getFreeSpaceDVD() {
    return this._http.get(this._urlFreeSpaceDVD);
  }
}
