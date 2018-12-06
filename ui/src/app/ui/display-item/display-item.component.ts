import { Component, OnInit } from '@angular/core';
import {DisplayItemService} from "./display-item.service";

@Component({
  selector: 'app-display-item',
  templateUrl: './display-item.component.html',
  styleUrls: ['./display-item.component.css']
})
export class DisplayItemComponent implements OnInit {

  items: any;
  itemAvailable: boolean = null;
  errorMsg: String = null;
  searchLibItem: any = null;

  constructor(private _displayItemService: DisplayItemService) {
    this.displayItems();
  }

  ngOnInit() {
  }

  displayItems() {
    this._displayItemService.returnDetails().subscribe(
      data => {
        this.items = data;
      },
      error => console.log('Error', error)
    );
  }

  searchItem(formSearch) {
    this._displayItemService.searchItem(formSearch.value["ISBN"]).subscribe(
      data => {
        if ("notAvailable" == data.toString()) {
          //If returned string is 'notAvailable'
          this.errorMsg = "This item does not exist in the library";
          this.itemAvailable = false;
        } else {
          //If relevant record found, then set value to searchLibItem
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
