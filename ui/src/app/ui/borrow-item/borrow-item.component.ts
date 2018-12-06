import {Component, EventEmitter, OnInit} from '@angular/core';
import {BorrowItemService} from "./borrow-item.service";
import {Borrow} from "../../borrow";
import {Router} from "@angular/router";

@Component({
  selector: 'app-borrow-item',
  templateUrl: './borrow-item.component.html',
  styleUrls: ['./borrow-item.component.css']
})
export class BorrowItemComponent implements OnInit {
  successMsg: string = null;
  errMsg: string = null;
  reserveMsg: string = null;
  reserveOk: boolean;
  isSuccess: boolean;
  item: any;
  options: boolean;
  borrowedItem: Borrow;

  constructor(private _borrowItemService: BorrowItemService, private router: Router) { }

  ngOnInit() {
  }

  borrowItem(frm) {
    this.borrowedItem = new Borrow(frm.value["ISBN"], frm.value["ReaderId"]);
    //Return values of the ISBN and the Reader ID that has been entered into the form
    this._borrowItemService.borrowItem(this.borrowedItem).subscribe(
      data => {
        if ("available" == data.toString()) {
          this.successMsg = "Successfully borrowed the item";
          this.isSuccess = true;
          this.reserveOk = false;
          frm.resetForm();
        } else if ("alreadyBorrowed" == data.toString() || "overdue" == data.toString()) {
            this.errMsg = "The item is already borrowed by another person";
            this.isSuccess = false;
            this.reserveOk = true;
            this.reserveMsg = "Do you want to reserve this item?";
            frm.resetForm();
        } else {
          this.errMsg = "This item is currently borrowed. " + data.toString();
          this.isSuccess = false;
          this.reserveOk = true;
          this.reserveMsg = "Do you want to reserve this item?";
          frm.resetForm();
        }
      },
      error => console.log('Error', error)
    );
    //Subscribe to the borrow item service and retrieve data gained from the
    // functions in WestminsterLibraryManager
  }

  btnClick(){
    this.router.navigateByUrl('reserve-item');
  }

}
