import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Reserve} from "../../reserve";

@Injectable({
  providedIn: 'root'
})
export class ReserveItemService {

  _urlItem = '/api/reserveLibraryItem';
  constructor(private _http: HttpClient) { }

  borrowItem(reserve: Reserve) {
    return this._http.post<any>(this._urlItem, reserve);
  }
}
