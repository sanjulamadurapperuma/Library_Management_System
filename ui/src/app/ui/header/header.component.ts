import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  routes = [
    {linkName: 'Home', url: 'home'},
    { linkName: 'Add Item', url: 'add-item'},
    { linkName: 'Delete Item', url: 'delete-item'},
    { linkName: 'Display Item', url: 'display-item'},
    { linkName: 'Borrow Item', url: 'borrow-item'},
    { linkName: 'Return Item', url: 'return-item'},
    { linkName: 'Generate Report', url: 'generate-report'}
  ];

  constructor() {}

  ngOnInit() {
  }

}
