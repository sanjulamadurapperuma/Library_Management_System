import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class GenerateReportService {

  _urlGenerateRep = '/api/generateReport';
  _urlSearch = '/api/searchBorrowItem';
  constructor(private _http: HttpClient) { }

  generateReport() {
    return this._http.get(this._urlGenerateRep);
  }

  searchBorrowedItem(isbn: number) {
    return this._http.get(this._urlSearch + '/' + isbn);
  }
}
