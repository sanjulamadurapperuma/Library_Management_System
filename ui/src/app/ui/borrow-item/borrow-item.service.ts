import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Borrow} from "../../borrow";


@Injectable({
  providedIn: 'root'
})
export class BorrowItemService {

  _urlItem = '/api/borrowLibraryItem';
  constructor(private _http: HttpClient) { }

  borrowItem(borrow: Borrow) {
    return this._http.post<any>(this._urlItem, borrow);
  }

}
