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
  errMsg: string = null;
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
        if ("available" == data.toString()) {
          this.successMsg = "Successfully returned the item";
          this.isSuccess = true;
          frm.resetForm();
        } else if ("notAvailable" == data.toString()) {
          this.errMsg = "The item is has not been borrowed or available";
          this.isSuccess = false;
          frm.resetForm();
        }
      },
      error => console.log('Error', error)
    );
  }
}
