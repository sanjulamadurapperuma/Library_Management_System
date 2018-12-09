import {Component, EventEmitter, OnInit} from '@angular/core';
import {ReturnItemService} from "./return-item.service";


@Component({
  selector: 'app-return-item',
  templateUrl: './return-item.component.html',
  styleUrls: ['./return-item.component.css']
})
export class ReturnItemComponent implements OnInit {
  successMsg: string = null;
  errMsg: string = null;
  feeMsg: string = null;
  isSuccess: boolean;

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
            this.errMsg = "The item has not been borrowed or is not available";
            this.isSuccess = false;
            frm.resetForm();
        } else {
          this.errMsg = data.toString();
          this.isSuccess = false;
          frm.resetForm();
        }
      },
      error => console.log('Error', error)
    );

    this._returnItemService.calculateFee(frm.value["ISBN"]).subscribe(
      data => {
          this.feeMsg = data.toString();
      },
      error => console.log('Error', error)
    );
  }
}
