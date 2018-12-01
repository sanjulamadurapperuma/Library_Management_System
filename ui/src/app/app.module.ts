import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {Route, RouterModule, Routes} from '@angular/router';
import {FormsModule} from "@angular/forms";
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { RouteExampleComponent } from './route-example/route-example.component';

import { AppService } from './app.service';
import { AppHttpInterceptorService } from './http-interceptor.service';
import {AddItemComponent} from "./ui/add-item/add-item.component";
import {DeleteItemComponent} from "./ui/delete-item/delete-item.component";
import {BorrowItemComponent} from "./ui/borrow-item/borrow-item.component";
import {DisplayItemComponent} from "./ui/display-item/display-item.component";
import {GenerateReportComponent} from "./ui/generate-report/generate-report.component";
import {HomeComponent} from "./ui/home/home.component";
import {ReturnItemComponent} from "./ui/return-item/return-item.component";
import {UiModule} from "./ui/ui.module";

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'add-item',
    component: AddItemComponent,
  },
  {
    path: 'delete-item',
    component: DeleteItemComponent,
  },
  {
    path: 'display-item',
    component: DisplayItemComponent,
  },
  {
    path: 'borrow-item',
    component: BorrowItemComponent,
  },
  {
    path: 'return-item',
    component: ReturnItemComponent,
  },
  {
    path: 'generate-report',
    component: GenerateReportComponent,
  },
  {
    path: '**',
    redirectTo: '/home',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    RouteExampleComponent,
    AddItemComponent,
    DeleteItemComponent,
    BorrowItemComponent,
    DisplayItemComponent,
    GenerateReportComponent,
    HomeComponent,
    ReturnItemComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'Csrf-Token',
      headerName: 'Csrf-Token',
    }),
    RouterModule.forRoot(routes),
    FormsModule,
    UiModule
  ],
  providers: [
    AppService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
