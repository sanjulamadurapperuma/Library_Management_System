import {Component, EventEmitter, OnInit} from '@angular/core';
import {DeleteItemService} from "./delete-item.service";

@Component({
  selector: 'app-delete-item',
  templateUrl: './delete-item.component.html',
  styleUrls: ['./delete-item.component.css']
})
export class DeleteItemComponent implements OnInit {
  successMsg: string = null;
  isSuccess: boolean;
  bookFreeSpace: string;
  dvdFreeSpace: string;

  constructor(private _deleteItemService: DeleteItemService) {
    this.getFreeSpaceBook();
    this.getFreeSpaceDVD();
  }

  ngOnInit() {
  }

  deleteItem(form){
    this._deleteItemService.deleteItem(form.value["ISBN"]).subscribe(
      data => {
        if ("Book" != data.toString() || "DVD" != data.toString() ) {
          this.successMsg = data.toString();
          this.isSuccess = false;
          form.resetForm();
        } else {
          this.successMsg = "Successfully deleted a " + data + " item";
          this.isSuccess = true;
          form.resetForm();
        }
      },
      error => console.log('Error', error)
    );
  }

  getFreeSpaceBook() {
    this._deleteItemService.getFreeSpaceBook().subscribe(
      data => {
        this.bookFreeSpace = data.toString();
      },
      error => console.log('Error', error)
    );
  }

  getFreeSpaceDVD() {
    this._deleteItemService.getFreeSpaceDVD().subscribe(
      data => {
        this.dvdFreeSpace = data.toString();
      },
      error => console.log('Error', error)
    );
  }
}
