import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-add-user-btn',
  templateUrl: './add-user-btn.component.html',
  styleUrls: ['./add-user-btn.component.css'],
})
export class AddUserBtnComponent implements OnInit {
  @Input() text!: string;
  @Input() color!: string;

  @Output() btnClick = new EventEmitter();
  constructor() {}

  ngOnInit(): void {}

  onClick(): void {
    this.btnClick.emit(); // Emit the event
  }
}
