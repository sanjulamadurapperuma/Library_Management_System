import {Component, EventEmitter, OnInit} from '@angular/core';
import {Book} from "../../book";
import {DVD} from "../../dvd";
import {ReturnItemService} from "./return-item.service";


@Component({
  selector: 'app-return-item',
  templateUrl: './return-item.component.html',
  styleUrls: ['./return-item.component.css']
})
export class ReturnItemComponent implements OnInit {
  successMsg: string = null;
  isSuccess: boolean;
  item: any;
  book: Book;
  dvd: DVD;

  constructor(private _returnItemService: ReturnItemService) { }

  ngOnInit() {
  }

  returnItem(frm){
    this._returnItemService.returnItem(frm.value["ISBN"]).subscribe(
      data => {
        if ("Book" != data.toString() || "DVD" != data.toString() ) {
          this.successMsg = data.toString();
          this.isSuccess = false;
          frm.resetForm();
        } else {
          this.successMsg = "Successfully returned a " + data + " item";
          this.isSuccess = true;
          frm.resetForm();
        }
      },
      error => console.log('Error', error)
    );
  }
}
