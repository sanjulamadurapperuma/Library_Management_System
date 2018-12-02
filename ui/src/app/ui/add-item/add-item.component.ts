import {Component, EventEmitter, OnInit} from '@angular/core';
import {AddItemService} from './add-item.service';
import {Book} from "../../book";
import {DVD} from "../../dvd";

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {
  successMsg: string = null;
  isSuccess: boolean;
  bookFreeSpace: string;
  dvdFreeSpace: string;
  item: any;
  options: boolean;
  book: Book;
  dvd: DVD;

  constructor(private _addItemService: AddItemService) {
    this.options = true;
    this.getFreeSpaceBook();
    this.getFreeSpaceDVD();
  }

  ngOnInit() {
  }

  addItemBook(formBook) {
    this.book = new Book(formBook.value["ISBN"], formBook.value["Title"], formBook.value["Sector"],
      formBook.value["PublicationDate"], formBook.value["AuthorName"], formBook.value["PublisherName"],
      formBook.value["NumberOfPages"]);
    this._addItemService.addBook(this.book).subscribe(
      data => {
        this.successMsg = "Successfully added the Book";
        this.isSuccess = true;
        formBook.resetForm();
      },
      error => console.log('Error', error)
    );
  }

  addItemDVD(formDVD) {
    this.dvd = new DVD(formDVD.value["ISBN"], formDVD.value["Title"], formDVD.value["Sector"],
      formDVD.value["PublicationDate"], formDVD.value["Language"], formDVD.value["Subtitle"],
      formDVD.value["ProducerName"], formDVD.value["ActorName"]);
    this._addItemService.addDVD(this.dvd).subscribe(
      data => {
        this.successMsg = "Successfully added the DVD";
        this.isSuccess = true;
        formDVD.resetForm();
      },
      error => console.log('Error', error)
    );
  }

  getFreeSpaceBook() {
    this._addItemService.getFreeSpaceBook().subscribe(
      data => {
        this.bookFreeSpace = data.toString();
      },
      error => console.log('Error', error)
    );
  }

  getFreeSpaceDVD() {
    this._addItemService.getFreeSpaceDVD().subscribe(
      data => {
        this.dvdFreeSpace = data.toString();
      },
      error => console.log('Error', error)
    );
  }
}
