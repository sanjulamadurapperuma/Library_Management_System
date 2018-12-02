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
  item: any;
  options: boolean;
  book: Book;
  dvd: DVD;

  constructor(private _addItemService: AddItemService) {
    this.options = true;
  }

  ngOnInit() {
  }

  addItemBook(formBook) {
    this.book = new Book(formBook.value["ISBN"], formBook.value["Title"], formBook.value["Sector"],
      formBook.value["PublicationDate"], formBook.value["AuthorName"], formBook.value["PublisherName"],
      formBook.value["NumberOfPages"]);
    this._addItemService.addBook(this.book).subscribe(
      data => console.log('Success', data),
      error => console.log('Error', error)
    );
    this.successMsg = "Successfully added the Book";
    this.isSuccess = true;
    formBook.resetForm();
  }

  addItemDVD(formDVD) {
    this.dvd = new DVD(formDVD.value["ISBN"], formDVD.value["Title"], formDVD.value["Sector"],
      formDVD.value["PublicationDate"], formDVD.value["Language"], formDVD.value["Subtitle"],
      formDVD.value["ProducerName"], formDVD.value["ActorName"]);
    this._addItemService.addDVD(this.dvd).subscribe(
      data => console.log('Success', data),
      error => console.log('Error', error)
    );
    this.successMsg = "Successfully added the DVD";
    this.isSuccess = true;
    formDVD.resetForm();
  }
}
