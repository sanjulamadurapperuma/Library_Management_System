import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DeleteItemService {

  _urlItem = '/api/deleteLibraryItem';
  constructor(private _http: HttpClient) { }

  deleteItem(isbn: number) {
    return this._http.delete(this._urlItem + '/' + isbn);
  }
}
