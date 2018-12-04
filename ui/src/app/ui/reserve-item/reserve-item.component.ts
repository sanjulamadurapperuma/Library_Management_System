import { Component, OnInit } from '@angular/core';
import {ReserveItemService} from "./reserve-item.service";
import {Reserve} from "../../reserve";

@Component({
  selector: 'app-reserve-item',
  templateUrl: './reserve-item.component.html',
  styleUrls: ['./reserve-item.component.css']
})
export class ReserveItemComponent implements OnInit {
  reservedItem: any;
  successMsg: string;
  isSuccess: boolean;
  reserveMsg: string = null;

  constructor(private _reserveItemService: ReserveItemService) { }

  ngOnInit() {
  }

  reserveItem(frm) {
    this.reservedItem = new Reserve(frm.value["ISBN"], frm.value["ReaderId"]);
    this._reserveItemService.reserveItem(this.reservedItem).subscribe(
      data => {
        this.successMsg = "Successfully reserved the item";
        this.isSuccess = true;
        frm.resetForm();
      },
      error => console.log('Error', error)
    );
  }

}
