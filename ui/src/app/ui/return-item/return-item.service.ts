import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class ReturnItemService {

  _urlItem = '/api/returnLibraryItem';
  _urlFee = '/api/calculateReturnFee';
  constructor(private _http: HttpClient) { }

  returnItem(isbn: number) {
    return this._http.delete(this._urlItem + '/' + isbn);
  }

  calculateFee(isbn: number){
    return this._http.get(this._urlFee);
  }
}
