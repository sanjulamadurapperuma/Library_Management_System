import {Component, EventEmitter, OnInit} from '@angular/core';
import {
  AbstractControl,
  AbstractFormGroupDirective,
  Form,
  FormControl,
  FormGroup,
  NgControl,
  NgModel,
  NgModelGroup, ValidationErrors
} from "@angular/forms";
import {FormHooks} from "@angular/forms/src/model";
import {Observable} from "rxjs";
import {DeleteItemService} from "./delete-item.service";

@Component({
  selector: 'app-delete-item',
  templateUrl: './delete-item.component.html',
  styleUrls: ['./delete-item.component.css']
})
export class DeleteItemComponent implements OnInit {
  successMsg: string = null;
  isSuccess: boolean;
  item: any;

  constructor(private _deleteItemService: DeleteItemService) { }

  ngOnInit() {
  }

  deleteItem(form){

  }
}
