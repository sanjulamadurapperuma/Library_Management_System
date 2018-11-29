import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddItemComponent } from './ui/add-item/add-item.component';
import { DeleteItemComponent } from './ui/delete-item/delete-item.component';
import { DisplayItemComponent } from './ui/display-item/display-item.component';
import { BorrowItemComponent } from './ui/borrow-item/borrow-item.component';
import { ReturnItemComponent } from './ui/return-item/return-item.component';
import { GenerateReportComponent } from './ui/generate-report/generate-report.component';
import {LayoutComponent} from "./ui/layout/layout.component";

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: LayoutComponent},
  {path: 'add-item', component: AddItemComponent},
  {path: 'delete-item', component: DeleteItemComponent},
  {path: 'display-item', component: DisplayItemComponent},
  {path: 'borrow-item', component: BorrowItemComponent},
  {path: 'return-item', component: ReturnItemComponent},
  {path: 'generate-report', component: GenerateReportComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
