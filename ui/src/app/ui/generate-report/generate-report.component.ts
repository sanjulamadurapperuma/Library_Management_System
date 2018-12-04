import { Component, OnInit } from '@angular/core';
import {GenerateReportService} from "./generate-report.service";

@Component({
  selector: 'app-generate-report',
  templateUrl: './generate-report.component.html',
  styleUrls: ['./generate-report.component.css']
})
export class GenerateReportComponent implements OnInit {
  items: any;
  itemAvailable: boolean = null;
  errorMsg: String = null;
  searchLibItem: any;

  constructor(private _generateReportService: GenerateReportService) {
    this.displayItems();
  }

  ngOnInit() {
  }

  displayItems() {
    this._generateReportService.generateReport().subscribe(
      data => {
        this.items = data;
      },
      error => console.log('Error', error)
    );
  }

  searchBorrowedItem(formSearch) {
    this._generateReportService.searchBorrowedItem(formSearch.value["ISBN"]).subscribe(
      data => {
        if ("notAvailable" == data.toString()) {
          this.errorMsg = "This item does not exist in the library";
          this.itemAvailable = false;
        } else {
            this.searchLibItem = data;
            this.itemAvailable = true;
        }
      },
      error => {
        console.log('Error', error);
      }
    );
  }
}

