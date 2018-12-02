import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DeleteItemService {

  _urlItem = '/api/deleteLibraryItem';
  _urlFreeSpaceBook = '/api/freeSpace/book';
  _urlFreeSpaceDVD = '/api/freeSpace/dvd';
  constructor(private _http: HttpClient) { }

  deleteItem(isbn: number) {
    return this._http.delete(this._urlItem + '/' + isbn);
  }

  getFreeSpaceBook() {
    return this._http.get(this._urlFreeSpaceBook);
  }

  getFreeSpaceDVD() {
    return this._http.get(this._urlFreeSpaceDVD);
  }
}
