import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout/layout.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AddItemComponent } from './add-item/add-item.component';
import { BorrowItemComponent } from './borrow-item/borrow-item.component';
import { DeleteItemComponent } from './delete-item/delete-item.component';
import { DisplayItemComponent } from './display-item/display-item.component';
import { ReturnItemComponent } from './return-item/return-item.component';
import { GenerateReportComponent } from './generate-report/generate-report.component';
import {RouterModule} from "@angular/router";
import { HomeComponent } from './home/home.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  declarations: [LayoutComponent, HeaderComponent, FooterComponent,
    AddItemComponent, BorrowItemComponent, DeleteItemComponent,
    DisplayItemComponent, ReturnItemComponent,
    GenerateReportComponent, HomeComponent],
  exports: [LayoutComponent]
})
export class UiModule { }
