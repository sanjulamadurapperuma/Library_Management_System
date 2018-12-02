import {Component, EventEmitter, OnInit} from '@angular/core';
import {AddItemService} from './add-item.service';
import {Book} from "../../book";

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
    console.log(this.book);
    formBook.resetForm();
  }

  addItemDVD(formDVD) {
    this.successMsg = "Successfully added the DVD";
    this.isSuccess = true;
    console.log(formDVD.value);
    formDVD.resetForm();
  }
}
