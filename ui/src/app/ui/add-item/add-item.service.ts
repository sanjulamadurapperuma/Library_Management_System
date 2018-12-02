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
  _urlFreeSpaceBook = '/api/freeSpaceBook';
  _urlFreeSpaceDVD = '/api/freeSpaceDVD';
  constructor(private _http: HttpClient) { }

  addBook(book: Book) {
    return this._http.post<any>(this._urlBook, book);
  }

  addDVD(dvd: DVD) {
    return this._http.post<any>(this._urlDVD, dvd);
  }

  getFreeSpace() {
    return this._http.post<any>(this._urlFreeSpaceBook, book);
  }
}
