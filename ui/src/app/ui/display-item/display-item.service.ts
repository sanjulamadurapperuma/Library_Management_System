import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class DisplayItemService {

  _urlDisplay = '/api/display';
  _urlSearch = '/api/searchItem';
  constructor(private _http: HttpClient) { }

  returnDetails() {
    //Passing get request to back-end
    return this._http.get(this._urlDisplay);
  }

  searchItem(isbn: number) {
    return this._http.get(this._urlSearch + '/' + isbn);
  }
}
