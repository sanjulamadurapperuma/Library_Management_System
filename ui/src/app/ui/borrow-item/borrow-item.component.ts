import {Component, EventEmitter, OnInit} from '@angular/core';
import {BorrowItemService} from "./borrow-item.service";
import {Borrow} from "../../borrow";

@Component({
  selector: 'app-borrow-item',
  templateUrl: './borrow-item.component.html',
  styleUrls: ['./borrow-item.component.css']
})
export class BorrowItemComponent implements OnInit {
  successMsg: string = null;
  errMsg: string = null;
  isSuccess: boolean;
  item: any;
  options: boolean;
  borrowedItem: Borrow;

  constructor(private _borrowItemService: BorrowItemService) { }

  ngOnInit() {
  }

  borrowItem(frm) {
    this.borrowedItem = new Borrow(frm.value["ISBN"], frm.value["ReaderId"]);
    this._borrowItemService.borrowItem(this.borrowedItem).subscribe(
      data => {
        if ("available" == data.toString()) {
          this.successMsg = "Successfully borrowed the item";
          this.isSuccess = true;
          frm.resetForm();
        } else if ("alreadyBorrowed" == data.toString()) {
          this.errMsg = "The item is already borrowed by another person";
          this.isSuccess = false;
          frm.resetForm();
        }
      },
      error => console.log('Error', error)
    );
  }
}
