import { Component, OnInit } from '@angular/core';
import {BorrowItemService} from "../borrow-item/borrow-item.service";
import {ReserveItemService} from "./reserve-item.service";

@Component({
  selector: 'app-reserve-item',
  templateUrl: './reserve-item.component.html',
  styleUrls: ['./reserve-item.component.css']
})
export class ReserveItemComponent implements OnInit {
  isSuccess: boolean;
  reserveMsg: string = null;

  constructor(private _reserveItemService: ReserveItemService) { }

  ngOnInit() {
  }

  reserveItem(frm){

  }

}
