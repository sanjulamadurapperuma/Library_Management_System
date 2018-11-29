import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FormsModule} from "@angular/forms";
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { RouteExampleComponent } from './route-example/route-example.component';

import { AppService } from './app.service';
import { AppHttpInterceptorService } from './http-interceptor.service';
import { LayoutComponent } from './ui/layout/layout.component';
import { HeaderComponent } from './ui/header/header.component';
import { FooterComponent } from './ui/footer/footer.component';
import {AddItemComponent} from "./ui/add-item/add-item.component";
import {DeleteItemComponent} from "./ui/delete-item/delete-item.component";
import {BorrowItemComponent} from "./ui/borrow-item/borrow-item.component";
import {DisplayItemComponent} from "./ui/display-item/display-item.component";
import {GenerateReportComponent} from "./ui/generate-report/generate-report.component";

const routes: Routes = [
  {
    path: 'home',
    component: RouteExampleComponent,
  },
  {
    path: 'add-item',
    component: RouteExampleComponent,
  },
  {
    path: 'delete-item',
    component: RouteExampleComponent,
  },
  {
    path: 'display-item',
    component: RouteExampleComponent,
  },
  {
    path: 'borrow-item',
    component: RouteExampleComponent,
  },
  {
    path: 'return-item',
    component: RouteExampleComponent,
  },
  {
    path: 'generate-report',
    component: RouteExampleComponent,
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
    LayoutComponent,
    HeaderComponent,
    FooterComponent,
    AddItemComponent,
    DeleteItemComponent,
    BorrowItemComponent,
    DisplayItemComponent,
    GenerateReportComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'Csrf-Token',
      headerName: 'Csrf-Token',
    }),
    RouterModule.forRoot(routes),
    FormsModule
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
