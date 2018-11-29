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

@Component({
  selector: 'app-borrow-item',
  templateUrl: './borrow-item.component.html',
  styleUrls: ['./borrow-item.component.css']
})
export class BorrowItemComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  borrowItem(frm: {submitted: boolean; _directives; form: FormGroup; ngSubmit: EventEmitter<{}>; options: {updateOn?: FormHooks}; ngAfterViewInit: {(): void; (): void}; formDirective: Form; control: FormGroup; path: string[]; controls: {[p: string]: AbstractControl}; addControl: {(dir: NgModel): void; (dir: NgControl): void}; getControl: {(dir: NgModel): FormControl; (dir: NgControl): FormControl}; removeControl: {(dir: NgModel): void; (dir: NgControl): void}; addFormGroup: {(dir: NgModelGroup): void; (dir: AbstractFormGroupDirective): void}; removeFormGroup: {(dir: NgModelGroup): void; (dir: AbstractFormGroupDirective): void}; getFormGroup: {(dir: NgModelGroup): FormGroup; (dir: AbstractFormGroupDirective): FormGroup}; updateModel: {(dir: NgControl, value: any): void; (dir: NgControl, value: any): void}; setValue(value: {[p: string]: any}): void; onSubmit($event: Event): boolean; onReset(): void; resetForm(value?: any): void; _setUpdateStrategy; name: string; value: any; valid: boolean | null; invalid: boolean | null; pending: boolean | null; disabled: boolean | null; enabled: boolean | null; errors: ValidationErrors | null; pristine: boolean | null; dirty: boolean | null; touched: boolean | null; status: string | null; untouched: boolean | null; statusChanges: Observable<any> | null; valueChanges: Observable<any> | null; reset(value?: any): void; hasError(errorCode: string, path?: string[]): boolean; getError(errorCode: string, path?: string[]): any}) {

  }
}
