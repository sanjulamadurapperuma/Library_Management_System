import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout/layout.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import { ReserveItemComponent } from './reserve-item/reserve-item.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  declarations: [LayoutComponent, HeaderComponent, FooterComponent, ReserveItemComponent],
  exports: [LayoutComponent]
})
export class UiModule { }
