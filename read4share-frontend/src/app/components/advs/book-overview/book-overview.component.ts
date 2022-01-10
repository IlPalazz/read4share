import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-book-overview',
  templateUrl: './book-overview.component.html',
  styleUrls: ['./book-overview.component.css'],
})
export class BookOverviewComponent implements OnInit {
  @Input() title!: string;
  @Input() author!: string;
  @Input() coverUrl!: string;
  @Input() elementIndex!: number;
  @Input() selectedIndex!: number;

  @Output() onSelectBook: EventEmitter<any> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  onClick() {
    this.onSelectBook.emit(this.elementIndex);
  }
}
