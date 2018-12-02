import {Component, EventEmitter, OnInit} from '@angular/core';
import {Book} from "../../book";
import {DVD} from "../../dvd";
import {BorrowItemService} from "./borrow-item.service";

@Component({
  selector: 'app-borrow-item',
  templateUrl: './borrow-item.component.html',
  styleUrls: ['./borrow-item.component.css']
})
export class BorrowItemComponent implements OnInit {
  successMsg: string = null;
  isSuccess: boolean;
  item: any;
  options: boolean;
  book: Book;
  dvd: DVD;

  constructor(private _borrowItemService: BorrowItemService) { }

  ngOnInit() {
  }

  borrowItem(frm){
    this._borrowItemService.borrowItem(frm.value["ISBN"]).subscribe(
      data => {
        if ("Book" != data.toString() || "DVD" != data.toString() ) {
          this.successMsg = data.toString();
          this.isSuccess = false;
          frm.resetForm();
        } else {
          this.successMsg = "Successfully borrowed a " + data + " item";
          this.isSuccess = true;
          frm.resetForm();
        }
      },
      error => console.log('Error', error)
    );
  }
}
